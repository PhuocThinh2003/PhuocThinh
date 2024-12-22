﻿using Dapper;
using SV21T1020725.DomainModels;

namespace SV21T1020725.DataLayers.SQLServer
{
    public class ShipperDAL : BaseDAL, ICommonDAL<Shipper>
    {
        public ShipperDAL(string connectionString) : base(connectionString)
        {
        }

        public int Add(Shipper data)
        {
            int id = 0;
            using (var connection = OpenConnection())
            {
                string sql = @"if exists(select * from Shippers where Phone = @Phone)
                                select -1
                            else
                                begin
                                   insert into Shippers(ShipperName, Phone)
                                    values(@ShipperName, @Phone)
                                    select scope_identity();
                                end";
                var parameters = new 
                { 
                    ShipperName = data.ShipperName??"", 
                    Phone = data.Phone ??"",
                };
                id = connection.ExecuteScalar<int>(sql: sql, param: parameters, commandType: System.Data.CommandType.Text);
                connection.Close();
            }
            return id;
        }

        public int Count(string searchValue = "")
        {
            int count = 0;
            searchValue = $"%{searchValue}%";
            using (var connection = OpenConnection())
            {
                var sql = @"select count(*)
                            from Shippers
                            where (ShipperName like @searchValue)";
                var parameters = new
                {
                    searchValue     //Viết tắt của: searchValue = searchValue
                };
                count = connection.ExecuteScalar<int>(sql: sql, param: parameters, commandType: System.Data.CommandType.Text);
                connection.Close();
            }

            return count;
        }

        public bool Delete(int id)
        {
            bool result = false;
            using (var connection = OpenConnection())
            {
                var sql = @"delete from Shippers where ShipperID = @ShipperID";
                var parameters = new
                {
                    ShipperID = id,
                };
                result = connection.Execute(sql: sql, param: parameters, commandType: System.Data.CommandType.Text) > 0;
                connection.Close();
            }
            return result;
        }

        public Shipper? Get(int id)
        {
            Shipper? shipper = null;
            using (var connection = OpenConnection())
            {
                string sql = @" select * from Shippers
                        where (ShipperID = @ShipperID)";
                var parameters = new { ShipperID = id };
                shipper = connection.QueryFirstOrDefault<Shipper>(sql: sql, param: parameters, commandType: System.Data.CommandType.Text);
                connection.Close();
            }
            return shipper;
        }

        public bool InUsed(int id)
        {
            bool result = false;
            using (var conn = OpenConnection())
            {
                var sql = @"if exists(select * from Orders where ShipperID = @ShipperID)
                                select 1
                            else
                                select 0;";
                var parameters = new { ShipperID = id };
                result = conn.ExecuteScalar<bool>(sql: sql, param: parameters, commandType: System.Data.CommandType.Text);
                conn.Close();
            }
            return result;
        }

        public List<Shipper> List(int page = 1, int pageSize = 0, string searchValue = "")
        {
            List<Shipper> data = new List<Shipper>();
            searchValue = $"%{searchValue}%";
            using (var connection = OpenConnection())
            {
                var sql = @"select *
                            from	(
		                                select *,
				                            row_number() over(order by ShipperName) as RowNumber
		                                from	Shippers
		                                where	(ShipperName like @searchValue)
		                            ) as t
                            where	(@pageSize = 0)
	                            or	(t.RowNumber between(@page - 1) *  @pageSize + 1 and @page * @pageSize)
                            order by RowNumber";
                var parameters = new
                {
                    page = page,    //Bên trái: tên của tham số trong câu lệnh SQL, Bên phải: Giá trị truyền tham số
                    pageSize = pageSize,
                    searchValue = searchValue
                };
                data = connection.Query<Shipper>(sql: sql, param: parameters, commandType: System.Data.CommandType.Text).ToList();
                connection.Close();
            }
            return data;
        }

        public bool Update(Shipper data)
        {
            bool result = false;
            using (var connection = OpenConnection())
            {
                string sql = @"update Shippers
                                set ShipperName = @ShipperName,
                                    Phone = @Phone
                                where ShipperID = @ShipperID";
                var parameters = new 
                { 
                    ShipperName = data.ShipperName ?? "", 
                    Phone = data.Phone??"", 
                    ShipperId = data.ShipperID 
                };
                result = connection.Execute(sql: sql, param: parameters, commandType: System.Data.CommandType.Text) > 0;
                connection.Close();
            }
            return result;
        }
        public List<Shipper> GetAll()
        {
            throw new NotImplementedException();
        }
    }
}