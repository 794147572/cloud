package com.jxph.cloud.service.fast.server.dao;

import com.jxph.cloud.service.fast.api.pojo.CouponTaskJob;
import com.jxph.cloud.service.fast.api.pojo.CouponTaskJobExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponTaskJobMapper {
    long countByExample(CouponTaskJobExample example);

    int deleteByExample(CouponTaskJobExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponTaskJob record);

    int insertSelective(CouponTaskJob record);

    List<CouponTaskJob> selectByExample(CouponTaskJobExample example);

    CouponTaskJob selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponTaskJob record, @Param("example") CouponTaskJobExample example);

    int updateByExample(@Param("record") CouponTaskJob record, @Param("example") CouponTaskJobExample example);

    int updateByPrimaryKeySelective(CouponTaskJob record);

    int updateByPrimaryKey(CouponTaskJob record);
}