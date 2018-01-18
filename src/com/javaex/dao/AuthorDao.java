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

public class AuthorDao {
	Connection con;

	public AuthorDao() {
		con= new DbConnect().getCon();
	}

	public void insertAuthor(String authorName, String authorDesc) {

		try {

			String sql = "INSERT INTO Author Values(seq_author_id.nextval,?,?)";
			// PreparedStatementS pStmt =con.createStatement();

			PreparedStatement pStmt = con.prepareStatement(sql);

			pStmt.setString(1, authorName);
			pStmt.setString(2, authorDesc);

			int cnt = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<AuthorVo> selectAuthorlist() {

		List<AuthorVo> authorlist = new ArrayList<AuthorVo>();

		String query = " select author_id,author_name,author_desc \r\n" + " from author\r\n";

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			AuthorVo vo = new AuthorVo();
			while (rs.next()) {
				vo = new AuthorVo();
				vo.setAuthorid(rs.getInt("author_id"));
				vo.setAuthorName(rs.getString("author_name"));
				vo.setAuthorDesc(rs.getString("author_desc"));

				authorlist.add(vo);

			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return authorlist;
	}

}
