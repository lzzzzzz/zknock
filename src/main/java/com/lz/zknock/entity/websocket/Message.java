package com.lz.zknock.entity.websocket;

/**app会话消息内容*/
public class Message {
    private int type;

    /**扩展*/
    private Object original;
    /**发送人id*/
    private String from_id;
    /**发送人名字*/
    private String from_name;
    /**接收人id*/
    private String to_id;
    /**接收人名字*/
    private String to_name;
    /**消息内容*/
    private String message;

    public Message(int type, String message) {
        this.type=type;
        this.message=message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getOriginal() {
        return original;
    }

    public void setOriginal(Object original) {
        this.original = original;
    }

    public String getFrom_id() {
        return from_id;
    }

    public void setFrom_id(String from_id) {
        this.from_id = from_id;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public String getTo_id() {
        return to_id;
    }

    public void setTo_id(String to_id) {
        this.to_id = to_id;
    }

    public String getTo_name() {
        return to_name;
    }

    public void setTo_name(String to_name) {
        this.to_name = to_name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
