create database cathaybk;
CREATE TABLE `product` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '商品名稱',
  `short_name` varchar(255) NOT NULL DEFAULT '' COMMENT '商品簡稱',
  `data_grouping` bit(1) NOT NULL DEFAULT b'0',
  `gmt_created` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '創建時間',
  `gmt_modified` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新時間',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品主表';

CREATE TABLE `product_price` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `product_id` int unsigned NOT NULL DEFAULT '0' COMMENT '商品id',
  `price` decimal(18,5) NOT NULL DEFAULT '0.00000' COMMENT '商品價格',
  `statistics_date` date NOT NULL COMMENT '淨值日期',
  `gmt_created` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '創建時間',
  `gmt_modified` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新時間',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_productid_statisticsdate` (`product_id`,`statistics_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品價格表';