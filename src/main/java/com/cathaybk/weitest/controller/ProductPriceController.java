package com.cathaybk.weitest.controller;

import com.alibaba.fastjson2.JSON;
import com.cathaybk.weitest.response.Response;
import com.cathaybk.weitest.service.ProductPriceService;
import com.cathaybk.weitest.service.ProductService;
import com.cathaybk.weitest.service.RateService;
import com.cathaybk.weitest.util.DateTimeUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@Slf4j
public class ProductPriceController {
    @Resource
    private ProductPriceService productPriceService;
    @Resource
    private RateService rateService;

    /**
     * 查詢某日價格
     * @param productId
     * @param statisticsDate
     * @return
     */
    @GetMapping(value = "/selectOneDayPrice")
    public Response selectOneDayPrice(@RequestParam String productId,@RequestParam LocalDate statisticsDate) {
        return Response.success(productPriceService.selectOneDayProductPriceByDateAndProductId(productId,statisticsDate));
    }
    /**
     * 修改某日價格
     * @param productId
     * @param price
     * @param statisticsDate
     * @return
     */
    @PostMapping(value = "/updateProductPrice")
    public Response updateProductPrice(@RequestParam String productId, @RequestParam BigDecimal price,@RequestParam LocalDate statisticsDate) {
        productPriceService.updateProductPrice(productId,price,statisticsDate);
        return Response.success();
    }
    /**
     * 新增某日價格
     * @param productId
     * @param price
     * @param statisticsDateTime
     * @return
     */
    @PostMapping(value = "/addProductPrice")
    public Response addProductPrice(@RequestParam String productId, @RequestParam BigDecimal price, @RequestParam String statisticsDateTime) {
        productPriceService.addProductPrice(productId,price,statisticsDateTime);
        return Response.success();
    }
    /**
     * 刪除某日價格
     * @param productId
     * @param statisticsDate
     * @return
     */
    @PostMapping(value = "/deleteProductPrice")
    public Response deleteProductPrice(@RequestParam String productId,@RequestParam LocalDate statisticsDate) {
        productPriceService.deleteProductPrice(productId,statisticsDate);
        return Response.success();
    }
    /**
     * 查詢特定時間漲跌幅相關數據
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping(value = "/selectFundMomentum")
    public Response selectFundMomentum(@RequestParam LocalDate startDate,@RequestParam LocalDate endDate) {
        return Response.success(rateService.selectFundMomentum(startDate,endDate));
    }






}
