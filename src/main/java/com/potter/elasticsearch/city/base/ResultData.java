package com.potter.elasticsearch.city.base;

import java.io.Serializable;

public class ResultData<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final String SUCCESS = "1";
	
	private static final String BSI_FAIL = "0";
	
	private static final String SYS_FAIL = "-1";

	private String returnState; // 状�??(1:成功;0:业务异常;-1:系统异常)

	private String errorCode; // 业务错误�? (returnState�?0表示具体业务异常)

	private String errorMessage; // 提示信息(失败原因描述,若成功则值为"success")

	private T data; // 返回实体�?

	public ResultData() {
		super();
	}

	/**
	 * 
	 * @Title: success
	 * @Description: 返回调用成功数据
	 * @param data
	 * @return
	 * @return ResultData
	 */
	@SuppressWarnings("unchecked")
	public static ResultData success(Object data) {
		return new ResultData(SUCCESS, "", "success", data);
	}

	/**
	 * 
	 * @Title: success
	 * @Description: 调用异常,如连接超�?,数据库异常等非业务异�?
	 * @param data
	 * @return
	 * @return ResultData
	 */
	@SuppressWarnings("unchecked")
	public static ResultData error(String errorCode, String errorMessage) {
		return new ResultData(SYS_FAIL, errorCode, errorMessage, null);
	}

	/**
	 * 
	 * @Title: success
	 * @Description: 调用异常,如连接超�?,数据库异常等非业务异�?
	 * @param data
	 * @return
	 * @return ResultData
	 */
	@SuppressWarnings("unchecked")
	public static ResultData error(String errorMessage) {
		return new ResultData(SYS_FAIL, "", errorMessage, null);
	}

	/**
	 * 
	 * @Title: deny
	 * @Description: 调用正常,但是业务异常
	 * @param errorCode
	 * @param errorMessage
	 * @return
	 * @return ResultData
	 */
	@SuppressWarnings("unchecked")
	public static ResultData deny(String errorCode, String errorMessage) {
		return new ResultData(BSI_FAIL, errorCode, errorMessage, null);
	}

	/**
	 * @Title: deny
	 * @Description: 调用正常,但是业务异常
	 * @param errorCode
	 * @param errorMessage
	 * @return
	 * @return ResultData
	 */
	@SuppressWarnings("unchecked")
	public static ResultData deny(String errorMessage) {
		return new ResultData(BSI_FAIL, "", errorMessage, null);
	}

	public ResultData(String returnState, String errorCode, String errorMessage) {
		super();
		this.returnState = returnState;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ResultData(String returnState, String errorCode, String errorMessage, T data) {
		this.returnState = returnState;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultData [returnState=" + returnState + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage
				+ ", data=" + data + "]";
	}

	public String getReturnState() {
		return returnState;
	}

	public void setReturnState(String returnState) {
		this.returnState = returnState;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
