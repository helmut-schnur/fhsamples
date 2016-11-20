package at.fhjoanneum.onlineshop.business;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import at.fhjoanneum.onlineshop.database.DataRow;
import at.fhjoanneum.onlineshop.database.DataSet;
import at.fhjoanneum.onlineshop.database.OnlineShopRepository;

public class ArticleGroupRepository {
	private OnlineShopRepository _repository = new OnlineShopRepository();
	private Map<Integer, ArticleGroup> _articleGroups = new HashMap<Integer, ArticleGroup>();	

	public ArticleGroupRepository() {
		_repository.startup();	

		DataSet dsArticleGroups = _repository.getArticleGroups();
		for (DataRow drArticleGroup : dsArticleGroups.getRows()) {
			int id = drArticleGroup.getInt("ID");
			
			String name = drArticleGroup.getString("NAME");
			float vatRate = drArticleGroup.getFloat("VAT_RATE");
			
			ArticleGroup articleGroup = new ArticleGroup(id, name, vatRate);
			_articleGroups.put(id, articleGroup);
		}
	}
	
	public ArticleGroup findById(int id) {
		return _articleGroups.get(id);
	}
	
	public Collection<ArticleGroup> getArticleGroups() {
		return _articleGroups.values();
	}
}
