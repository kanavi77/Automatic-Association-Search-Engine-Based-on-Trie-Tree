package com.model.service;

import com.entity.book;
import com.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {
    @Resource
    BookMapper bookMapper;

    public List<book> bokList(){
        return bookMapper.listPart();
    }
    public void bookadd(book x){
       bookMapper.insertbook(x);
    }
    public List<book> bookfind(String bookname){
        return bookMapper.getByname(bookname);
    }
    public void bookdelete(int id){
        bookMapper.delete(id);
    }
//    public void  update(book x){
//        bookMapper.update_dynamic(x);
//    }
}
