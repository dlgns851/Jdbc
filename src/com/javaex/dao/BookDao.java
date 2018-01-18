package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaex.conn.DbConnect;
import com.javaex.vo.AuthorVo;
import com.javaex.vo.BookVo;

public class BookDao {
	Connection con;

	public BookDao() {
		con= new DbConnect().getCon();
	}

	public void insertAuthor(String title, String pubs, String pubDate, int authorId ) {

		try {

			String sql = "INSERT INTO Author Values(seq_book_id.nextval,?,?,?,?)";
			// PreparedStatementS pStmt =con.createStatement();

			PreparedStatement pStmt = con.prepareStatement(sql);

			pStmt.setString(1, title);
			pStmt.setString(2, pubs);
			pStmt.setString(3, pubDate);
			pStmt.setInt(4, authorId);

			int cnt = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<BookVo> selectBooklist() {

		List<BookVo> bookList = new ArrayList<BookVo>();

		String query = " select * \r\n" + " from book\r\n";

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			BookVo vo = new BookVo();
			while (rs.next()) {
				vo = new BookVo();
				vo.setBookId(rs.getInt("book_id"));
				vo.setTitle(rs.getString("title"));
				vo.setPubs(rs.getString("pubs"));
				vo.setPubDate(rs.getString("pub_date"));
				vo.setAuthorId(rs.getInt("author_id"));
			



				bookList.add(vo);

			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bookList;
	}

}
