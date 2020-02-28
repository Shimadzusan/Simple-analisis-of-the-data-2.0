package database_unit;

public class SAD003 {
	/*	..в теории должен генерироваться автоматически*/
	
	private int id; 
	private String date;
	private String deal;
	private int volume;
	private String payment;
	private String comment;

	public SAD003() {
	}

	public SAD003(String date, String deal, int volume, String payment, String comment) {
		this.date = date;
		this.deal = deal;
		this.volume = volume;
		this.payment = payment;
		this.comment = comment;
	}

	public String getDate() {
			return date;
		}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDeal() {
		return deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Data:\n" +
				"date: " + this.date + "\n" +
				"deal: " + this.deal + "\n" +
				"volume: " + this.volume + "\n" +
				"payment: " + this.payment + "\n";
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
