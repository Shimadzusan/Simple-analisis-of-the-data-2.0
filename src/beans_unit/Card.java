package beans_unit;

import java.util.ArrayList;

/**
 * class Card предназначен для:
 * ..формирования отчетности по онлайн-платежам, т.е. платежи перечисляемые на "карту"
 * ..используется сервлетом ServletOnlineIncome
 * @author user
 */
public class Card {
	String date;
	ArrayList<String> sber;
	ArrayList<String> tinkoff;
	ArrayList<String> pochta_bank;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<String> getSber() {
		return sber;
	}
	public void setSber(ArrayList<String> sber) {
		this.sber = sber;
	}
	public ArrayList<String> getTinkoff() {
		return tinkoff;
	}
	public void setTinkoff(ArrayList<String> tinkoff) {
		this.tinkoff = tinkoff;
	}
	public ArrayList<String> getPochta_bank() {
		return pochta_bank;
	}
	public void setPochta_bank(ArrayList<String> pochta_bank) {
		this.pochta_bank = pochta_bank;
	}

}
