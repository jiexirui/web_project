package com.itheima;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class ServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");//获取用户名
        System.out.println("username = " + username);
        String content = "<h1>hello:" + username + "</h1>";//响应内容
        resp.getWriter().write(content);//响应

        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        String method = req.getMethod();
        System.out.println("method = " + method);

        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL = " + requestURL);

        resp.setHeader("Content-Type", "text/html;charset=utf-8");//设置响应头
        resp.setStatus(200);//设置状态码
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
