package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;
import vn.iotstar.utils.Constant;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession session = req.getSession(false);
//		if (session != null && session.getAttribute("username") != null) {
//		resp.sendRedirect(req.getContextPath() + "/admin");
//		return;
		req.getRequestDispatcher("views/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmpassword");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		int roleid = 1;
		IUserService service = new UserService();
		String alertMsg ="";
		// Kiểm tra sự khớp của mật khẩu
	    if (!password.equals(confirmPassword)) {
	        alertMsg = "Mật khẩu và mật khẩu nhập lại không khớp!";
	        req.setAttribute("alert", alertMsg);
	        req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
	        return;
	    }

	    // Kiểm tra email và username đã tồn tại
	    if (service.checkExistEmail(email)) {
	        alertMsg = "Email đã tồn tại!";
	        req.setAttribute("alert", alertMsg);
	        req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
	        return;
	    }
	    if (service.checkExistUsername(username)) {
	        alertMsg = "Tài khoản đã tồn tại!";
	        req.setAttribute("alert", alertMsg);
	        req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
	        return;
	    }

	    // Thực hiện đăng ký nếu không có lỗi
	    boolean isSuccess = service.register(username, password, fullname, email, phone, roleid);
	    if (isSuccess) {
	        resp.sendRedirect(req.getContextPath() + "/login");
	    } else {
	        alertMsg = "System error!";
	        req.setAttribute("alert", alertMsg);
	        req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
	    }
	}
}
