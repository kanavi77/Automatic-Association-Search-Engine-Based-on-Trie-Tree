package com.Servlet;

import com.Algorithm.Trie;
import com.Algorithm.qsort;
import com.entity.book;
import com.mapper.BookMapper;
import net.sf.json.JSONArray;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession ss= request.getSession();
        Trie trie = (Trie) ss.getAttribute("trie");
        InputStream is = Resources.getResourceAsStream("Mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session=ssf.openSession();
        BookMapper bokstu=session.getMapper(BookMapper.class);
        String keyword = request.getParameter("keyword");
        if(trie.map.containsKey(keyword)){
            int q=trie.map.get(keyword);
            q++;
            trie.map.put(keyword,q);
            bokstu.update(keyword);
        }
        else {
            book x=new book();
            x.setValue(keyword);
            x.setCount(1);
            bokstu.insertbook(x);
            trie.map.put(keyword,1);
            trie.insert(keyword);
        }
        session.commit();
        session.close();
    }
}
