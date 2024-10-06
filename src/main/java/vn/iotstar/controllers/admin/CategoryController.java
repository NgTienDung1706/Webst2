package vn.iotstar.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.model.CategotyModel;
import vn.iotstar.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/admin/categories"})
public class CategoryController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public CategoryServiceImpl cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		List<CategotyModel> list = cateService.findAll();
		req.setAttribute("listcate", list);
		req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req,resp);
	}
}
