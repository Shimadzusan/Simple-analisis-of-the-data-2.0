package recognition_and_initialization_unit;

import java.util.ArrayList;
import java.util.List;

import beans_unit.*;

/**
 * This class should contains all means for recognition
 * it is mean too many different methods
 * also this class should be use for building any other reports
 * @author user
 *
 */
public class DeepRecognize {
	String totalFacture = "";
	SortDay s_day;
	FrameDay day;
	
	ArrayList<String> foto = new ArrayList<String>();
	ArrayList<String> copy = new ArrayList<String>();
	ArrayList<String> print = new ArrayList<String>();
	ArrayList<String> nicom = new ArrayList<String>();
	ArrayList<String> nicomMinus = new ArrayList<String>();
	ArrayList<String> pults = new ArrayList<String>();
	ArrayList<String> pultsMinus = new ArrayList<String>();
	ArrayList<String> fotolab = new ArrayList<String>();
	ArrayList<String> fotolabMinus = new ArrayList<String>();
	ArrayList<String> sphera = new ArrayList<String>();
	ArrayList<String> spheraMinus = new ArrayList<String>();
	ArrayList<String> baget = new ArrayList<String>();
	ArrayList<String> bagetMinus = new ArrayList<String>();
	ArrayList<String> other = new ArrayList<String>();
	ArrayList<String> payment = new ArrayList<String>();
	ArrayList<String> card = new ArrayList<String>();
	ArrayList<String> income = new ArrayList<String>();
	
	public DeepRecognize(SortDay sd, FrameDay day) {	//..constructor only one type SortDay!
		this.s_day = sd;
		this.day = day;
		
		initTotalFacture();
		
		System.out.println(s_day.getFoto().getClass());
		if(s_day.getFoto() instanceof Integer)intRecognition();
		if(s_day.getFoto() instanceof ArrayList)listRecognition();
		this.s_day.setDate(day.getDate());
		extractInfo();
	}
	
	public void extractInfo() {
		for(String s : day.getInfo()) {
			if(s.contains("зп"))s_day.setSalary(getNumber(s) + "");
			if(s.contains("касса утро"))s_day.setBeginCash(getNumber(s) + "");
			if(s.contains("касса вечер"))s_day.setEndCash(getNumber(s) + "");
		}
	}

	public void initTotalFacture() {
		totalFacture = getText(day);		
	}
	
//..extracting module
	public boolean extractFoto(String s) {
		if(s.contains("фнд"))return true;
		else return false;
	}
	
	public boolean extractCopy(String s) {
		if(s.contains("копия"))return true;
		else return false;
	}
	
	public boolean extractPrint(String s) {
		if(s.contains("печать"))return true;
		else return false;
	}
	
	public boolean extractNicom(String s) {
		if(s.contains("ником") && !s.contains("минус"))return true;
		else return false;
	}
	
	public boolean extractNicomMinus(String s) {
		if(s.contains("ником") && s.contains("минус"))return true;
		else return false;
	}
	
	public boolean extractPults(String s) {
		if(s.contains("пульты") && !s.contains("минус"))return true;
		else return false;
	}
	
	public boolean extractPultsMinus(String s) {
		if(s.contains("пульты") && s.contains("минус"))return true;
		else return false;
	}
	
	public boolean extractFotolab(String s) {
		if(s.contains("фотолаб") && !s.contains("минус"))return true;
		else return false;
	}
	
	public boolean extractFotolabMinus(String s) {
		if(s.contains("фотолаб") && s.contains("минус"))return true;
		else return false;
	}
	
	public boolean extractSphera(String s) {
		if(s.contains("сфера") && !s.contains("минус"))return true;
		else return false;
	}
	
	public boolean extractSpheraMinus(String s) {
		if(s.contains("сфера") && s.contains("минус"))return true;
		else return false;
	}
	
	public boolean extractBaget(String s) {
		if(s.contains("багет") && !s.contains("минус"))return true;
		else return false;
	}
	
	public boolean extractBagetMinus(String s) {
		if(s.contains("багет") && s.contains("минус"))return true;
		else return false;
	}
	
	public boolean extractOther(String s) {
		if(!s.contains("минус") && !s.contains("фнд") && !s.contains("копия") && !s.contains("печать")
				&& !s.contains("багет") && !s.contains("фотолаб") && !s.contains("сфера") && !s.contains("ником")
				&& !s.contains("пульты"))return true;
		else return false;
	}
	
	public boolean extractPayment(String s) {
		if(s.contains("минус"))return true;
		else return false;
	}
	
	public boolean extractCard(String s) {
		if(s.contains("сбер") || s.contains("тинькофф")
		|| s.contains("почта-банк") || s.contains("сбербанк") || s.contains("тинькоф"))return true;
		else return false;
	}
	
	public void extractIncome() {
		for(String s : day.getFacture()) {
			if(!s.contains("минус"))income.add(s);
		}
	}

	public void intRecognition() {
		System.out.println("int");
		listRecognition();
		s_day.setFoto(getSum(foto));
		s_day.setCopy(getSum(copy));
		s_day.setPrint(getSum(print));
		s_day.setNicom(getSum(nicom));
		s_day.setNicomMinus(getSum(nicomMinus));
		s_day.setPults(getSum(pults));
		s_day.setPultsMinus(getSum(pultsMinus));
		s_day.setFotolab(getSum(fotolab));
		s_day.setFotolabMinus(getSum(fotolabMinus));
		s_day.setSphera(getSum(sphera));
		s_day.setSpheraMinus(getSum(spheraMinus));
		s_day.setBaget(getSum(baget));
		s_day.setBagetMinus(getSum(bagetMinus));
		s_day.setOther(getSum(other));
		s_day.setPayment(getSum(payment));
		s_day.setCard(getSum(card));
		s_day.setIncome(getSum(income));
		
	}
	
	public void listRecognition() {
		System.out.println("list");
		for(int i = 0; i < day.getFacture().size(); i++) {
			String element = day.getFacture().get(i);
			if(extractFoto(element))foto.add(element);
			if(extractCopy(element))copy.add(element);
			if(extractPrint(element))print.add(element);
			if(extractNicom(element))nicom.add(element);
			if(extractNicomMinus(element))nicomMinus.add(element);
			if(extractPults(element))pults.add(element);
			if(extractPultsMinus(element))pultsMinus.add(element);
			if(extractPayment(element))payment.add(element);
			if(extractCard(element))card.add(element);
			if(extractFotolab(element))fotolab.add(element);
			if(extractFotolabMinus(element))fotolabMinus.add(element);
			if(extractSphera(element))sphera.add(element);
			if(extractSpheraMinus(element))spheraMinus.add(element);
			if(extractBaget(element))baget.add(element);
			if(extractBagetMinus(element))bagetMinus.add(element);
			if(extractOther(element))other.add(element);
		}
		extractIncome();
		
		s_day.setFoto(foto);
		s_day.setCopy(copy);
		s_day.setPrint(print);
		s_day.setNicom(nicom);
		s_day.setNicomMinus(nicomMinus);
		s_day.setPults(pults);
		s_day.setPultsMinus(pultsMinus);
		s_day.setPayment(payment);
		s_day.setCard(card);
		s_day.setBaget(baget);
		s_day.setBagetMinus(bagetMinus);
		s_day.setFotolab(fotolab);
		s_day.setFotolabMinus(fotolabMinus);
		s_day.setSphera(sphera);
		s_day.setSpheraMinus(spheraMinus);
		s_day.setOther(other);
		s_day.setIncome(income);
	}

	private String getText(FrameDay day) {
		String s = "";
		s += day.getDate() + "\n";
		for(int i = 0; i < day.getFacture().size(); i++) {
			s += day.getFacture().get(i) + "\n";
		}
		for(int i = 0; i < day.getInfo().size(); i++) {
			s += day.getInfo().get(i) + "\n";
		}
		
		return s;
	}
	
	private int getSum(List<String> list) {
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += getNumber(list.get(i));
		}
		return sum;
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
