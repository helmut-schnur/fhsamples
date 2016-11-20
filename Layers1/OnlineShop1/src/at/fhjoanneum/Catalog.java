package at.fhjoanneum;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Catalog
 */
public class Catalog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<head>" +
				"<style>" + 
					"table, th, td { border: 1px solid; border-collapse: collapse; }" +
				"</style>" +
				"<title>Online Shop 1 Catalog</title></head>");
		writer.println("<body>");
		writer.println("<h1>Online Shop 1</h1>");
		writer.println("<h2>Catalog</h2>");
		
		writer.println("<table>");
		writer.println("<tr>");
		writer.println("<th>Article No.</th><th>Article Name</th><th>Description</th><th>Netto Price</th><th>Article Group</th><th>VAT Rate</th><th>Brutto Price</th>");
		writer.println("</tr>");
		
		Connection conn = null;
		Statement stmt = null;
		try {
			DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "fh_samples", "fhsamples");
			stmt = conn.createStatement();

			String sql;
			sql = "SELECT a.id ID, a.name NAME, a.description DESCRIPTION, a.netto_price NETTO_PRICE, g.name ARTICLE_GROUP_NAME, g.vat_rate VAT_RATE FROM articles a, article_groups g where a.ID_ARTICLE_GROUP = g.ID";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				writer.println("<tr>");
				
				writer.println("<td>");
				int id = rs.getInt("ID");
				writer.println(id);
				writer.println("</td>");
				
				writer.println("<td>");
				String name = rs.getString("NAME");
				writer.println(name);
				writer.println("</td>");

				writer.println("<td>");
				String description = rs.getString("DESCRIPTION");
				writer.println(description);
				writer.println("</td>");

				writer.println("<td>");
				float nettoPrice = rs.getFloat("NETTO_PRICE");
				writer.format("%10.2f", nettoPrice);
				writer.println("</td>");

				writer.println("<td>");
				String articleGroupName = rs.getString("ARTICLE_GROUP_NAME");
				writer.println(articleGroupName);
				writer.println("</td>");

				writer.println("<td>");
				float vatRate = rs.getFloat("VAT_RATE");
				writer.println(vatRate);
				writer.println("</td>");

				writer.println("<td>");
				float bruttoPrice = nettoPrice * (1 + vatRate / 100);
				writer.format("%10.2f", bruttoPrice);
				writer.println("</td>");

				writer.println("</tr>");
			}
			writer.println("</table>");

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		writer.println("</body>");
		writer.println("</html>");
		response.getWriter().close();
	}
}