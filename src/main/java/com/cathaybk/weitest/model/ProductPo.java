package com.cathaybk.weitest.model;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class ProductPo {
	/** PK */
	private String id;

	/** 商品名稱 */
	private String name;

	/** 商品簡稱 */
	private String shortName;

	private Boolean dataGrouping;

	/** 創建時間 */
	private Timestamp gmtCreated;

	/** 更新時間 */
	private Timestamp gmtModified;

}
