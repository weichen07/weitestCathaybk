package com.cathaybk.weitest.mapper;

import com.cathaybk.weitest.model.ProductPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ProductMapper {

    @Select("select * from product")
    List<ProductPo> selectAllProduct();
    @Insert("insert into product(id,name, short_name)values(#{id}, #{name}, #{shortName})")
    int insertProduct(@Param("id") String id,@Param("name") String name,@Param("shortName") String shortName);

}
