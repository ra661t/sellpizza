package ch11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";
	
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"jwbook","1234");
		} catch (Exception e) {e.printStackTrace();}
		return conn;
	}
	public List<Guest> getAll() throws Exception {
		Connection conn = open();
		List<Guest> guestList = new ArrayList<>();
		
		String sql = "select aid, title, PARSEDATETIME(date,'yyyy-MM-dd hh:mm:ss') as cdate from news";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		try (conn; pstmt; rs) {
			while (rs.next()) {
				Guest g = new Guest();
				g.setAid(rs.getInt("aid"));
				g.setTitle(rs.getString("title"));
				g.setDate(rs.getString("cdate"));
				guestList.add(g);
			}
		
	return guestList;
	}
	
}
	
	public Guest getNews(int aid) throws SQLException {
		Connection conn = open();
		Guest n = new Guest();
		String sql = "select aid, title, img, PARSEDATETIME(date,'yyyy-MM-dd hh:mm:ss') as cdate from news where aid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,  aid);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		try (conn; pstmt; rs) {
			g.setAid(rs.getInt("aid"));
			g.setUsername(rs.getString("username"));
			g.setEmail(rs.getString("email"));
			g.setDate(rs.getString("cdate"));
			g.setTitle(rs.getString("title"));
			pstmt.executeQuery();
			return g;
	}
}
	public void addNews(Guest g) throws Exception {
		Connection conn = open();
		String sql = "insert into news(title, img, content) values(?,?,CURRENT_TIMESTAMP(),?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt) {
			pstmt.setString(1, g.getUsername());
			pstmt.setString(2, g.getEmail());
			pstmt.setString(3, g.getTitle());
			pstmt.executeUpdate();
		}
		
	}
	public void delNews(int aid) throws SQLException{
		Connection conn = open();
		String sql = "delete from news where aid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt) {
			pstmt.setInt(1, aid);
			if(pstmt.executeUpdate()==0) {
				throw new SQLException("DB에러");
			}
		}
				
	}

}
