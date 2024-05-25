package com.cathaybk.weitest.service.impl;

import com.cathaybk.weitest.mapper.ProductPriceMapper;
import com.cathaybk.weitest.model.ProductPricePo;
import com.cathaybk.weitest.model.vo.MomentumVo;
import com.cathaybk.weitest.model.vo.PriceChangeVo;
import com.cathaybk.weitest.service.ProductPriceService;
import com.cathaybk.weitest.service.RateService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Slf4j
@Service
public class RateServiceImpl implements RateService {

    @Resource
    private ProductPriceService productPriceService;
    @Override
    public List<MomentumVo> selectFundMomentum(LocalDate startTime , LocalDate endTime){
        List<ProductPricePo> list = productPriceService.selecProductPriceByStartAndEndDate(startTime,endTime);
        Map<String,List<ProductPricePo>> groupMap =list.stream().collect(Collectors.groupingBy(ProductPricePo::getProductId));
        List<MomentumVo> voList = new ArrayList<>();
        groupMap.forEach((key,value)->{
            //按照統計完成時間排序
            List<ProductPricePo> oneProductBeforeAfterList = value.stream().sorted(Comparator.comparing(ProductPricePo::getStatisticsDate)).toList();
            MomentumVo voOne = new MomentumVo();
            voOne.setProductId(key);
            List<PriceChangeVo> priceChangeList = new ArrayList<>();
            for(int i =0;i<oneProductBeforeAfterList.size();i++){
                PriceChangeVo priceChangeVo = new PriceChangeVo();
                priceChangeVo.setStatisticsDate(oneProductBeforeAfterList.get(i).getStatisticsDate());
                if(i == 0){
                    priceChangeVo.setPriceChange(BigDecimal.ZERO);
                    priceChangeVo.setPriceChangeRate(BigDecimal.ZERO);
                    priceChangeList.add(priceChangeVo);
                    continue;
                }
                BigDecimal beforeDayMoney = oneProductBeforeAfterList.get(i-1).getPrice();
                BigDecimal afterDayMoney = oneProductBeforeAfterList.get(i).getPrice();
                //計算漲跌[後收-前收]
                BigDecimal priceChange = afterDayMoney.subtract(beforeDayMoney);
                //計算漲跌幅[(後收-前收)/前收] 計算到小數點第二位
                BigDecimal rate = (afterDayMoney.subtract(beforeDayMoney)).divide(beforeDayMoney,4, BigDecimal.ROUND_HALF_EVEN);
                priceChangeVo.setPriceChange(priceChange);
                priceChangeVo.setPriceChangeRate(rate);
                priceChangeList.add(priceChangeVo);
            }
            voOne.setPriceChangeList(priceChangeList);
            voList.add(voOne);
        });
        return voList;
    }
}
