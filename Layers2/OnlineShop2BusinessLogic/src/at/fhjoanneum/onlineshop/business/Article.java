package at.fhjoanneum.onlineshop.business;

public class Article {
	private int _id;
	private ArticleGroup _articleGroup;
	private String _name;
	private String _description;
	private float _nettoPrice;
	
	Article(int id, ArticleGroup articleGroup, String name, String description, float nettoPrice) {
		_id = id;
		_articleGroup = articleGroup;
		_name = name;
		_description = description;
		_nettoPrice = nettoPrice;
	}
	
	public int getId() { return _id; }
	public ArticleGroup getArticleGroup() { return _articleGroup; }
	public String getName() { return _name; }
	public String getDescription() { return _description; }
	public float getNettoPrice() { return _nettoPrice; }
	
	public float getBruttoPrice() { return getNettoPrice() * (1 + getArticleGroup().getVatRate() / 100); }
}
