package com.groupeisi.company.controllers;

import com.groupeisi.company.config.HibernateUtil;
import com.groupeisi.company.dto.AccountDto;
import com.groupeisi.company.services.impl.AccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.groupeisi.company.services.impl.IAccountService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="login", value = "/login")
public class LoginController extends HttpServlet {

    private IAccountService accountService;
    private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        accountService = new AccountServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("auth") != null){
            if (req.getParameter("auth").equals("no")){
                req.setAttribute("message", "Email ou mot de passe incorect.");
            }
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try{

            AccountDto accountDto = accountService.login(email, password);
            if (accountDto != null) {
                req.getSession().setAttribute("account", accountDto);
                resp.sendRedirect(req.getContextPath()+"/welcome");
            }else {
                resp.sendRedirect(req.getContextPath()+"/login?auth=no");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
