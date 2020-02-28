package servlet_unit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import beans_unit.*;
import database_unit.DatabaseOne;
import recognition_and_initialization_unit.*;

/**
 * ServletStandartMode предназначен для:
 * ...
 * @author user
 */
@WebServlet("/ServletStandartMode")
public class ServletStandartMode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String addressSaga = "D:\\saga.txt";
	FrameDay day;
	SortDay generalEntity;
	
	public ServletStandartMode() {
		super();
    }
	
	/**
	 * doPost содержит 2 логических процесса
	 * first: распознавание пользовательского текста с html-страницы
	 * и формирование отчета за день (DayReport), с выводом его на html-страницу
	 * second: формирование истории в json-формате
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("..servlet_standart_mode ...method post");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");	
		initDay(request.getParameter("facture"));	//..first logical process
		response.getWriter().write(getDayReport());

		engageSaga();	//..second logical process
		System.out.println("..module PrintCashCheck <off>");	//..module PrintCashCheck, third logical process
		System.out.println("..module connectionDataBase");	//..fouth logical process
		toDataBase(request.getParameter("facture"));
		System.out.println("..end servlet_standart_mode");	//..for consol desing
		System.out.println();
	}
	
	private void initDay(String webText) throws IOException {
		this.day = new Day();
		new Recognize(webText, day);
	}

	private String getDayReport() throws IOException {
		int something = 1;
		SortDay<Integer> sortDay = new SortDay<Integer>(something);	//..creating an object
		generalEntity = sortDay;
//		ArrayList<String> sample = new ArrayList<String>();
//		SortDay_x<ArrayList<String>> sd = new SortDay_x<ArrayList<String>>(sample);
		
		new DeepRecognize(sortDay, day);
		Gson newJson = new Gson();
		String result = newJson.toJson(sortDay);
		return result;
	}
	
	private void engageSaga() throws IOException {
		Saga saga = new Saga(addressSaga);
		saga.addToSaga(day);
		System.out.println("lenght of array<Day>: " + saga.getSaga().length);
	}
	
	private void toDataBase(String webText) throws IOException {
		System.out.println("..toDataBase(marker!!!) ++	..new ParticularClass(oldApproach)");
		Buffer.setText(webText);
		SomeThread st = new SomeThread();
		st.start();
	}
	
}
