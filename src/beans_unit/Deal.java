package beans_unit;

import java.util.ArrayList;

/**
 * class Deal предназначен для:
 * ..формирование отчетности по только одной категории услуги или товара, список данных услуг и товаров
 * определен в выпадающем списке html-страницы
 * ..используется сервлетом ServletOneItem
 * @author user
 */
public class Deal {
	String date;
	String type_of_deal;
	
	ArrayList<String> total_gain;
	ArrayList<String> cash_gain;
	ArrayList<String> online_income;	//..sber, tinkoff, pochta-bank
		
	ArrayList<String> expense;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getType_of_deal() {
		return type_of_deal;
	}

	public void setType_of_deal(String type_of_deal) {
		this.type_of_deal = type_of_deal;
	}

	public ArrayList<String> getTotal_gain() {
		return total_gain;
	}

	public void setTotal_gain(ArrayList<String> total_gain) {
		this.total_gain = total_gain;
	}

	public ArrayList<String> getCash_gain() {
		return cash_gain;
	}

	public void setCash_gain(ArrayList<String> cash_gain) {
		this.cash_gain = cash_gain;
	}

	public ArrayList<String> getOnline_income() {
		return online_income;
	}

	public void setOnline_income(ArrayList<String> online_income) {
		this.online_income = online_income;
	}

	public ArrayList<String> getExpense() {
		return expense;
	}

	public void setExpense(ArrayList<String> expense) {
		this.expense = expense;
	}

}
