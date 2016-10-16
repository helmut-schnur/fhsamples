package at.fhjoanneum.samples.myonlineshop;

public class Catalog {
	public ArticleGroup BOOKS = new ArticleGroup("Books");
	public ArticleGroup MUSIC = new ArticleGroup("Music");
	public ArticleGroup TOYS = new ArticleGroup("Toys");
	
	private Article[] _catalog = {
			new Article("0001", "Java Language - The Reference Book", BOOKS, 35.60F),
			new Article("0002", "C Language - The Reference Book", BOOKS, 23.40F),
			new Article("0003", "Bear", TOYS, 5.30F),
			new Article("0004", "Dolly", TOYS, 4.20F),
			new Article("0005", "Moonlight Shadow", MUSIC, 1.30F),
	};

	public Article find(String id){
		for (Article a : _catalog) {
			if (a.getId().equalsIgnoreCase(id)) {
				return a;
			}
		}
		return null;
	}
}
