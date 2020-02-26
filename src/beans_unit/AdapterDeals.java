package beans_unit;

import java.util.ArrayList;

public class AdapterDeals {
	ArrayList<Integer> total_gain;
	ArrayList<Integer> cash_gain;
	ArrayList<Integer> online_income;	//..sber, tinkoff, pochta-bank
		
	ArrayList<Integer> expense;
	Deal deal;
	
	public AdapterDeals(Deal deal) {
		total_gain = new ArrayList<Integer>();
		cash_gain = new ArrayList<Integer>();
		online_income = new ArrayList<Integer>();
		expense = new ArrayList<Integer>();
		this.deal = deal;
		setCashGain();
		setTotalGain();
		setOnlineIncome();
		setExpense();
	}
	
	public ArrayList<Integer> getTotalGain() {
		return total_gain;
	}
	
	private void setTotalGain() {
		for(int i = 0; i < deal.getTotal_gain().size(); i++) {
			this.total_gain.add(get_number(this.deal.getTotal_gain().get(i)));
		}
	}
	
	public ArrayList<Integer> getOnlineIncome() {
		return online_income;
	}
	
	private void setOnlineIncome() {
		for(int i = 0; i < deal.getOnline_income().size(); i++) {
			this.online_income.add(get_number(this.deal.getOnline_income().get(i)));
		}
	}
	
	public ArrayList<Integer> getExpense() {
		return expense;
	}
	
	private void setExpense() {
		for(int i = 0; i < deal.getExpense().size(); i++) {
			this.expense.add(get_number(this.deal.getExpense().get(i)));
		}
	}
	
	public ArrayList<Integer> getCash_gain() {
		return cash_gain;
	}

	private void setCashGain() {
		for(int i = 0; i < deal.getCash_gain().size(); i++) {
			this.cash_gain.add(get_number(this.deal.getCash_gain().get(i)));
		}
	}
	
	private int get_number(String text) {
		char[] ch = text.toCharArray();
		String number = "";
			for(int i = 0; i < ch.length; i++) {
				if(Character.isDigit(ch[i]))number += "" + ch[i];
			}
			
		return Integer.parseInt(number);
	}

}
