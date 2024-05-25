package com.cathaybk.weitest.service;

import com.cathaybk.weitest.mapper.ProductMapper;
import com.cathaybk.weitest.model.ProductPo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * product 表相關操作
 * @author wei
 */
@Slf4j
@Service
public class ProductService {
    @Resource
    private ProductMapper productMapper;
    public List<ProductPo> selectAllProduct() {
        return productMapper.selectAllProduct();
    }

    public void insertProduct(String productId, String name, String shortName){
        productMapper.insertProduct(productId,name,shortName);
    }
}
