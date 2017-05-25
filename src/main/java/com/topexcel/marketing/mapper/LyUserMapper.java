package com.topexcel.marketing.mapper;


import com.topexcel.marketing.model.LyUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LyUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LyUser record);

    int insertSelective(LyUser record);

    LyUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LyUser record);

    int updateByPrimaryKey(LyUser record);
}