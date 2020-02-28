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


@WebServlet("/ServletOneItem")
public class ServletOneItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public ServletOneItem() {
			super();
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("..servlet_one_item ...method post");		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String json_from_js = request.getParameter("date_x");
		
		Gson gson = new Gson();
		OneItem oi = gson.fromJson(json_from_js, OneItem.class);
		String type_deal = oi.getItm();//..get item, type of deal from html-page
			if(type_deal.endsWith("ником сервис"))type_deal = "ником";//..cstl(!)
		
//..deals analisis		
		ArrayList<Day> day_interval = Buffer.getFinal_list();
		ArrayList<Deal> deals = new ArrayList<Deal>();
				
		new DealsRecognize(day_interval, deals, type_deal);

		response.getWriter().write(getHtmlTable(deals, oi));
		System.out.println("..end servlet_one_item");

	}

	private String getHtmlTable(ArrayList<Deal> deals, OneItem oi) {
//..adaptize string data to integer
		ArrayList<AdapterDeals> adapter = new ArrayList<AdapterDeals>();
			for(int i = 0; i < deals.size(); i++) {
				AdapterDeals adpt = new AdapterDeals(deals.get(i));
				adapter.add(adpt);
			}
//..html
		String html = "<table style=\"width: 80%\"><tr align=\"center\"><td align=\"center\">date</td>";
		if(oi.cas == true)html += "<td align=\"center\">cash</td>";
		if(oi.onl == true)html += "<td align=\"center\">online</td>";
		if(oi.exp == true)html += "<td align=\"center\">expense</td>";
		if(oi.tot == true)html += "<td>total</td>";
		html += "</tr>";
//..general cycle
		int total_cash = 0;
		int total_online = 0;
		int total_expense = 0;
		int total_plus = 0;
		
		for(int i = 0; i < deals.size(); i++) {
			html += "<tr style=\"vertical-align: top\"><td>" + deals.get(i).getDate() + "</td>";

			if(oi.cas == true) {
				html += "<td>";
				if(adapter.get(i).getCash_gain().size() == 0) {
					//System.out.println("online: zero");
					html += "&nbsp&nbsp&nbsp 0";
				}
				else {
					//System.out.println("online: not zero");
					for(int k = 0; k < adapter.get(i).getCash_gain().size(); k++) {
						html += adapter.get(i).getCash_gain().get(k) + "&nbsp&nbsp&nbsp<br>";
					}
				}
			}
		
			if(oi.onl == true) {
				html += "</td><td>";
				if(adapter.get(i).getOnlineIncome().size() == 0) {
						//System.out.println("online: zero");
					html += "&nbsp&nbsp&nbsp 0";
						}
				else {
						//System.out.println("online: not zero");
					for(int k = 0; k < adapter.get(i).getOnlineIncome().size(); k++) {
						html += + adapter.get(i).getOnlineIncome().get(k) + "&nbsp&nbsp&nbsp<br>";
					}
				}
			}
		
			if(oi.exp == true) {
				html += "</td><td>";
				if(adapter.get(i).getExpense().size() == 0) {
						//System.out.println("online: zero");
					html += "&nbsp&nbsp&nbsp 0";
				}
				else {
						//System.out.println("online: not zero");
					for(int k = 0; k < adapter.get(i).getExpense().size(); k++) {
						html += adapter.get(i).getExpense().get(k) + "&nbsp&nbsp&nbsp<br>";
					}
				}
			}
//..how must function TotalGain is global issue
			if(oi.tot == true) {
				html += "</td><td>";
				
				int cash_sum = 0;
				int online_sum = 0;
				int expense_sum = 0;
				
				if(oi.cas == true)cash_sum = getSum(adapter.get(i).getCash_gain());
				if(oi.onl == true)online_sum = getSum(adapter.get(i).getOnlineIncome());
				if(oi.exp == true)expense_sum = getSum(adapter.get(i).getExpense());
				
				int total_sum = cash_sum + online_sum - expense_sum;
				html += "&nbsp&nbsp&nbsp" + total_sum;
				total_cash += cash_sum;
				total_online += online_sum;
				total_expense += expense_sum;
				total_plus += total_sum;
			}

		html += "</td></tr>";
//.. add last row with total for each
		}//..general cycle end
		html += "<tr><td>general total:</td>";
		if(oi.cas == true)html += "<td>" + total_cash + "</td>";
		if(oi.onl == true)html += "<td>" + total_online + "</td>";
		if(oi.exp == true)html += "<td>" + total_expense + "</td>";
		if(oi.tot == true)html += "<td>" + total_plus + "</td>";
		
		
	html += "</tr></table>";	
	return html;
	}

	private  int getSum(List<Integer> list) {
		int sum = 0;
		for(Integer v : list) {
			sum += v;
		}
	return sum;
	}
	
}