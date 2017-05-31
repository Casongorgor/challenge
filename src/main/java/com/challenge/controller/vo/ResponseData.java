package com.challenge.controller.vo;

/**
 * Created by Cason
 */
public class ResponseData {
    private String code;//状态码
    private String info;//描述
    private Object data;//内容

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseData() {
        super();
    }

    public ResponseData(String code, String info) {
        super();
        this.code = code;
        this.info = info;
    }

    public ResponseData(Object data) {
        this("200","成功");
        this.data=data;
    }

    public static ResponseData checkError(String info){return new ResponseData("-1001",info);}

    public static ResponseData getSuccess(){
        return new ResponseData("200","成功");
    }

    public static ResponseData getSuccess(Object data){
        return new ResponseData(data);
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                ", data=" + data +
                '}';
    }
}
