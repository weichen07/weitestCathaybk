package com.cathaybk.weitest.controller;

import com.cathaybk.weitest.response.Response;
import com.cathaybk.weitest.service.ProductService;
import com.cathaybk.weitest.service.SpiderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SpiderController {

    @Resource
    private SpiderService spiderService;

    @GetMapping(value = "/spider")
    public Response spiderFundData() {
        spiderService.computeFundData();
        return Response.success("success");
    }
}
