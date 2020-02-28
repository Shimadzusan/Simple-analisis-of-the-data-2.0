package recognition_and_initialization_unit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import beans_unit.*;

public class Recognize extends Head {
/*
 * this class recognize patterns from statement_data(statement.txt)
 * and initialize object_Day 
 */
	
	String address = "";
	String text = "";
	FrameDay day;		//..or FrameDay day;
	List<String> dayFacture;
	List<String> daySuppInfo;
	String[] dayList;
	
	public Recognize(Day day) {
		this.day = day;
	}
//..how to realize two same constructor? with text and address
	public Recognize(String text, FrameDay day) throws IOException {
		//this.address = address;
		this.day = day;
		dayFacture = new ArrayList<String>();
		daySuppInfo = new ArrayList<String>();
		this.text = text;
		dayInit();
		
		dayFacture = day.getFacture();
	}
/*
 * old method..	
	String get_text() throws IOException {
		FileInputStream fin = new FileInputStream(address);  
	        byte[] buffer = new byte[fin.available()];
	        fin.read(buffer, 0, buffer.length);
	        String s = new String(buffer, charset);
	        		//System.out.println(s);
	return s;
	}
*/
	
//begin day_init complex, this complex contains 3 methods
	private void dayInit() {
//***to parse the text
		dayList = text.split("\\n");	//total notes for day (code 13 10 is new line(\\r\\n))
			for(int i = 0; i < dayList.length; i++) {
	        	sortKind(dayList[i]);
	        }
		day.setInfo(daySuppInfo);
	}

	public void sortKind(String element) {
//cash
		if(element.contains("касса")) {
			if(element.contains("утро")) daySuppInfo.add(element);
			if(element.contains("вечер")) daySuppInfo.add(element);
				return;
		}
//date
		if(element.contains(".")) {
			day.setDate(element); 
				return;
		}
//salary
		if(element.contains("зп")) {
			daySuppInfo.add(element);;
				return;
		}			
//facture_surface
		day.setFacture(element);
	}
	
}
