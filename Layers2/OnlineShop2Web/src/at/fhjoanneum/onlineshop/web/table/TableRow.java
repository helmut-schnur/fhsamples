package at.fhjoanneum.onlineshop.web.table;

import java.util.ArrayList;
import java.util.List;

import at.fhjoanneum.onlineshop.web.IPageElement;

public class TableRow implements IPageElement {
	private List<TableCell> _cells = new ArrayList<TableCell>();

	public void addCell(Object value) {
		_cells.add(new TableCell(value));
	}

	public void addCell(Object value, String format) {
		_cells.add(new TableCell(value, format));
	}
	
	public StringBuilder render(StringBuilder output) {
		for (TableCell cell : _cells) {
			cell.render(output);
		}
		return output;
	}
}
