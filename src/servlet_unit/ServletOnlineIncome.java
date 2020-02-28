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


@WebServlet("/ServletOnlineIncome")
public class ServletOnlineIncome extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public ServletOnlineIncome() {
			super();
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("..servlet_online_income ...method post");		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String json_from_js = request.getParameter("data_s");
		System.out.println("servlet_online_income: " + json_from_js);
		
		Gson gson = new Gson();
		OnlineIncome oi = gson.fromJson(json_from_js, OnlineIncome.class);
		
//..deals analisis		
		ArrayList<Day> day_interval = Buffer.getFinal_list();
		ArrayList<Card> deals = new ArrayList<Card>();
				
		new DealsRecognize(day_interval, deals);
		response.getWriter().write(getHtmlTable(deals, oi));
		System.out.println("..end servlet_one_item");
	}

	private String getHtmlTable(ArrayList<Card> deals, OnlineIncome oi) {
////..html
		String html = "<table style=\"width: 80%\"><tr align=\"center\"><td align=\"center\">date</td>";
		if(oi.isSber())html += "<td align=\"center\">Sberbank</td>";
		if(oi.isTinkoff())html += "<td align=\"center\">Tinkoff</td>";
		if(oi.isPochta_bank())html += "<td align=\"center\">Pochta Bank</td>";
		if(oi.isTotal())html += "<td>total</td>";
		html += "</tr>";
		
//..general cycle	
		int total = 0;
		int total_sber = 0;
		int total_tinkoff = 0;
		int total_pochta_bank = 0;
		for(int i = 0; i < deals.size(); i++) {
			html += "<tr style=\"vertical-align: top\"><td>" + deals.get(i).getDate() + "</td>";
				
			if(oi.isSber()) {
				html += "<td>";
				if(deals.get(i).getSber().size() == 0) {
					html += "&nbsp&nbsp&nbsp 0";
				}
				else {
					for(int k = 0; k < deals.get(i).getSber().size(); k++) {
						html += formatData(deals.get(i).getSber().get(k)) + "&nbsp&nbsp&nbsp<br>";
						total += getNumber(deals.get(i).getSber().get(k));
						total_sber += getNumber(deals.get(i).getSber().get(k));
					}
				}
			}
			if(oi.isTinkoff()) {
				html += "<td>";
				if(deals.get(i).getTinkoff().size() == 0) {
					html += "&nbsp&nbsp&nbsp 0";
				}
				else {
					for(int k = 0; k < deals.get(i).getTinkoff().size(); k++) {
						html += formatData(deals.get(i).getTinkoff().get(k)) + "&nbsp&nbsp&nbsp<br>";
						total += getNumber(deals.get(i).getTinkoff().get(k));
						total_tinkoff += getNumber(deals.get(i).getTinkoff().get(k));
					}
				}
			}
			if(oi.isPochta_bank()) {
				html += "<td>";
				if(deals.get(i).getPochta_bank().size() == 0) {
					html += "&nbsp&nbsp&nbsp 0";
				}
				else {
					for(int k = 0; k < deals.get(i).getPochta_bank().size(); k++) {
						html += formatData(deals.get(i).getPochta_bank().get(k)) + "&nbsp&nbsp&nbsp<br>";
						total += getNumber(deals.get(i).getPochta_bank().get(k));
						total_pochta_bank += getNumber(deals.get(i).getPochta_bank().get(k));
					}
				}
			}
////..how must function TotalGain is global issue
			if(oi.isTotal()) {
				html += "</td><td>" + total + "</td>";
				total = 0;
			}

////.. add last row with total for each
		}//..general cycle end
		
		html += "<tr><td>g-l total:</td>";
		
		if(oi.isSber())html += "<td>" + total_sber + "</td>";
		if(oi.isTinkoff())html += "<td>" + total_tinkoff + "</td>";
		if(oi.isPochta_bank())html += "<td>" + total_pochta_bank + "</td>";
		int total_plus = total_sber + total_tinkoff + total_pochta_bank;
		if(oi.isTotal())html += "<td>" + total_plus + "</td>";
			
		html += "</tr></table>";	
	return html;
	}

	private String formatData(String s) {
		String[] array = s.split(" ");
		String new_format = array[1] + "\t" + array[0];
		return new_format;
	}
	
	private int getNumber(String text) {
		char[] ch = text.toCharArray();
		String number = "";
			for(int i = 0; i < ch.length; i++) {
				if(Character.isDigit(ch[i]))number += "" + ch[i];
			}
			
	return Integer.parseInt(number);
	}

}