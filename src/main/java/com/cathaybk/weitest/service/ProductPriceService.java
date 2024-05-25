package com.cathaybk.weitest.service;


import com.cathaybk.weitest.mapper.ProductPriceMapper;
import com.cathaybk.weitest.model.ProductPricePo;
import com.cathaybk.weitest.util.DateTimeUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/***
 * productPrice 表相關基礎操作
 * @author wei
 */
@Slf4j
@Service
public class ProductPriceService {
    @Resource
    private ProductPriceMapper productPriceMapper;
    /**
     * 查詢某日價格
     * @param productId
     * @param statisticsDate
     * @return List<ProductPricePo>
     */
    public ProductPricePo selectOneDayProductPriceByDateAndProductId(String productId, LocalDate statisticsDate) {
        return productPriceMapper.selectOneDayProductPriceByDateAndProductId(productId,statisticsDate);
    }
    /**
     * 新增某日價格
     * @param productId
     * @param price
     * @param statisticsDateTimeStr
     * @return void
     */
    public void addProductPrice(String productId, BigDecimal price, String statisticsDateTimeStr){
        LocalDateTime statisticsDateTime = DateTimeUtil.convertToLocalDateTime(statisticsDateTimeStr);
        productPriceMapper.insertProductPrice(productId,price,statisticsDateTime.toLocalDate(),statisticsDateTime);
    }
    /**
     * 修改某日價格
     * @param productId
     * @param statisticsDate
     * @return void
     */
    public void updateProductPrice(String productId, BigDecimal price, LocalDate statisticsDate){
        productPriceMapper.updateProductPrice(productId,price,statisticsDate);
    }
    /**
     * 刪除某日價格
     * @param productId
     * @param statisticsDate
     * @return void
     */
    public void deleteProductPrice(String productId, LocalDate statisticsDate){
        productPriceMapper.deleteProductPrice(productId,statisticsDate);
    }
    /**
     * 查詢時間區間內 全部productId的收盤價格
     * @param startDate
     * @param endDate
     * @return void
     */
    public List<ProductPricePo> selecProductPriceByStartAndEndDate(LocalDate startDate,LocalDate endDate){
        return productPriceMapper.selecProductPriceByStartAndEndDate(startDate,endDate);
    }
}
