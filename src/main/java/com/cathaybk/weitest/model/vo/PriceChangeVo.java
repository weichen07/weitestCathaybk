package com.cathaybk.weitest.model.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class PriceChangeVo {

    /** 漲跌 */
    private BigDecimal priceChange;

    /** 漲跌幅 */
    private BigDecimal priceChangeRate;

    /** 收盤日期 */
    private Timestamp statisticsDate;
}
