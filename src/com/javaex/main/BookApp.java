package com.javaex.main;

import java.util.ArrayList;
import java.util.List;

import com.javaex.dao.AuthorDao;
import com.javaex.dao.BookDao;
import com.javaex.vo.AuthorVo;
import com.javaex.vo.BookVo;

public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AuthorVo vo = new AuthorVo();
		BookVo vo2 = new BookVo();
		List<AuthorVo> list = new ArrayList<AuthorVo>();
		AuthorDao aDao = new AuthorDao();
		BookDao bDao = new BookDao();
		
		list=aDao.selectAuthorlist();
		
		List<BookVo> list2 = new ArrayList<BookVo>();
		
		list2=bDao.selectBooklist();
		
		for(int i=0; i<list2.size(); i++) {
			vo2 = list2.get(i);
			
			System.out.print(vo2.toString());
		}
		
		
	
		
	}

}
