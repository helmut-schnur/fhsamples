package at.fhjoanneum.samples.myonlineshop;

public class BasketEntry {
	private int _quantity;
	private Article _article;
	
	public BasketEntry(int quantity, Article article)
	{
		_quantity = quantity;
		_article = article;
	}
	
	public int getQuantity()
	{
		return _quantity;
	}
	
	public Article getArticle()
	{
		return _article;
	}
	
	public float getPrice()
	{
		return _quantity * _article.getPrice();
	}
}
