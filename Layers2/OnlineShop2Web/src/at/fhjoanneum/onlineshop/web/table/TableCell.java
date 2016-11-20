package at.fhjoanneum.onlineshop.web.table;

import at.fhjoanneum.onlineshop.web.IPageElement;

public class TableCell implements IPageElement {
	private Object _value;
	private String _format;
	
	public TableCell(Object value) {
		_value = value;
	}

	public TableCell(Object value, String format) {
		this(value);
		_format = format;
	}
	
	public StringBuilder render(StringBuilder output) {
		output.append("<td>");
		if (_format != null) {
			output.append(String.format(_format, _value));
		}
		else {
			output.append(_value);
		}
		output.append("</td>");
		return output;
	}
}
