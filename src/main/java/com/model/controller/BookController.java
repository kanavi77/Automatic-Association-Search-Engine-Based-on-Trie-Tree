package com.model.controller;

import com.entity.book;
import com.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    BookService bookService;
    @RequestMapping("/list")
    public String list(Model model){
        List<book> q=bookService.bokList();
        q.sort(new Comparator<book>() {
            @Override
            public int compare(book o1, book o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        model.addAttribute("books",q);
        return "list";
    }
    @RequestMapping("/sear")
    public String sear(Model model){
        return "sear";
    }
    @RequestMapping("/edit")
    public String edit(Model model){
        return "edit";
    }
    @RequestMapping("/add")
    public String add(book books, Model model){
        System.out.println(books.getValue());
        bookService.bookadd(books);
        model.addAttribute("books",bookService.bokList());
        return "list";
    }
//    @RequestMapping("/gofind")
//    public String gofind(Model model){
//        return "find";
//    }

    @RequestMapping("/find")
    public String find(String bookname, Model model){
        model.addAttribute("books", bookService.bookfind(bookname));
        return "list";
    }
    @RequestMapping("/delete")
    public String delete(int id, Model model){
        bookService.bookdelete(id);
        return list(model);
    }

//
//    @RequestMapping("/goupdate")
//    public String goupdate(Model model){
//        return "update";
//    }
//
//    @RequestMapping("/update")
//    public String update(book books, HttpServletRequest request,Model model){
//        int id =Integer.valueOf( (String) request.getSession().getAttribute("id"));
//        books.setId(id);
//        bookService.update(books);
//        return list(model);
//    }
    @RequestMapping("/check")//localhost:hi
    public String check(String username, String password, Model model, HttpSession session){
        String u=username;
        String p=password;
        session.setAttribute("u",u);
        session.setAttribute("p",p);
        model.addAttribute("u", u);
        return list(model);
    }

}
