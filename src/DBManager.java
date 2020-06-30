import java.sql.*;
import java.util.Vector;

public class DBManager {
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/jalendar?&useSSL=false&serverTimezone=UTC";
	
	private final String USER_NAME = "juser";
	private final String PASSWORD = "user1";
	private Connection conn = null;
	private Statement state = null;
	
	public boolean connectDB() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			state = conn.createStatement();
			System.out.println("Database Connected");
		} catch (Exception e) {
			System.out.println("File System Connected");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void unconnectDB( ) {
		if(state != null && conn != null) {
			try {
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isAvailable(String date) {
		ResultSet rs;
		String sql = "SELECT * From usermemo WHERE _date = " + date;
		
		if(state != null && conn != null) {
			try {
				rs = state.executeQuery(sql);
				if (rs.next()) {
					rs.close();
					return true;
				} else {
					rs.close();
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public Vector<String> getData(String date) {
		ResultSet rs;
		String view = "";
		String sql = "SELECT memo FROM usermemo WHERE _date = " + date;
		Vector<String> memo = null;
		
		if(state != null && conn != null) {
			try {
				rs = state.executeQuery(sql);
				memo = new Vector<String>();
				
				while(rs.next()) {
					view = rs.getString("memo");
					memo.add(view);
				}
				
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memo;
	}
	
	public void insertData(String date, String memo) {
		String sql = "INSERT INTO usermemo(_date, memo) VALUES(" + date + ", " + memo + ")";
		System.out.println(sql);
		
		if(state != null && conn != null) {
			try {
				state.executeUpdate(sql);	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeData(String tmpDate, String memo) {
		String sql = "DELETE FROM usermemo WHERE _date = " + tmpDate + " AND memo = " + memo;
		
		if(state != null && conn != null) {
			try {
				state.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
