package com.nghich.banned.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet(urlPatterns = {"/home", "*.jsp"})
public class SimpleServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String host = request.getHeader("Host");
        String contentType = request.getContentType();
        Map<String, String[]> parameterMap = request.getParameterMap();
        BufferedReader body = request.getReader();

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<head>");
        writer.println("<title>Request Information Example</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h3>This is SimpleServlet</h3>");
        writer.println("<h4>Host: " + host + "</h4>");
        writer.println("Method: " + request.getMethod());
        writer.println("Request URI: " + request.getRequestURI());
        writer.println("Protocol: " + request.getProtocol());
        writer.println("<h4>Content Type: " + contentType + "</h4>");
        parameterMap.forEach((key, value) -> writer.println("<h5>param {key: " + key + " value: " + Arrays.toString(value) + "} </h5>"));
        writer.println("<h5>Request body: " + body + "</h5>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
