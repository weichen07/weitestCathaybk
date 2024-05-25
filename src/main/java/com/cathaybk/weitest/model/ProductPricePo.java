package com.cathaybk.weitest.model;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ProductPricePo {

	/** 商品id */
	private String productId;

	/** 商品價格 */
	private BigDecimal price;

	/** 商品貨幣種類 */
//	private String currency;

	/** 收盤日期 */
	private Timestamp statisticsDate;


}
