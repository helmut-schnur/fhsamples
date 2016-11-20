package at.fhjoanneum.onlineshop.web.style;

import at.fhjoanneum.onlineshop.web.IPageElement;

public class StyleAttribute implements IPageElement {
	private String _attribute;
	private String _value;
	
	public StyleAttribute(String attribute, String value) {
		_attribute = attribute;
		_value = value;
	}
	
	public StringBuilder render(StringBuilder output) {
		output.append(String.format("%s:%s;", _attribute, _value));
		return output;
	}
}
