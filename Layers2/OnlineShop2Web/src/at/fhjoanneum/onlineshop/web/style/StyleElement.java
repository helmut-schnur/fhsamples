package at.fhjoanneum.onlineshop.web.style;

import java.util.ArrayList;
import java.util.List;

import at.fhjoanneum.onlineshop.web.IPageElement;

public class StyleElement implements IPageElement {
	private String _elementName;
	private List<StyleAttribute> _styleAttributes = new ArrayList<StyleAttribute>();
	
	public StyleElement(String elementName) {
		_elementName = elementName;
	}
	
	public StyleElement addAttribute(StyleAttribute styleAttribute) {
		_styleAttributes.add(styleAttribute);
		return this;
	}
	
	public StringBuilder render(StringBuilder output) {
		output.append(String.format("%s {", _elementName));
		for (StyleAttribute styleAttribute : _styleAttributes) {
			styleAttribute.render(output);
		}
		output.append("}");
		return output;
	}
}
