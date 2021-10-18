package com.szp.basic.web.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse<T> extends BaseResponse {

	private T data;

	private RestResponse(int status, String message, String errorCode,
			List<ErrorInfo> errorInfos, T data) {
		super(status, message, errorCode, errorInfos);
		this.data = data;
	}

	public static <T> RestResponse<T> ok(T data) {
		return new RestResponse<>(
				RespCode.OK_200.getStatus(), RespCode.OK_200.getMessage(), RespCode.OK_200.getErrorCode(),
				null, data);
	}

	public boolean isOk() {
		return getStatus() == RespCode.OK_200.getStatus();
	}

}
