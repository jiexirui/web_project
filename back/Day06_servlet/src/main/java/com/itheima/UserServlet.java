package com.itheima;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        StringBuffer requestURL = req.getRequestURL();
        System.out.println("URL地址 = " + requestURL);

        String requestURI = req.getRequestURI();
        System.out.println("URI地址 = " + requestURI);

        String header = req.getHeader("User-Agent");
        System.out.println("请求头 = " + header);

        String protocol = req.getProtocol();
        System.out.println("协议 = " + protocol);

        String method = req.getMethod();
        System.out.println("请求方式 = " + method);

        String content = "Hello Tom";
        resp.getWriter().write(content);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
