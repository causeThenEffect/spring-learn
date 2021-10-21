package com.szp.web.plus.resp;

/**
 * @author songzhipeng
 */
public interface RespError {

	int getStatus();

	String getErrorCode();

	String getMessage();
}
