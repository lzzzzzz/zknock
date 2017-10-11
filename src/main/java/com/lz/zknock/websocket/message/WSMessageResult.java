package com.lz.zknock.websocket.message;

public class WSMessageResult {
    /**错误码*/
    private int resultCode=MessageCodeConfig.RESULT_SUCCESS;
    /**异常信息*/
    private Exception exception;
    /**异常信息*/
    private String error_message;
    private String mark;//扩展

    public WSMessageResult(){
        resultCode=MessageCodeConfig.RESULT_SUCCESS;
        exception=null;
    }

    public WSMessageResult(int error_Code){
        resultCode=error_Code;
    }

    public WSMessageResult(int error_Code,Exception exception){
        resultCode=error_Code;
        exception=exception;
    }

    public WSMessageResult(int error_Code,String error_message){
        resultCode=error_Code;
        error_message=error_message;
        exception=new Exception(error_message);
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}
