package at.fhjoanneum.onlineshop.database;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DataRow {
	private Map<String, Object> _cells = new HashMap<String, Object>();
	
	void addCell(String columnName, Object value) {
		_cells.put(columnName, value);
	}
	
	public int getInt(String columnName) {
		return ((BigDecimal) _cells.get(columnName)).intValue();
	}
	
	public String getString(String columnName) {
		return (String) _cells.get(columnName);
	}
	
	public float getFloat(String columnName) {
		return ((BigDecimal) _cells.get(columnName)).floatValue();
	}
}
