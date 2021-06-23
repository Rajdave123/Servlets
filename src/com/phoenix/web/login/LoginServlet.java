package com.phoenix.web.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 * 
 * @author dave
 */
@WebServlet("/LoginS")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("username");
		String password = request.getParameter("password"); // taking parameter
															// values from form
															// data.

		System.out.println(name);
		System.out.println(password);

		PrintWriter out = response.getWriter(); // get printWrite obj

		if (name != null && password != null && name.equals("raj") && password.equals("raj123")) {

			RequestDispatcher reqDispacher = request.getRequestDispatcher("/welcome");

			reqDispacher.forward(request, response);

		} else {

			// out.println("<h1 style='color:red'>Invalid Credentials Please try
			// again!!!<h1>");
			// System.out.println("Invalid Credentials try again!!!");
			System.out.println("Invalid Login error...");
			// Invalid Credentials Please Try Again!

			RequestDispatcher reqDispacher = request.getRequestDispatcher("/login.html");
			reqDispacher.include(request, response);
			out.println(
					"<script> var err = document.querySelector('.err-text'); err.innerHTML = 'Invalid Credentials Please Try Again!'; </script>");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
