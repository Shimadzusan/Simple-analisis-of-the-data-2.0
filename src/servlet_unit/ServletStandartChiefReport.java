package servlet_unit;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans_unit.*;
import recognition_and_initialization_unit.*;


@WebServlet("/ServletStandartChiefReport")
public class ServletStandartChiefReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public ServletStandartChiefReport() {
			super();
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("..servlet_standart_chief_report ...method post");		
		request.setCharacterEncoding("utf-8");
	
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String json_from_js = request.getParameter("data_s");
		System.out.println("servlet_standart_chief_report: " + json_from_js);
		
//..deals analisis
		response.getWriter().write(getHtmlTable());
		System.out.println("..end servlet_standart_chief_report");
	}

	private String getHtmlTable() {
		ArrayList<Day> day_interval = Buffer.getFinal_list();
		
		String html = "<div style=\"overflow: auto; height: 350px\"><table style=\"width: 95%; font-size: 9pt\">";
//..general cycle
		for(int i = 0; i < day_interval.size(); i++) {
			ArrayList<String> something = new ArrayList<String>();
			SortDay<ArrayList<String>> sort_day = new SortDay<ArrayList<String>>(something);
			new DeepRecognize(sort_day, day_interval.get(i));//uses for extract "other"
			
			html += "<tr><td>дата</td><td>фнд</td><td>копия</td><td>печать</td><td>багет</td>"
					+ "<td>фотолаб</td><td>сфера</td><td>другое</td><td>на карту</td><td>за услугу</td>"
					+ "<td>расходы</td><td>категория</td><td>итого</td><td>ником</td><td>пульты</td>"
					+ "<td>всего</td><td>з\\п</td><td>касса утро</td><td>касса вечер</td></tr>";
//..end tables head			
			html += "<tr style=\"vertical-align: top\"><td>" + sort_day.getDate() + "</td>"
					+ "<td>\t" + getFormat(sort_day.getFoto()) + "</td><td>\t" + getFormat(sort_day.getCopy()) + "</td>"
					+ "<td>" + getFormat(sort_day.getPrint()) + "</td><td>" + getFormat(sort_day.getBaget()) + "</td>"
					+ "<td>" + getFormat(sort_day.getFotolab()) + "</td><td>" + getFormat(sort_day.getSphera()) + "</td>"
					+ "<td>" + getFormat(sort_day.getOther()) + "</td>"
					+ "<td>" + getCardData(sort_day.getCard()) + "</td>"
					+ "<td>" + getExpenseData(sort_day.getPayment()) + "</td>"
					+ "<td>" + (getSum(sort_day.getIncome()) - getSum(sort_day.getNicom()) - getSum(sort_day.getPults())) + "</td>"
					+ "<td>" + getFormat(sort_day.getNicom()) + "</td><td>" + getFormat(sort_day.getPults()) + "</td>"
					+ "<td>" + getSum(sort_day.getIncome()) + "</td><td>" + sort_day.getSalary() + "</td>"
					+ "<td>" + sort_day.getBeginCash() + "</td><td>" + sort_day.getEndCash() + "</td></tr>";
		}
		
		html += "</table></div>";
		return html;
	}

	private String getArray(int number, String type_deal) {
		ArrayList<Deal> deals = new ArrayList<Deal>();
		new DealsRecognize(Buffer.getFinal_list(), deals, type_deal);
		ArrayList<String> cash = deals.get(number).getCash_gain();
		ArrayList<String> online = deals.get(number).getOnline_income();
		String s = "";
		for(int i = 0; i < cash.size(); i++) {
			s += getNumber(cash.get(i)) + "<br>";
		}
		
		for(int i = 0; i < online.size(); i++) {
			s += getNumber(online.get(i)) + "<br>";
		}
		return s;
	}
	
	private String getArray(Object obj) {
		ArrayList<String> data = (ArrayList<String>) obj;
		if(data.get(0).equals("0") && data.size() > 1)data.remove(0);
		String s = "";
		for(int i = 0; i < data.size(); i++) {
			s += getNumber(data.get(i)) + "<br>";
		}
		return s;
	}
	
	private String getCardData(ArrayList<String> data) {
		String[] array;
		String result = "";
		
			for(int i = 0; i < data.size(); i++) {
				array = data.get(i).split(" ");
				result += array[1] + "<br>";
			}
			result += "</td><td>";
			for(int i = 0; i < data.size(); i++) {
				array = data.get(i).split(" ");
				result += array[0] + "<br>";
			}	
	return result;
	}
	
private String getExpenseData(ArrayList<String> data) {
	String[] array;
	String result = "";
	
		for(int i = 0; i < data.size(); i++) {
			array = data.get(i).split(" ");
			result += array[1] + "<br>";
		}
		result += "</td><td>";
		for(int i = 0; i < data.size(); i++) {
			array = data.get(i).split(" ");
			result += array[0] + "<br>";
		}	

		return result;
	}
	
	
	private int getNumber(String text) {
		char[] ch = text.toCharArray();
		String number = "";
			for(int i = 0; i < ch.length; i++) {
				if(Character.isDigit(ch[i]))number += "" + ch[i];
			}	
	return Integer.parseInt(number);
	}
	
	private String getFormat(ArrayList<String> data) {
		String[] array;
		String result = "";
		try {//..???? cstl!!
		if(data == null || data.size() == 0) return "0";
		
		else {
			for(int i = 0; i < data.size(); i++) {
				array = data.get(i).split(" ");
				result += array[1] + "<br>";
			}	
	return result;
		}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return "e";
		}
	}
	
	private int getSum(List<String> list) {
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += getNumber(list.get(i));
		}
		return sum;
	}
	
}