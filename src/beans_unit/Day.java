package beans_unit;

import java.util.ArrayList;
import java.util.List;

/**
 * class Day является центральным бином данного приложения, предназначен для:
 * ..организации структуры данных, на данный момент это - три категории данных
 * дата--фактура--дополнительная информация, variables: date--facture--info
 * ..используется всюду
 * @author user
 */
public class Day implements FrameDay {
	String date; 
	List<String> facture;	//..contains all deals for day
	List<String> info;	//..contains supplements information
		
	public Day() {
		facture = new ArrayList<String>();
		info = new ArrayList<String>();
	}
	    
	public void setDate(String date) {
		this.date = date;
	}
	    
	public String getDate() {
		return this.date;
	}
	       
	public void setFacture(String list) {
		facture.add(list);
		//this.facture = list;
	}
	
	public void setFacture(List<String> facture) {
		this.facture = facture;
	}
	    
	public List<String> getFacture() {
		return this.facture;
	}

	public List<String> getInfo() {
		return info;
	}

	public void setInfo(List<String> info) {
		this.info = info;
	}
	   	
}
