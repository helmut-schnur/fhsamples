package at.fhjoanneum.onlineshop.database;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class OnlineShopRepository implements IRepository {
	private Connection conn = null;

	public void startup() {
		if (conn != null)
			return;
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "fh_samples", "fhsamples");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DataSet getArticles() {
		return getData("SELECT a.id ID, a.id_article_group ID_ARTICLE_GROUP, a.name NAME, a.description DESCRIPTION, a.netto_price NETTO_PRICE FROM articles a");
	}
	
	public DataSet getArticleGroups() {
		return getData("SELECT g.id ID, g.name NAME, g.vat_rate VAT_RATE FROM article_groups g");
	}

	private DataSet getData(String sql) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// Get all column names
			List<String> columnNames = new ArrayList<String>();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			for (int idx = 0; idx < rsMetaData.getColumnCount(); idx++) {
				columnNames.add(rsMetaData.getColumnName(idx + 1));
			}
			
			// Create data set with data rows
			DataSet ds = new DataSet();
			while (rs.next()) {
				DataRow dr = ds.addRow();
				for (String columnName : columnNames) {
					dr.addCell(columnName, rs.getObject(columnName));	
				}
			}
			rs.close();
			stmt.close();
			return ds;
		} 
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
		finally
		{
			try {
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} 
			catch (SQLException se2) {
			}
		}
		return null;
	}
}
