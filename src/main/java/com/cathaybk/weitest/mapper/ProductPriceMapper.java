package com.cathaybk.weitest.mapper;


import com.cathaybk.weitest.model.ProductPricePo;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface ProductPriceMapper {

    @Insert("insert into product_price(`product_id`, `price`, `statistics_date`, `gmt_created`)" +
            "values(#{productId}, #{price}, #{statisticsDate}, #{statisticsDateTime})")
    int insertProductPrice(@Param("productId") String productId,@Param("price") BigDecimal price
            ,@Param("statisticsDate") LocalDate statisticsDate,@Param("statisticsDateTime") LocalDateTime statisticsDateTime);

    @Update("UPDATE product_price SET  price = #{price}  "
            + " WHERE  product_id = #{productId}  and statistics_date = #{statisticsDate}")
    int updateProductPrice(@Param("productId") String productId,@Param("price") BigDecimal price
            ,@Param("statisticsDate")LocalDate statisticsDate);

    @Delete(" delete from product_price WHERE product_id = #{productId} and statistics_date = #{statisticsDate}")
    int deleteProductPrice(@Param("productId") String productId
            ,@Param("statisticsDate") LocalDate statisticsDate);
    @Select("select * from product_price WHERE product_id = #{productId} and statistics_date = #{statisticsDate}")
    ProductPricePo selectOneDayProductPriceByDateAndProductId(@Param("productId") String productId
            ,@Param("statisticsDate")LocalDate statisticsDate);
    @Select(" select * from product_price WHERE statistics_date between #{startDate}  and #{endDate} order by statistics_date")
    List<ProductPricePo> selecProductPriceByStartAndEndDate(@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);
}
