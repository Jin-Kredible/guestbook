package com.bit2017.guestbookDao;

import java.sql.*;
import java.util.*;

import com.bit2017.guestbookVo.*;

public class GuestDao {
	private static Connection getConnection () throws SQLException{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = DriverManager.getConnection(url, "webdb", "webdb");
		return conn;
	}
	public boolean insert(Guestvo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into guestbook values(seq_guestbook.nextval, ?, ?, ?, sysdate)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getContent());

			int i = pstmt.executeUpdate();

			return (i == 1);

		} catch (SQLException e) {
			System.out.println("error: " + e);
			return false;

		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error " + e);
			}
		}
	}


	public boolean modify(Long no, String password) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "delete from guestbook where no=? and password=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, no);
			pstmt.setString(2, password);

			int i = pstmt.executeUpdate();

			return (i == 1);

		} catch (SQLException e) {
			System.out.println("error: " + e);
			return false;

		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error " + e);
			}
		}
	}

	public List<Guestvo> getList() {

		List<Guestvo> list = new ArrayList<Guestvo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			stmt = conn.createStatement();

			String sql = "select no, name, password, content, to_char(pub_date, 'yyyy/mm/dd') from guestbook order by pub_date desc";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String content = rs.getString(4);
				String pubDate = rs.getString(5);

				Guestvo vo = new Guestvo();

				vo.setNo(no);
				vo.setName(name);
				vo.setPassword(password);
				vo.setContent(content);
				vo.setPubDate(pubDate);

				list.add(vo);
				
				System.out.println(vo);

			}
		}  catch (SQLException e) {
			System.out.println("error: " + e);

		} finally {

			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error " + e);
			}
		}
		return list;
	}
}
