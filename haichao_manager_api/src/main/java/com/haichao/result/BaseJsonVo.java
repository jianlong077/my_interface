package com.haichao.result;

import java.io.Serializable;

/**
 * 控制层返回封装类
 * 
 * @author LOVE_HAIYAN_521
 *
 * @param <T>
 */
public class BaseJsonVo<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int SUCCESS_CODE = 200;
	public static final String SUCCESS_MESSAGE = "操作成功";
	
	public static final int NO_LOGIN_CODE = 401;
	public static final String NO_LOGIN_MESSAGE = "客户端未登录！";
	
	public static final int ERROR_ACCOUNT_LOGIN_CODE = 402;
	public static final String ERROR_ACCOUNT_LOGIN_MESSAGE = "账户错误！";
	
	public static final int NO_PASSWORD = 403;
	public static final String NO_PASSWORD_MESSAGE = "密码错误！";
	
	public static final int NO_SECURITY_CODE = 404;
	public static final String NO_SECURITY_MESSAGE = "无权限！";
	
	public static final int SING_CODE = 405;
	public static final String SIGN_MESSAGE = "验证失败！";
	
	public static final int PARAM_CODE = 406;
	public static final String PARAM_MESSAGE = "参数错误";
    public static final int ERROR_IP_CODE = 407;
    public static final String ERROR_IP_MESSAGE = "ip受限";
    public static final int ERROR_CURRENT_LIMIT_CODE = 408;
    public static final String ERROR_CURRENT_LIMIT_MESSAGE = "进行了限流控制";
    public static final int ERROR_METHOD_CODE = 409;
    public static final String ERROR_METHOD_MESSAGE = "方法受限";
	public static final int ERROR_CODE = 500;
	public static final String ERROR_MESSAGE = "服务器繁忙，不可用，请稍后重试";
	public static final int ERROR_NO_EXIST_CODE = 501;
	public static final String ERROR_NO_EXIST_MESSAGE = "数据不存在";
	public   String code = "";
	public   String out_code = "";
	private int status=200;
	private String message="成功";
	private long version = 1L;
	private T value;
	private long serverTime = System.currentTimeMillis();

	public BaseJsonVo<T> isSuccee(String code){
		this.code=code;
		return this;
	}
	public BaseJsonVo isFail (String message){
		this.status=500;
		this.message=message;
		return this;
	}

	public BaseJsonVo() {
        this.status = 200;
    }

	public BaseJsonVo(T value) {
		this.value = value;
	}

	public int getStatus() {
		return status;
	}

	public BaseJsonVo(int status, String message, T value) {
		this.status = status;
		this.message = message;
		this.value = value;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public long getServerTime() {
		return serverTime;
	}

	public void setServerTime(long serverTime) {
		this.serverTime = serverTime;
	}

	public void isError(String message) {
		this.status = this.ERROR_CODE ;
		this.message=message;
	}
	public void isError(String message,int ERROR_CODE) {
		this.status = ERROR_CODE ;
		this.message=message;
	}
	public void isSuccess(String message) {
		this.status = this.SUCCESS_CODE ;
		this.message=message;
	}
	public void isSuccess(String message,int SUCCESS_CODE) {
		this.status = SUCCESS_CODE ;
		this.message=message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOut_code() {
		return out_code;
	}

	public void setOut_code(String out_code) {
		this.out_code = out_code;
	}
}
