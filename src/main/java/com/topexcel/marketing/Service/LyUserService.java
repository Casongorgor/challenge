package com.topexcel.marketing.Service;

import com.topexcel.marketing.mapper.LyUserMapper;
import com.topexcel.marketing.model.LyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jingle.huang on 2017/3/9.
 */
@Service
public class LyUserService {
    @Autowired
    LyUserMapper lyUserMapper;

    public LyUser selectByPrimaryKey(Integer id){
        return lyUserMapper.selectByPrimaryKey(id);
    }
}
