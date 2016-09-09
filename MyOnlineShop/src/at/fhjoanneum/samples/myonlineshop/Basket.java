package at.fhjoanneum.samples.myonlineshop;

import java.util.ArrayList;

public class Basket {
	private Customer _customer;
	private ArrayList<BasketEntry> _entries = new ArrayList<BasketEntry>();
	
	public Basket(Customer customer)
	{
		_customer = customer;
	}
	
	public Customer getCustomer()
	{
		return _customer;
	}

	public void addEntry(int quantity, Article article)
	{
		_entries.add(new BasketEntry(quantity, article));
	}
	
	public float getSum()
	{
		float sum = 0.0F;
		for (BasketEntry entry : _entries)
		{
			sum += entry.getPrice();
		}
		return sum;
	}
}
