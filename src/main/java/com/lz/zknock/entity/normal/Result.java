package com.lz.zknock.entity.normal;

/**会话结果*/
public class Result {

    private int result_code;

    private Object original;

    private String message;

    public Result(int result_code,String message){
        this.result_code=result_code;
        this.message=message;
    }

    public int getResult_code() {
        return result_code;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

    public Object getOriginal() {
        return original;
    }

    public void setOriginal(Object original) {
        this.original = original;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
