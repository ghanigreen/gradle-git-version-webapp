package io.github.skomarica.contrib.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class VersionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		properties.load(classLoader.getResourceAsStream("version.properties"));

		Gson gson = new Gson();
		String jsonStr = gson.toJson(properties);

		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(jsonStr);
		out.flush();
	}

}
