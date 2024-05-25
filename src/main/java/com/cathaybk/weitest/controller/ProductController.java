package com.cathaybk.weitest.controller;

import com.cathaybk.weitest.mapper.ProductMapper;
import com.cathaybk.weitest.response.Response;
import com.cathaybk.weitest.service.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping(value = "/selectAllProduct")
    public Response selectAllProduct() {
        return Response.success(productService.selectAllProduct());
    }
}
