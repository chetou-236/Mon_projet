package com.groupeisi.company.controllers;

import com.groupeisi.company.dto.AccountDto;
import com.groupeisi.company.services.impl.AccountServiceImpl;
import com.groupeisi.company.services.impl.IAccountService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "admin" , value = "/admin")
public class AdminController extends HttpServlet {

    private IAccountService accountService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        accountService = new AccountServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AccountDto> accountDtoList = accountService.getAllAccounts();
        req.setAttribute("accountDtoList", accountDtoList);
        req.getRequestDispatcher("/WEB-INF/jsp/admin/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
