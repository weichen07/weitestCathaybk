package com.cathaybk.weitest.model.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MomentumVo {

    /** 商品id */
    private String productId;

    /** 商品每日漲跌與漲跌幅 */
    private List<PriceChangeVo>  priceChangeList;
}
