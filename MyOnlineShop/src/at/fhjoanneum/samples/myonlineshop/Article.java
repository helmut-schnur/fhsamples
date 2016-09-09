package at.fhjoanneum.samples.myonlineshop;

public class Article {
	private String _name;
	private ArticleGroup _articleGroup;
	private float _price;
	
	public Article(String name, ArticleGroup articleGroup, float price)
	{
		_name = name;
		_articleGroup = articleGroup;
		_price = price;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public ArticleGroup getArticleGroup()
	{
		return _articleGroup;
	}
	
	public float getPrice()
	{
		return _price;
	}
}
