package at.fhjoanneum.samples.myonlineshop;

public class Catalog {
	public ArticleGroup BOOKS = new ArticleGroup("Books");
	public ArticleGroup MUSIC = new ArticleGroup("MUSIC");
	public ArticleGroup TOYS = new ArticleGroup("TOYS");
	
	private Article[] _catalog = {
			new Article("Java Language - The Reference Book", BOOKS, 35.60F),
			new Article("C Language - The Reference Book", BOOKS, 23.40F)
	};
	
}
