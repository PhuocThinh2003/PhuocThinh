package controller.admin.Product;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sachModal.Sach;
import sachModal.SachBO;




/**
 * Servlet implementation class CreateBookController
 */
@WebServlet("/SaveEditController")
public class SaveEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "image_sach";
		// response.getWriter().println(dirUrl1);
		 SachBO sBO = new SachBO();
		 Sach sach = new Sach();
		 Map<String, String> errors = new HashMap<String, String>();
		 boolean isUploaded = false;
		try {
			List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				 if (!fileItem.isFormField()) {
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "image_sach";
						File dir = new File(dirUrl);
						if (!dir.exists()) {
							dir.mkdir();
						}
					           String fileImg = dirUrl +File.separator + nameimg;
					           sach.setAnh("image_sach/"+ nameimg);
					           File file = new File(fileImg);//tạo file
					            try {
					               fileItem.write(file);//lưu file
					              System.out.println("UPLOAD THÀNH CÔNG...!");
					              System.out.println("Đường dẫn lưu file là: "+dirUrl);
					              isUploaded = true;
					 } catch (Exception e) {
					    e.printStackTrace();
					 	}
					}
				 }
				 else//Neu la control
				 {
					
					 String fieldName = fileItem.getFieldName(); 
					   
					    switch (fieldName) {
					    case "masach": 
				        	if(fileItem.getString() != null)
				        		sach.setMaSach(fileItem.getString("UTF-8"));
				            break;

					        case "tensach": 
					        	if(fileItem.getString() == null || fileItem.getString().trim().isEmpty() )
					        		errors.put("tensach", "Tên sách không được để trống");
					        	else {
					        		sach.setTenSach(fileItem.getString("UTF-8"));
					        	}
					            break;
					        case "tacgia": 
					        	if(fileItem.getString() == null || fileItem.getString().trim().isEmpty() )
					        		errors.put("tacgia", "Tác giả không được để trống");
					        	else {
					        		sach.setTacGia(fileItem.getString("UTF-8"));
					        	} 
					            break;
					        case "soluong": 
					        	String soluongStr = fileItem.getString().trim(); // Lấy giá trị và loại bỏ khoảng trắng
					            if (soluongStr.isEmpty()) {
					                errors.put("soluong", "Số lượng không được để trống.");
					            } else {
					                try {
					                    Long soluong = Long.parseLong(soluongStr);
					                    if (soluong <= 0) {
					                        errors.put("soluong", "Số lượng phải lớn hơn 0.");
					                    } else {
					                        sach.setSoLuong(soluong);
					                    }
					                } catch (NumberFormatException e) {
					                    errors.put("soluong", "Số lượng phải là một số nguyên hợp lệ.");
					                }
					            }
					            break;
					        case "giaban": 
					        	String giabanStr = fileItem.getString().trim(); // Lấy giá trị và loại bỏ khoảng trắng
					            if (giabanStr.isEmpty()) {
					                errors.put("giaban", "Giá bán không được để trống.");
					            } else {
					                try {
					                    Long giaban = Long.parseLong(giabanStr);
					                    if (giaban <= 0) {
					                        errors.put("giaban", "Giá bán phải lớn hơn 0.");
					                    } else {
					                        sach.setGiaBan(giaban);
					                    }
					                } catch (NumberFormatException e) {
					                    errors.put("giaban", "Giá bán phải là một số nguyên hợp lệ.");
					                }
					            }
					            break;
					        case "maloai": 
					            if (fileItem.getString().equals("0")) {
					                errors.put("maloai", "Vui lòng chọn mã loại.");
					            } else {
					               sach.setMaLoai(fileItem.getString("UTF-8"));
					            }
					            break;
					    }
					}
			 }
			
			if (!errors.isEmpty() || isUploaded == false) {
				if(isUploaded == false)
					errors.put("uploadfile", "Chua chon anh");
		        request.setAttribute("errors", errors);
		        request.setAttribute("sach", sach);
		        RequestDispatcher rd = request.getRequestDispatcher("ProductController?action=edit");
		        rd.forward(request, response);
		        return;
			}
			try {
				System.out.println(sach.toString());
				sBO.UpdateByID(sach);
				RequestDispatcher rd = request.getRequestDispatcher("ShowProductController");
			    rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().println("Lưu sách thất bại!");
			}
		
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
