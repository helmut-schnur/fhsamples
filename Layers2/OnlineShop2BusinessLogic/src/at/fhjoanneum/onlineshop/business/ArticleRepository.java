package at.fhjoanneum.onlineshop.business;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import at.fhjoanneum.onlineshop.database.DataRow;
import at.fhjoanneum.onlineshop.database.DataSet;
import at.fhjoanneum.onlineshop.database.OnlineShopRepository;

public class ArticleRepository {
	private OnlineShopRepository _repository = new OnlineShopRepository();
	private ArticleGroupRepository _articleGroupRepository = new ArticleGroupRepository();
	private Map<Integer, Article> _articles = new HashMap<Integer, Article>();
	
	public ArticleRepository() {
		_repository.startup();	

		DataSet dsArticles = _repository.getArticles();
		for (DataRow drArticle : dsArticles.getRows()) {
			int id = drArticle.getInt("ID");
			
			int idArticleGroup = drArticle.getInt("ID_ARTICLE_GROUP");
			ArticleGroup articleGroup = _articleGroupRepository.findById(idArticleGroup);
			
			String name = drArticle.getString("NAME");
			String description = drArticle.getString("DESCRIPTION");
			float nettoPrice = drArticle.getFloat("NETTO_PRICE");
			
			Article article = new Article(id, articleGroup, name, description, nettoPrice);
			_articles.put(id, article);
		}
	}
	
	public Article findById(int id) {
		return _articles.get(id);
	}
	
	public Collection<Article> getArticles() {
		return _articles.values();
	}
}
