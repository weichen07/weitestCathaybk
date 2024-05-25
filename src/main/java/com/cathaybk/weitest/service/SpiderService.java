package com.cathaybk.weitest.service;


import com.alibaba.fastjson2.JSON;
import com.cathaybk.weitest.feign.CathaybkFundFeign;
import com.cathaybk.weitest.mapper.ProductMapper;
import com.cathaybk.weitest.mapper.ProductPriceMapper;
import com.cathaybk.weitest.model.ProductPricePo;
import com.cathaybk.weitest.model.vo.FundPriceVo;
import com.cathaybk.weitest.response.Response;
import com.cathaybk.weitest.util.DateTimeUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * productPrice 表相關操作
 * @author wei
 */
@Slf4j
@Service
public class SpiderService {
    @Resource
    private ProductPriceService productPriceService;
    @Resource
    private ProductService productService;
    @Resource
    private CathaybkFundFeign cathaybkFundFeign;
    @Transactional(rollbackFor = Exception.class)
    public void computeFundData() {
        Map<String,Object> first = new HashMap<>();
        Map<String,Object> second = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("10480016");
        second.put("Keys", list);
        second.put("From", "2023/03/10");
        second.put("To", "2024/05/24");
        first.put("req",second);
        Response<List<FundPriceVo>> response = cathaybkFundFeign.getFundNavChart(first);
        List<FundPriceVo> resList = response.getData();
        resList.forEach(one->{
            String shortName = "";
            if(!ObjectUtils.isEmpty(one.getShortName())){
                shortName = one.getShortName();
            }
            productService.insertProduct(one.getId(),one.getName(),shortName);
            one.getData().forEach(firstList->{
                BigDecimal price = firstList.get(1);
                String dateTimeStr = String.valueOf(firstList.get(0).longValue());
                productPriceService.addProductPrice(one.getId(),price,dateTimeStr);
            });
        });
    }
}
