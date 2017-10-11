package com.lz.zknock.entity.websocket;

/**js消息*/
public class WSJSMessage {

    /**消息类型*/
    private int type;
    /**消息结果*/
    private int result_code;
    /**扩展字段*/
    private Object origin;
    /**消息内容*/
    private Object message;

    public WSJSMessage(int type,Object message){
        this.type=type;
        this.message=message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getResult_code() {
        return result_code;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

    public Object getOrigin() {
        return origin;
    }

    public void setOrigin(Object origin) {
        this.origin = origin;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
