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

@WebServlet(urlPatterns = "/resetpassword")
public class ResetPasswordController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/resetpassword.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String newPassword = req.getParameter("newpassword");
        String confirmPassword = req.getParameter("confirmpassword");
        
        HttpSession session = req.getSession(false);
        String email = (String) session.getAttribute("resetEmail");
        
        IUserService service = new UserService();
        String alertMsg = "";

        // Kiểm tra mật khẩu mới và xác nhận
        if (!newPassword.equals(confirmPassword)) {
            alertMsg = "Mật khẩu và xác nhận mật khẩu không khớp.";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/resetpassword.jsp").forward(req, resp);
            return;
        }

        // Cập nhật mật khẩu
        service.updatePasswordByEmail(email, newPassword);
        resp.sendRedirect(req.getContextPath() + "/login");
     
	}
}
