package at.fhjoanneum.onlineshop.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.fhjoanneum.onlineshop.business.Article;
import at.fhjoanneum.onlineshop.business.ArticleRepository;
import at.fhjoanneum.onlineshop.web.style.StyleAttribute;
import at.fhjoanneum.onlineshop.web.style.StyleElement;
import at.fhjoanneum.onlineshop.web.table.Table;
import at.fhjoanneum.onlineshop.web.table.TableRow;

/**
 * Servlet implementation class Catalog
 */
public class Catalog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a page with title and head lines
		Page page = new Page("Online Shop 2", "Online Shop 2", "Catalog");
		
		// Setup styles
		page.getStyle().addElement(new StyleElement("table, td, th")
				.addAttribute(new StyleAttribute("border", "1px solid"))
				.addAttribute(new StyleAttribute("border-collapse", "collapse")));
	
		// Get article repository
		ArticleRepository articleRepository = new ArticleRepository();
		
		// Fill table with article information
		Table table = new Table("Article No.", "Article Name", "Description", "Netto Price", "Article Group", "VAT Rate", "Brutto Price");
		for (Article article : articleRepository.getArticles()) {
			TableRow tr = table.addRow();
			tr.addCell(article.getId());
			tr.addCell(article.getName());
			tr.addCell(article.getDescription());
			tr.addCell(article.getNettoPrice(), "%10.2f");
			tr.addCell(article.getArticleGroup().getName());
			tr.addCell(article.getArticleGroup().getVatRate());
			tr.addCell(article.getBruttoPrice(), "%10.2f");
		}
		page.addElement(table);
	
		// Render the page
		StringBuilder stream = new StringBuilder();
		page.render(stream);
		response.getWriter().append(stream);
	}
}
