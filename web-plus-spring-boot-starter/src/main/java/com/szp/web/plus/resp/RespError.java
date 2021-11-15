package com.szp.web.plus.resp;

/**
 * @author cause
 */
public interface RespError {

	int getStatus();

	String getErrorCode();

	String getMessage();
}
