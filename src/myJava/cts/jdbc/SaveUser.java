package myJava.cts.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveUser {


		private static String dbURL = "jdbc:derby:C:\\Users\\John\\MyDB;create=true";
		private static String tableName = "USERTABLETEST";

		// jdbc Connection
		private static Connection conn = null;
		private static Statement stmt = null;

		public static void main(String[] args) {
			
			createConnection();
			createUser();
			insertUser(6, "User6");
			selectUser();
			shutdown();

		}

		private static void createConnection() {
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
				conn = DriverManager.getConnection(dbURL);
			} catch (Exception except) {
				except.printStackTrace();
			}
		}

		private static void createUser() {
			try {
				stmt = conn.createStatement();
				stmt.execute("CREATE TABLE " + tableName + " (ID INT PRIMARY KEY,NAME VARCHAR(12))");
				stmt.close();

			} catch (SQLException sqlExcept) {
				sqlExcept.printStackTrace();
			}
		}

		private static void insertUser(int id, String name) {
			try {

				 /*stmt = conn.createStatement();
				 stmt.execute("insert into " + tableName + " values (" + id + ",'"
				 + name + "')");
				 stmt.close();*/

				PreparedStatement stmt = conn.prepareStatement("insert into " + tableName + " values(?,?)");
				stmt.setInt(1, id);// 1 specifies the first parameter in the query
				stmt.setString(2, name);
				stmt.executeUpdate();

				System.out.println(" records inserted");
			} catch (SQLException sqlExcept) {
				sqlExcept.printStackTrace();
			}
		}

		private static void selectUser() {
			try {
				stmt = conn.createStatement();
				ResultSet results = stmt.executeQuery("select * from " + tableName);
				ResultSetMetaData rsmd = results.getMetaData();
				int numberCols = rsmd.getColumnCount();
				for (int i = 1; i <= numberCols; i++) {
					// print Column Names
					System.out.print(rsmd.getColumnLabel(i) + "\t\t");
				}

				System.out.println("\n-------------------------------------------------");

				while (results.next()) {
					int id = results.getInt(1);
					String restName = results.getString(2);
					System.out.println(id + "\t\t" + restName + "\t\t");
				}
				results.close();
				stmt.close();
			} catch (SQLException sqlExcept) {
				sqlExcept.printStackTrace();
			}
		}

		private static void shutdown() {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					DriverManager.getConnection(dbURL + ";shutdown=true");
					conn.close();
				}
			} catch (SQLException sqlExcept) {

			}

		}		
}
