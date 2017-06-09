package com.challenge.Service;

import com.challenge.controller.vo.ResponseData;
import com.challenge.mapper.UsersMapper;
import com.challenge.mapper.VoteRecordMapper;
import com.challenge.model.Users;
import com.challenge.model.VoteRecord;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by jingle.huang on 2017/4/7.
 */
@Service
public class UsersService {
    private static final Logger log = LoggerFactory.getLogger(UsersService.class);

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private VoteRecordMapper voteRecordMapper;

    @Autowired
    private SmsService smsService;

    public ResponseData generateVcode(String mobile) {

        if (StringUtils.isEmpty(mobile) || !Pattern.matches("^1[34587]\\d{9}$", mobile)) {
            return ResponseData.checkError("请输入正确的手机号码！");
        }

        //生成验证码
        String vCode = generateCode();


        // 发送短信
        smsService.sendVcode(mobile, vCode);

        Users users = usersMapper.selectByMobile(mobile);
        if (users == null) {
            users = new Users();
            users.setMobile(mobile);
            users.setCreatedDate(new Date());
            users.setName(mobile);
            users.setVcodeDate(new Date());
            users.setVcode(vCode);
            usersMapper.insert(users);
        } else {
            users.setVcodeDate(new Date());
            users.setVcode(vCode);
            usersMapper.updateByPrimaryKey(users);
        }
        log.info("generateVcode--------vCode:{}", vCode);
        Map<String, String> result = new HashMap<>();
        result.put("vCode", "");
        result.put("mobile", mobile);

        return ResponseData.getSuccess();

    }

    public ResponseData generateToken(String mobile, String vCode) {
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(vCode)) {
            return ResponseData.checkError("请输入正确的手机号码或验证码！");
        }

        Users users = usersMapper.selectByMobile(mobile);
        if (users == null) {
            return ResponseData.checkError("请输入正确的手机号码或验证码！");
        }

        if (!vCode.equals(users.getVcode())) {
            return ResponseData.checkError("请输入正确的手机号码或验证码！");
        }
        String token = getUUID();
        users.setToken(token);
        usersMapper.updateByPrimaryKey(users);

        Map<String, String> result = new HashMap<>();
        result.put("vCode", vCode);
        result.put("token", token);

        return ResponseData.getSuccess(result);

    }

    public ResponseData voteSubmit(VoteRecord voteRecord, String token) {

        Users users = usersMapper.selectByMobile(voteRecord.getMobile());
        if (users == null) {
            return ResponseData.checkError("请输完成验证后再投票！");
        }

        if (StringUtils.isEmpty(token) || !token.equals(users.getToken())) {
            return ResponseData.checkError("请输完成验证后再投票！");
        }

        int voteCount = voteRecordMapper.countVoteRecCurrentDate(voteRecord.getMobile());

        if (voteCount >= 3) {
            return ResponseData.checkError("你已投票3次！");
        }

        voteRecord.setVoteDate(new Date());
        voteRecord.setId(null);
        voteRecordMapper.insert(voteRecord);

        return ResponseData.getSuccess();
    }

    public ResponseData listResult(String voteGroup){
        List<Map> reusltList=voteRecordMapper.listVoteResultByVoteGroup(voteGroup);
        return ResponseData.getSuccess(reusltList);
    }

    private String generateCode() {
        String code = String.valueOf(getRandNum(1, 9999));
        return StringUtils.leftPad(code,4,"0");
    }

    private int getRandNum(int min, int max) {
        int randNum = min + (int) (Math.random() * ((max - min) + 1));
        return randNum;
    }


    private String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


}
