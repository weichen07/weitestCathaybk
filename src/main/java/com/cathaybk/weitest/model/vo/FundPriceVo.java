package com.cathaybk.weitest.model.vo;

import com.cathaybk.weitest.model.ProductPo;
import com.cathaybk.weitest.model.ProductPricePo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FundPriceVo {
    /** PK */
    private String id;

    /** 商品名稱 */
    private String name;

    /** 商品簡稱 */
    private String shortName;

    private Boolean dataGrouping;
    private List<List<BigDecimal>> data;
}
