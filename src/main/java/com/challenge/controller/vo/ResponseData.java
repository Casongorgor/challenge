package com.challenge.controller.vo;

/**
 * Created by Cason
 */
public class ResponseData {
    private String code;//状态码
    private String info;//描述

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ResponseData() {
        super();
    }

    public ResponseData(String code, String info) {
        super();
        this.code = code;
        this.info = info;
    }

    public static ResponseData checkError(String info){return new ResponseData("-1001",info);}

    public static ResponseData getSuccess(){
        return new ResponseData("0","成功");
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
