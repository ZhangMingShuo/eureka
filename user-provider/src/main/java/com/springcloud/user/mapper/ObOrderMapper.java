package com.springcloud.user.mapper;

import com.springcloud.mapper.MyMapper;
import com.springcloud.pojo.ObOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface ObOrderMapper extends MyMapper<ObOrder> {
    @Select("com.springcloud.user.mapper.ObOrderMapper.genWaybillNo")
    String genWaybillNo(@Param("bigType") String bigType,@Param("dtOrderDate") Date dtOrderDate);
}
