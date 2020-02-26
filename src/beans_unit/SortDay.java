package beans_unit;

public class SortDay <Ge> {

	String date;
	Ge foto, copy, print, income, payment, card, nicom, pults,
	nicomMinus, pultsMinus, baget, fotolab, bagetMinus, fotolabMinus,
	sphera, spheraMinus, other, otherMinus;
	String salary, beginCash, endCash;
	
	public SortDay(Ge type) {	//..для присваивания переменной <Ge> необходимого типа
		System.out.println(type.getClass());
		this.foto = type;
	}

	public Ge getFoto() {
		return foto;
	}

	public void setFoto(Ge foto) {
		this.foto = foto;
	}
	
	public Ge getPrint() {
		return print;
	}

	public void setPrint(Ge print) {
		this.print = print;
	}
	
	public Ge getCopy() {
		return copy;
	}

	public void setCopy(Ge copy) {
		this.copy = copy;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Ge getIncome() {
		return income;
	}

	public void setIncome(Ge income) {
		this.income = income;
	}

	public Ge getPayment() {
		return payment;
	}

	public void setPayment(Ge payment) {
		this.payment = payment;
	}

	public Ge getCard() {
		return card;
	}

	public void setCard(Ge card) {
		this.card = card;
	}

	public Ge getNicom() {
		return nicom;
	}

	public void setNicom(Ge nicom) {
		this.nicom = nicom;
	}

	public Ge getPults() {
		return pults;
	}

	public void setPults(Ge pults) {
		this.pults = pults;
	}

	public Ge getNicomMinus() {
		return nicomMinus;
	}

	public void setNicomMinus(Ge nicomMinus) {
		this.nicomMinus = nicomMinus;
	}

	public Ge getPultsMinus() {
		return pultsMinus;
	}

	public void setPultsMinus(Ge pultsMinus) {
		this.pultsMinus = pultsMinus;
	}

	public Ge getBaget() {
		return baget;
	}

	public void setBaget(Ge baget) {
		this.baget = baget;
	}

	public Ge getFotolab() {
		return fotolab;
	}

	public void setFotolab(Ge fotolab) {
		this.fotolab = fotolab;
	}

	public Ge getBagetMinus() {
		return bagetMinus;
	}

	public void setBagetMinus(Ge bagetMinus) {
		this.bagetMinus = bagetMinus;
	}

	public Ge getFotolabMinus() {
		return fotolabMinus;
	}

	public void setFotolabMinus(Ge fotolabMinus) {
		this.fotolabMinus = fotolabMinus;
	}

	public Ge getOther() {
		return other;
	}

	public void setOther(Ge other) {
		this.other = other;
	}

	public Ge getOtherMinus() {
		return otherMinus;
	}

	public void setOtherMinus(Ge otherMinus) {
		this.otherMinus = otherMinus;
	}

	public Ge getSphera() {
		return sphera;
	}

	public void setSphera(Ge sphera) {
		this.sphera = sphera;
	}

	public Ge getSpheraMinus() {
		return spheraMinus;
	}

	public void setSpheraMinus(Ge spheraMinus) {
		this.spheraMinus = spheraMinus;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getBeginCash() {
		return beginCash;
	}

	public void setBeginCash(String beginCash) {
		this.beginCash = beginCash;
	}

	public String getEndCash() {
		return endCash;
	}

	public void setEndCash(String endCash) {
		this.endCash = endCash;
	}
}