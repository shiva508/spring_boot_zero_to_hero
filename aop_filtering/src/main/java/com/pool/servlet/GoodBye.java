package com.pool.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;

import com.google.gson.Gson;

@WebServlet(name = "goodBye", description = "Example Servlet Using Annotations", urlPatterns = { "/goodBye" })
public class GoodBye extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	CustomnResponse response=new CustomnResponse().setCode("508").setMessage("GoodBye");
	resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
	String data=new Gson().toJson(response);
	resp.getWriter().print(data);
}
}
