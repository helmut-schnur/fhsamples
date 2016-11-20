package at.fhjoanneum.onlineshop.web.table;

import java.util.ArrayList;
import java.util.List;

import at.fhjoanneum.onlineshop.web.IPageElement;

public class Table implements IPageElement {
	private List<String> _columnNames = new ArrayList<String>();
	private List<TableRow> _rows = new ArrayList<TableRow>();
	
	public Table(String... columnNames) {
		for (String columnName : columnNames) {
			_columnNames.add(columnName);
		}
	}
	
	public TableRow addRow() {
		TableRow tr = new TableRow();
		_rows.add(tr);
		return tr;
	}
	
	public StringBuilder render(StringBuilder output) {
		output.append("<table>");
		
		// Create title with column names
		output.append("<tr>");
		for (String columnName : _columnNames) {
			output.append(String.format("<th>%s</th>", columnName));
		}
		output.append("</tr>");
		
		// Create row
		for (TableRow tr : _rows) {
			output.append("<tr>");
			tr.render(output);
			output.append("</tr>");
		}
		output.append("</table>");
		return output;
	}
}
