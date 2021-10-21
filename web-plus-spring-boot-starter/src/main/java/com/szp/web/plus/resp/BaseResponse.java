package com.szp.web.plus.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.szp.web.plus.exception.BaseException;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.BindingResult;

/**
 * @Author: songzhipeng
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

	private int status;

	private String message;

	private String errorCode;

	private List<ErrorInfo> errorInfos;

	protected BaseResponse(int status, String message, String errorCode,
			List<ErrorInfo> errorInfos) {
		this.status = status;
		this.message = message;
		this.errorCode = errorCode;
		this.errorInfos = errorInfos;
	}

	/**
	 * @see RespCode
	 * @return OK Response
	 */
	public static BaseResponse ok() {
		return BaseResponse.builder()
				.status(RespCode.OK_200.getStatus())
				.errorCode(RespCode.OK_200.getErrorCode())
				.message(RespCode.OK_200.getMessage()).build();
	}

	/**
	 * @see RespCode
	 * @param errors BindingResultE
	 * @return Error Response
	 */
	public static BaseResponse error(@NonNull BindingResult errors) {
		List<ErrorInfo> errorInfos = new ArrayList<>();
		errors.getFieldErrors().forEach((e) -> {
			errorInfos.add(
					ErrorInfo.builder().type(e.getCode()).field(e.getField()).info(e.getDefaultMessage())
							.build());
		});
		return BaseResponse.builder().errorCode(RespCode.ERROR_400_A0400.getErrorCode())
				.status(RespCode.ERROR_400_A0400.getStatus())
				.message(RespCode.ERROR_400_A0400.getMessage())
				.errorInfos(errorInfos).build();
	}

	/**
	 * @see RespCode
	 * @param respCode ErrorCode
	 * @return Error Response
	 */
	public static BaseResponse error(@NonNull RespCode respCode){
		return BaseResponse.builder().errorCode(respCode.getErrorCode())
				.status(respCode.getStatus())
				.message(respCode.getMessage()).build();
	}

	public static BaseResponse error(@NonNull BaseException ex){
		return BaseResponse.builder()
				.status(ex.getStatus())
				.errorCode(ex.getErrorCode())
				.message(ex.getMessage())
				.build();
	}

}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ErrorInfo {

	private String field;

	private String info;

	private String type;
}