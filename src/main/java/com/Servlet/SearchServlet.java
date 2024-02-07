package com.Servlet;

import com.Algorithm.Trie;
import com.Algorithm.qsort;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Trie trie = (Trie) session.getAttribute("trie");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String keyword = request.getParameter("keyword");
        if (keyword != null || keyword != "") {
            System.out.println(keyword);
            keyword = java.net.URLDecoder.decode(keyword, "utf-8");
            List<String> listData = trie.getData(keyword);
            qsort q=new qsort();
            if (listData != null){

                q.Sort(listData,0,listData.size()-1,trie.map);
                Collections.reverse(listData);
                if(listData.size()>=10)
                    listData=listData.subList(0, 10);
                System.out.println(listData);
                response.getWriter().write(
                        JSONArray.fromObject(listData).toString());
            }

        }
    }
}
