package servlet_unit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import arduino_unit.PrintCashCheck;
import beans_unit.*;
import database_unit.DatabaseOne;
import recognition_and_initialization_unit.*;

/**
 * ServletArduino предназначен для:
 * ...
 * @author user
 */
@WebServlet("/ServletArduino")
public class ServletArduino extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ServletArduino() {
		super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("..servlet_arduino ...method post");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");	
		System.out.println("Arduino: " + request.getParameter("data_s"));
		
		if(request.getParameter("data_s").equals("true")) {
			PrintCashCheck pcc = new PrintCashCheck();
			pcc.start();
		}
	}
	
}