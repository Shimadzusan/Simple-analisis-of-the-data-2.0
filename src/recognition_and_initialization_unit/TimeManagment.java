package recognition_and_initialization_unit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import beans_unit.Day;

public class TimeManagment {
	String begin_date_one;
	String begin_date_two;
	String formated_date_one;
	String formated_date_two;
	boolean flag = false;
	ArrayList<Day> final_day_list = new ArrayList<Day>();
	
	public List<Day> getInterval(String date_one, String date_two, List<Day> day_array) {
		this.begin_date_one = date_one;
		this.begin_date_two = date_two;
		
		try {
			this.formated_date_one = convertToJavaDateFormat(date_one);
			this.formated_date_two = convertToJavaDateFormat(date_two);
		}
		catch (java.lang.ArrayIndexOutOfBoundsException e) {
			//..add yet youself catch
			System.out.println("your first catch)");
		}
		
		System.out.println("date_one: " + date_one);
		System.out.println("date_two: " + date_two);
		LocalDate date_alpha = null;
		LocalDate date_betta = null;
		
		try {
			date_alpha = date_alpha.parse(formated_date_one);
		    date_betta = date_betta.parse(formated_date_two);
		    //System.out.println("compare: " + date_betta.compareTo(date_alpha));
			
			for(int i = 0; i < day_array.size(); i++) {//..how do this regex like an sysout...
				String date_three = convertToJavaDateFormat(day_array.get(i).getDate());
				LocalDate date_hamma = null;
			    date_hamma = date_hamma.parse(date_three);
			    
			    if(date_alpha.compareTo(date_hamma) == 0)flag = true;
			    if(flag == true)final_day_list.add(day_array.get(i));
			    if(date_betta.compareTo(date_hamma) == 0)flag = false;
			}
		}
		catch (java.lang.NullPointerException e) {
			System.out.println("you second catch");
		}
		return final_day_list;
	}

	private String convertToJavaDateFormat(String begin_format) {
		String[] array = begin_format.split("\\.");
		//..add: java.lang.ArrayIndexOutOfBoundsException try-catch
		String java_date_format = array[2] + "-" + array[1] + "-" + array[0];
		return java_date_format;
	}
	
}
