package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;

@WebServlet(urlPatterns = "/forgotpassword")
public class ForgotPasswordController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/forgotpassword.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String email = req.getParameter("email");
        IUserService service = new UserService();
        String alertMsg = "";

        // Kiểm tra email có tồn tại
        boolean emailExists = service.checkExistEmail(email);
        if (!emailExists) {
            alertMsg = "Email không tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
            return;
        }

        // Nếu email tồn tại, yêu cầu nhập lại mật khẩu mới
        req.getSession().setAttribute("resetEmail", email); // Lưu email vào session
        req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
	}
}
