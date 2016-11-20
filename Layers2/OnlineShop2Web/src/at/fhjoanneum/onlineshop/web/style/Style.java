package at.fhjoanneum.onlineshop.web.style;

import java.util.ArrayList;
import java.util.List;

import at.fhjoanneum.onlineshop.web.IPageElement;

public class Style implements IPageElement {
	private List<StyleElement> _styleElements = new ArrayList<StyleElement>();
	
	public Style addElement(StyleElement styleElement) {
		_styleElements.add(styleElement);
		return this;
	}
	
	public StringBuilder render(StringBuilder output) {
		output.append("<style>");
		for (StyleElement styleElement : _styleElements) {
			styleElement.render(output);
		}
		output.append("</style>");
		return output;
	}
}
