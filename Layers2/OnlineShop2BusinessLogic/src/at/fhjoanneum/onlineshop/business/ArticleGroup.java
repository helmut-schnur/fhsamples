package at.fhjoanneum.onlineshop.business;

public class ArticleGroup {
	private int _id;
	private String _name;
	private float _vatRate;
	
	ArticleGroup(int id, String name, float vatRate) {
		_id = id;
		_name = name;
		_vatRate = vatRate;
	}
	
	public int getId() { return _id; }
	public String getName() { return _name; }
	public float getVatRate() { return _vatRate; }
}
