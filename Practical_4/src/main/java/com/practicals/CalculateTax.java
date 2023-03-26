package com.practicals;
import java.io.*;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculateTax
 */
public class CalculateTax extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final double TAX_RATE = 0.1;
	  
	  @Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    
	    // Read input parameters
	    String name = request.getParameter("name");
	    int age = Integer.parseInt(request.getParameter("age"));
	    String gender = request.getParameter("gender");
	    String address = request.getParameter("address");
	    double income = Double.parseDouble(request.getParameter("income"));
	    
	    // Calculate tax
	    double tax = income * TAX_RATE;
	    
	    // Generate response
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>Income Tax Calculator</title></head>");
	    out.println("<body>");
	    out.println("<h1>Income Tax Calculator Results</h1>");
	    out.println("<p>Name: " + name + "</p>");
	    out.println("<p>Age: " + age + "</p>");
	    out.println("<p>Gender: " + gender + "</p>");
	    out.println("<p>Address: " + address + "</p>");
	    out.println("<p>Income: $" + income + "</p>");
	    out.println("<p>Tax: $" + tax + "</p>");
	    out.println("</body>");
	    out.println("</html>");
	  }

}
