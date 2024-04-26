package com.zhaopei.wiki.mapper;

import com.zhaopei.wiki.entity.demo;
import com.zhaopei.wiki.entity.demoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface demoMapper {
    long countByExample(demoExample example);

    int deleteByExample(demoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(demo record);

    int insertSelective(demo record);

    List<demo> selectByExample(demoExample example);

    demo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") demo record, @Param("example") demoExample example);

    int updateByExample(@Param("record") demo record, @Param("example") demoExample example);

    int updateByPrimaryKeySelective(demo record);

    int updateByPrimaryKey(demo record);
}