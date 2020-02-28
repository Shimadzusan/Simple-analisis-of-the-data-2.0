package servlet_unit;

public class OnlineIncome {
	String itm;
	String con;
	boolean sber, tinkoff, pochta_bank, total;
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public boolean isSber() {
		return sber;
	}
	public void setSber(boolean sber) {
		this.sber = sber;
	}
	public boolean isTinkoff() {
		return tinkoff;
	}
	public void setTinkoff(boolean tinkoff) {
		this.tinkoff = tinkoff;
	}
	public boolean isPochta_bank() {
		return pochta_bank;
	}
	public void setPochta_bank(boolean pochta_bank) {
		this.pochta_bank = pochta_bank;
	}
	public boolean isTotal() {
		return total;
	}
	public void setTotal(boolean total) {
		this.total = total;
	}

}
