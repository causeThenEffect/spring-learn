package com.szp.web.plus.resp;

/**
 * @author songzhipeng
 */

public enum RespCode implements RespError {

	OK_200(200, "00000", "OK!"),
	ERROR_400_A0400(400, "A0400","用户请求参数错误"),
	ERROR_400_A0430 (400,"A0430","用户输入内容非法"),
	ERROR_400_A0111(400, "A0111","用户名已存在"),
	ERROR_400_A0201(400, "A0201","用户账户不存在"),
	ERROR_400_A0210(400, "A0210","用户密码错误"),
	ERROR_401_A0312(401, "A0312","无权限使用API"),
	ERROR_403_A0301(403, "A0301","服务器拒绝访问"),
	ERROR_404_C0113(404, "C0113","接口不存在"),




	ERROR_500_B0001(500, "B0001", "系统执行出错"),
	ERROR_501_B0001(500, "B5001", "添加操作日志失败"),

	//用户资源模块
	ERROR_601_B0001(200, "B0001", "数据过滤参数异常");

	int status;

	String errorCode;

	String message;


	RespCode(int status, String errorCode, String message) {
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
	}

	@Override
	public int getStatus() {
		return status;
	}

	@Override
	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
