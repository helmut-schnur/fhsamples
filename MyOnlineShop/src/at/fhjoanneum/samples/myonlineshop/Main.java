package at.fhjoanneum.samples.myonlineshop;

public class Main {

	public static void main(String[] args) {
		Catalog c = new Catalog();
		
		Customer c1 = new Customer("ItIsMe");
		
		Basket b1 = new Basket(c1);
		b1.addEntry(1, c.find("0001"));
		b1.addEntry(3, c.find("0003"));
		
	}
}
