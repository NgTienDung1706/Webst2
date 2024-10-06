package vn.iotstar.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import static vn.iotstar.utils.Constant.*;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.services.impl.CategoryServiceImpl;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	maxFileSize = 1024 * 1024 * 10, // 10MB
	maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(urlPatterns = {"/admin/categories","/admin/category/add","/admin/category/insert","/admin/category/edit","/admin/category/update"})
public class CategoryController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public CategoryServiceImpl cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();
        if(url.contains("/admin/categories")){
            List<CategoryModel> list = cateService.findAll();
            req.setAttribute("listCate", list);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
        }
        else if(url.contains("/admin/category/add")){
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/edit")) {
            int id  = Integer.parseInt(req.getParameter("id"));
            CategoryModel category = cateService.findById(id);
            req.setAttribute("cate", category);
            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
        }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getRequestURI();

        // Handle insert logic
        if (url.contains("/admin/category/insert")) {
            String categoryName = req.getParameter("categoryname");
            String status = req.getParameter("status");
            int statuss = Integer.parseInt(status);
            // Tạo đối tượng CategoryModel và gán giá trị
            CategoryModel category = new CategoryModel();
            category.setCategoryname(categoryName);
            category.setStatus(statuss);
         // Xử lý upload ảnh
            String fname = "";
            String uploadPath = UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            try {
                Part part = req.getPart("images");	
                if (part != null && part.getSize() > 0) {
                    String fileName =Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    int index = fileName.lastIndexOf(".");
                    String ext = fileName.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + ext;
                    part.write(uploadPath + "/" + fname);
                    category.setImages(fname);
                } else {
                	category.setImages("avatar.png");	
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Thêm danh mục vào cơ sở dữ liệu
            cateService.insert(category);

            // Chuyển hướng về danh sách danh mục
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
        // Handle update logic
        else if (url.contains("/admin/category/update")) {
            int categoryId = Integer.parseInt(req.getParameter("categoryid"));
            String categoryName = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));
//            String image = req.getParameter("image");
            CategoryModel category = new CategoryModel();
            category.setCategoryid(categoryId);
            category.setCategoryname(categoryName);
            category.setStatus(status);
            // Lấy hình cũ
            CategoryModel cateold = cateService.findById(categoryId);
            String fileold = cateold.getImages();
            // Xử lý ảnh upload khi cập nhật
            String fname = null;
            String uploadPath = UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            try {
                Part part = req.getPart("image1");
                if (part != null && part.getSize() > 0) {
                    String fileName = part.getSubmittedFileName();
                    int index = fileName.lastIndexOf(".");
                    String ext = fileName.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + ext;
                    part.write(uploadPath + "/" + fname);
                    category.setImages(fname);
                } else {
                	category.setImages(fileold	);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Cập nhật danh mục
            cateService.update(category);

            // Chuyển hướng về danh sách danh mục
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
	}

}
