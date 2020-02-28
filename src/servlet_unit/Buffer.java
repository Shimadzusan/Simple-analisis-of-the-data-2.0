package servlet_unit;

import java.util.ArrayList;
import beans_unit.Day;

public class Buffer {
	private static ArrayList<Day> final_list;
	private static String text;
	
	public static synchronized String getText() {
		return text;
	}

	public static synchronized void setText(String text) {
		Buffer.text = text;
	}

	public static ArrayList<Day> getFinal_list() {
		return final_list;
	}

	public static void setFinal_list(ArrayList<Day> final_list) {
		Buffer.final_list = final_list;
	}
	
	public static synchronized String getLastDeal() {
		String[] s = text.split("\\n");
		return s[s.length-1];
	}

}
