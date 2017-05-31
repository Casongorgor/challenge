package com.challenge.controller;

import com.challenge.Service.UsersService;
import com.challenge.common.HeaderCons;
import com.challenge.controller.vo.ResponseData;
import com.challenge.model.VoteRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jingle.huang on 2017/3/9.
 */
@RestController
public class IndexController {
    private final Logger log = LoggerFactory.getLogger(IndexController.class);


    @Autowired
    UsersService usersService;


    /**
     * 获取手机验证码
     *
     * @param mobile
     * @return
     */
    @GetMapping(value = "/user/generateVcode")
    public ResponseData generateVcode(String mobile) {
        log.info("generateVcode-------------mobile:{}", mobile);

        return usersService.generateVcode(mobile);
    }

    /**
     * 验证手机和验证码，获取token
     *
     * @param mobile
     * @param vCode
     * @return
     */
    @PostMapping(value = "/user/generateToken")
    public ResponseData generateToken(String mobile, String vCode) {
        log.info("generateToken-------------mobile:{}, vCode:{}", mobile, vCode);
        return usersService.generateToken(mobile, vCode);
    }

    /**
     * 提交投票信息，先经过token验证，再校验今天投票次数
     * @param voteRecord
     * @param token
     * @return
     */
    @PostMapping(value = "/vote/submit")
    public ResponseData voteSubmit(@RequestBody VoteRecord voteRecord, @RequestHeader(HeaderCons.ACCESS_TOKEN) String token) {
        log.info("voteSubmit-------------voteRecord: {}, token:{}", voteRecord, token);
        return usersService.voteSubmit(voteRecord, token);
    }

    /**
     * 根据投票分组，获取投票排名列表
     * @param voteGroup
     * @return
     */
    @GetMapping(value = "/vote/listResult")
    public ResponseData listResult(String voteGroup) {
        log.info("listResult-------------voteGroup: {}",voteGroup);
        return usersService.listResult(voteGroup);
    }


}
