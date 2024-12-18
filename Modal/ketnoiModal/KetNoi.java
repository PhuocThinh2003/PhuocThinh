package ketnoiModal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoi {
	public Connection cn;
	public void KetNoi() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://PhuocThinh:1433;databaseName=QuanLySach;user=sa; password=123";
		cn = DriverManager.getConnection(url);
		System.out.print("Da ket noi");
		
	}
}
