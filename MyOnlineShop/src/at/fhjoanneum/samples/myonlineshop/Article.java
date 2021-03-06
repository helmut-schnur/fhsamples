package at.fhjoanneum.samples.myonlineshop;

public class Article {
	private String _id;
	private String _name;
	private ArticleGroup _articleGroup;
	private float _price;
	
	public Article(String id, String name, ArticleGroup articleGroup, float price) {
		_id = id;
		_name = name;
		_articleGroup = articleGroup;
		_price = price;
	}
	
	public String getId()	{
		return _id;
	}
	
	public String getName()	{
		return _name;
	}
	
	public ArticleGroup getArticleGroup() {
		return _articleGroup;
	}
	
	public float getPrice()	{
		return _price;
	}
}
