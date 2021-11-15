package com.szp.web.plus.exception;

import static com.szp.web.plus.resp.RespCode.ERROR_500_B0001;

import com.szp.web.plus.resp.RespError;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: cause
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {

	private int status;

	private String errorCode;

	/**
	 * @param status  响应码
	 * @param message 响应信息
	 */
	public BaseException(int status, String message) {
		super(message);
		this.status = status;
	}

	/**
	 *
	 * @param cause 抛出异常
	 */
	public BaseException(Throwable cause) {
		super(cause.getMessage());
		this.errorCode = ERROR_500_B0001.getErrorCode();
		this.status = ERROR_500_B0001.getStatus();
	}

	public BaseException(RespError error){
		super(error.getMessage());
		this.status = error.getStatus();
		this.errorCode = error.getErrorCode();
	}

	public BaseException(int status, String message, String errorCode){
		super(message);
		this.status = status;
		this.errorCode = errorCode;
	}

}
