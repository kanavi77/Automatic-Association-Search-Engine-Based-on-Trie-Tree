package com.mapper;


import com.entity.book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    @Select("select  * from phrase ")
    List<book> listALL();
    @Select("select  * from phrase limit 500")
    List<book> listPart();
    @Select("select  * from phrase where value like '${value}%'")
    //@Select("select  * from phrase where value = #{value}")
    List<book>  getByname(String value);
//    void insertbook(book x);
    @Insert("insert into phrase(value) values (#{value})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertbook(book x);
    @Delete("delete from phrase where id=#{id}")
    void delete(int id);
    @Update("UPDATE phrase SET count=count+1 where value=#{value}")
    void update(String keyword);
    //    void  update_dynamic(book x);//id!=null
//    void  delete(int id);
}