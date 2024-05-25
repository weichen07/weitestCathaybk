package com.cathaybk.weitest.feign;

import com.cathaybk.weitest.model.vo.FundPriceVo;
import com.cathaybk.weitest.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;


@FeignClient(name = "CathaybkFund",url = "https://www.cathaybk.com.tw/cathaybk/service")
public interface CathaybkFundFeign {

//Map<String,String> reqData
    //@RequestMapping(method = RequestMethod.POST, value ="https://www.cathaybk.com.tw/cathaybk/service/newwealth/fund/chartservice.asmx/GetFundNavChart")
    @PostMapping("/newwealth/fund/chartservice.asmx/GetFundNavChart")
    Response<List<FundPriceVo>> getFundNavChart(@RequestBody Map reqData);
}
