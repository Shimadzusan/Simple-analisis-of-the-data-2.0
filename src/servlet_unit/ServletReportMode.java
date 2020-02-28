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
import recognition_and_initialization_unit.*;


@WebServlet("/ServletReportMode")
public class ServletReportMode extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public ServletReportMode() {
			super();
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("..servlet_report_mode ...method post");		
		request.setCharacterEncoding("utf-8");
		
		String date_one = request.getParameter("date_one");
		String date_two = request.getParameter("date_two");
		String flag = request.getParameter("flag_today_data");//switch <Standart><Report>
		String type_of_report = request.getParameter("type_of_report");
		
		System.out.println("date_one: " + date_one);
		System.out.println("date_two: " + date_two);
		System.out.println("flag <Report>: " + flag);
		System.out.println("type of report: " + type_of_report);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
//..creating necessary object for analizis
		Saga saga = new Saga("D:\\saga.txt");
		
		System.out.println("lenght of array<Day>: " + saga.getSaga().length);
		ArrayList<beans_unit.Day> day_list = new ArrayList<beans_unit.Day>();
			for(int i = 0; i < saga.getSaga().length; i++) {
				day_list.add(saga.getSaga()[i]);
			}
//..analisis
		TimeManagment tm = new TimeManagment();
		ArrayList<Day> final_list = (ArrayList<Day>) tm.getInterval(date_one, date_two, day_list);//!INTERVAL
		System.out.println("final list size: " + final_list.size());
		Buffer.setFinal_list(final_list);

//..deals analisis BEGIN <STANDART CHIEF REPORT>		
		ArrayList<Day> day_interval = Buffer.getFinal_list();
		ArrayList<Deal> deals = new ArrayList<Deal>();
//		new DealsRecognize(day_interval, deals, "фнд");
//		System.out.println("deals size: " + deals.size());
//..adaptize
//		AdapterDeals adapter = new AdapterDeals(deals.get(2));
//		System.out.println("adapter: " + adapter.getCash_gain());
//		System.out.println("adapter: " + adapter.getOnlineIncome());
		ArrayList<AdapterDeals> adapter = new ArrayList<AdapterDeals>();
			for(int i = 0; i < deals.size(); i++) {
				AdapterDeals adpt = new AdapterDeals(deals.get(i));
				adapter.add(adpt);
			}
			System.out.println("a-r " + adapter.size());
//.....
 
		Gson json = new Gson();
		String json_deals = json.toJson(deals);
		if(type_of_report.equals("standart chief report"))
		response.getWriter().write(json_deals);
//..end
		
		
		
//for consol desing
		System.out.println("..end servlet_report_mode");
		System.out.println();
	}

	private String concatJson(String json_one, String json_two) {
		String result = json_one.substring(0, json_one.length() - 1) + "," 
		+ json_two.substring(1, json_two.length());
		
	return result;
	}

}