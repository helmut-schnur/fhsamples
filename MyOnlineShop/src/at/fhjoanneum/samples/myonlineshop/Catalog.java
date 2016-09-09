package at.fhjoanneum.samples.myonlineshop;

import java.util.ArrayList;

public class Catalog {
	private ArrayList<Article> _catalog = new ArrayList<Article>();
	
	public void add(Article article)
	{
		_catalog.add(article);
	}
	
	public void remove(Article article)
	{
		_catalog.remove(article);
	}
}
