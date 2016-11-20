package at.fhjoanneum.onlineshop.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSet {
	private List<DataRow> _dataRows = new ArrayList<DataRow>();
	
	public List<DataRow> getRows() {
		return Collections.unmodifiableList(_dataRows);
	}
	
	DataRow addRow() {
		DataRow dr = new DataRow();
		_dataRows.add(dr);
		return dr;
	}
}
