package recognition_and_initialization_unit;

import java.util.ArrayList;

import beans_unit.Card;
import beans_unit.Day;
import beans_unit.Deal;

public class DealsRecognize {
	ArrayList<Day> day_interval; 
	ArrayList<Deal> object_for_init;
	ArrayList<Card> object_for_card;
	String deal_type;
	
	ArrayList<String> day_facture;
	Day day;
	Deal deal;
	Card card;
	ArrayList<String> general_list;
	ArrayList<String> cash_list;
	ArrayList<String> online_list;
	ArrayList<String> expense_list;
	String date;
	
	public DealsRecognize(ArrayList<Day> day_interval, ArrayList<Deal> object_for_init, String deal_type) {
		this.day_interval = day_interval; 
		this.object_for_init = object_for_init;
		this.deal_type = deal_type;
		general_list = new ArrayList();
		
		extract_data();	
	}
	
//..for online_payment
	public DealsRecognize(ArrayList<Day> day_interval, ArrayList<Card> object_for_card) {
		this.day_interval = day_interval; 
		this.object_for_card = object_for_card;
		general_list = new ArrayList();
		extract_data_two();
	}

	private void extract_data() {
		for(int i = 0; i < day_interval.size(); i++) {
			day = day_interval.get(i);
			day_facture = (ArrayList<String>) day.getFacture();
			//System.out.println("dealsreco: " + day.getFacture());
			init_deal();
			general_list.clear();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
	}

	private void extract_data_two() {
		for(int i = 0; i < day_interval.size(); i++) {
			day = day_interval.get(i);
			day_facture = (ArrayList<String>) day.getFacture();
			//System.out.println("dealsreco: " + day.getFacture());
			init_card();
			general_list.clear();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		
	}

	
	private void init_deal() {
		for(int i = 0; i < day_facture.size(); i++) {
			String s = day_facture.get(i);
				if(s.contains(deal_type)) {
					general_list.add(s);
				}
		}
		//System.out.println("gen_list: " + general_list);
		
		deal = new Deal();
		deal.setTotal_gain(general_list);
		deal.setCash_gain(getCash());
		deal.setOnline_income(getOnlineIcome());
		deal.setExpense(getExpense());
		//System.out.println("deals size333: " + deal.getTotal_gain());
		deal.setDate(day.getDate());
		
		object_for_init.add(deal);
		
	}
	
	private void init_card() {
		for(int i = 0; i < day_facture.size(); i++) {
			String s = day_facture.get(i);
				if(s.contains("сбер") || s.contains("тинькофф")  || s.contains("почта-банк") || s.contains("сбербанк") || s.contains("тинькоф")) {
		
					general_list.add(s);
				}
		}
		//System.out.println("gen_list from card: " + general_list);
		
		card = new Card();
//		deal.setTotal_gain(general_list);
		card.setSber(getSber());
		card.setTinkoff(getTinkoff());
		card.setPochta_bank(getPochta_bank());
		card.setDate(day.getDate());
		object_for_card.add(card);		
	}
	
	private ArrayList<String> getPochta_bank() {
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < general_list.size(); i++) {
			String s = general_list.get(i);
			if(s.contains("почта-банк") || s.contains("почта банк")) {
				result.add(s);
			}
		}
		return result;
	}
	private ArrayList<String> getTinkoff() {
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < general_list.size(); i++) {
			String s = general_list.get(i);
			if(s.contains("тинькофф") || s.contains("тинькоф")) {
				result.add(s);
			}
		}
		return result;
	}
	private ArrayList<String> getSber() {
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < general_list.size(); i++) {
			String s = general_list.get(i);
			if(s.contains("сбер") || s.contains("сбербанк")) {
				result.add(s);
			}
		}
		return result;
	}
	
	private ArrayList<String> getExpense() {
		ArrayList<String> result = new ArrayList<String>();
			for(int i = 0; i < general_list.size(); i++) {
				String s = general_list.get(i);
				if(s.contains("минус")) {
					result.add(s);
				}
			}
		return result;
	}

	private ArrayList<String> getOnlineIcome() {
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < general_list.size(); i++) {
			String s = general_list.get(i);
			if(s.contains("сбер") || s.contains("тинькофф")  || s.contains("почта-банк") || s.contains("сбербанк") || s.contains("тинькоф")) {
				result.add(s);
			}
		}
		return result;
	}

	private ArrayList<String> getCash() {
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < general_list.size(); i++) {
			String s = general_list.get(i);
			if(!s.contains("сбер") && !s.contains("тинькофф")  && !s.contains("почта-банк") && !s.contains("сбербанк") 
					&& !s.contains("тинькоф") && !s.contains("минус")) {
				result.add(s);
			}
		}
		return result;
	}

}
