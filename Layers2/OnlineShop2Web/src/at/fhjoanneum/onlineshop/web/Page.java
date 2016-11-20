package at.fhjoanneum.onlineshop.web;

import java.util.ArrayList;
import java.util.List;

import at.fhjoanneum.onlineshop.web.style.Style;

public class Page implements IPageElement {
	private String _title;
	private String _h1;
	private String _h2;
	private Style _style = new Style();
	private List<IPageElement> _content = new ArrayList<IPageElement>();
	
	public Page(String title, String h1, String h2) {
		_title = title;
		_h1 = h1;
		_h2 = h2;
	}
	
	public Style getStyle() {
		return _style;
	}
	
	public void addElement(IPageElement element) {
		_content.add(element);
	}
	
	public StringBuilder render(StringBuilder output) {
		output.append("<html>");
		
		output.append("<head>");
		_style.render(output);
		output.append(String.format("<title>%s</title>", _title));
		output.append("</head>");
		
		output.append("<body>");
		output.append(String.format("<h1>%s</h1>", _h1));
		output.append(String.format("<h2>%s</h2>", _h2));
		for (IPageElement pageElement : _content) {
			pageElement.render(output);
		}
		output.append("</body>");
		return output;
	}
}
