package com.cathaybk.weitest.service;

import com.cathaybk.weitest.model.vo.MomentumVo;

import java.time.LocalDate;
import java.util.List;

public interface RateService {

    /** 實作基金漲跌幅 計算漲跌[後收-前收]和漲跌幅[(後收-前收)/前收]*/
    List<MomentumVo> selectFundMomentum(LocalDate startTime , LocalDate endTime);
}
