package at.fhjoanneum.onlineshop.database;

public interface IRepository {
	void startup();
	DataSet getArticles();	
	DataSet getArticleGroups();
}
