package com.szp.basic.web.resp;

/**
 * @author songzhipeng
 */
public interface RespError {

	int getStatus();

	String getErrorCode();

	String getMessage();
}
