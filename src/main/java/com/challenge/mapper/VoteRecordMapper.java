package com.challenge.mapper;

import com.challenge.model.VoteRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface VoteRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VoteRecord record);

    int insertSelective(VoteRecord record);

    VoteRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VoteRecord record);

    int updateByPrimaryKey(VoteRecord record);

    int countVoteRecCurrentDate (String mobile);

    List<Map> listVoteResultByVoteGroup(String voteGroup);
}