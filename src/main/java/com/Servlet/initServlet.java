package com.Servlet;

import com.Algorithm.*;
import com.Algorithm.Trie;
import com.entity.book;
import com.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;


public class initServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        InputStream is = Resources.getResourceAsStream("Mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session=ssf.openSession();
        BookMapper bokstu=session.getMapper(BookMapper.class);
        List<book> x=bokstu.listALL();

        Trie trie = new Trie();
        Trie_array p=new Trie_array();
        HashMap<String,Integer> map = new HashMap<>();
        for(book b:x){
            trie.insert(b.getValue());
            try {
                p.insert(b.getValue());
            }
            catch (Exception e){

            }
            map.put(b.getValue(),b.getCount());
        }
        trie.SetMap(map);
//        trie.displaytree(trie.getRoot(),0);
      //  PrintTree.print(trie.getRoot());

        
        
//        long begintime = System.nanoTime();
//        long endtime = System.nanoTime();
//        long costTime = (endtime - begintime)/1000;
//        
//        begintime = System.nanoTime();
//        bokstu.getByname("a");
//        endtime=System.nanoTime();
//        System.out.println((endtime - begintime)/1000);
//        begintime = System.nanoTime();
//        p.getData("a");
//        endtime=System.nanoTime();
//        System.out.println((endtime - begintime)/1000);
//        begintime = System.nanoTime();
//        trie.getData("a");
//        endtime=System.nanoTime();
//        System.out.println((endtime - begintime)/1000);




        session.close();
        HttpSession ss = request.getSession();
        ss.setAttribute("trie", trie);
        request.getRequestDispatcher("index.html").forward(request,response);
    }
}
