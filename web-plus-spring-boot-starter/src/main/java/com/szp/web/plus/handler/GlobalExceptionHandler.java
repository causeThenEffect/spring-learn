package com.szp.web.plus.handler;

import static com.szp.web.plus.resp.RespCode.ERROR_500_B0001;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.szp.web.plus.exception.BaseException;
import com.szp.web.plus.resp.BaseResponse;
import com.szp.web.plus.resp.RespCode;
import com.szp.web.plus.resp.RestResponse;
import java.util.Objects;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Author: songzhipeng
 * @Description:
 */
@Log4j2
@RestControllerAdvice("com.vy")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Nullable
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			@Nullable MethodArgumentNotValidException ex, @Nullable HttpHeaders headers,
			@Nullable HttpStatus status, @Nullable WebRequest request) {
		if (Objects.isNull(ex)) {
			return null;
		}
		if (status == null) {
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(RestResponse.error(ex.getBindingResult()));
	}

	@Nullable
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(@Nullable Exception ex, Object body,
			HttpHeaders headers, HttpStatus status, @Nullable WebRequest request) {
		if (Objects.isNull(ex)) {
			return null;
		}
		String msg = ex.getMessage() + " cause by " + ex.getCause();
		log.error(ex.getMessage(), ex);
		BaseResponse response = BaseResponse.builder().message(msg).status(status.value()).build();
		if (ex.getCause() instanceof InvalidFormatException) {
			response = BaseResponse.error(new BaseException(RespCode.ERROR_400_A0430));
		}
		return super
				.handleExceptionInternal(ex, response, headers, status, Objects.requireNonNull(request));
	}

	/**
	 * 系统基本异常处理
	 *
	 * @param ex BaseException
	 * @return BaseResponse
	 */
	@ExceptionHandler({BaseException.class})
	public ResponseEntity<Object> handleBaseException(BaseException ex) {
		log.error(ex.getMessage(), ex);
		return ResponseEntity.status(ex.getStatus()).body(BaseResponse.error(ex));
	}

	/**
	 * @see org.apache.http.util.Asserts
	 * @param ex 数据校验异常处理
	 * @return ResponseEntity BaseResponse
	 */
	@ExceptionHandler({IllegalStateException.class, IllegalArgumentException.class})
	public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex) {
		log.error(ex.getMessage(), ex);
		return ResponseEntity.status(RespCode.ERROR_400_A0400.getStatus()).body(BaseResponse
				.error(new BaseException(RespCode.ERROR_400_A0400.getStatus(), ex.getMessage())));
	}

	/**
	 * @param ex 数据格式异常处理
	 * @return ResponseEntity BaseResponse
	 */
	@ExceptionHandler({InvalidFormatException.class})
	public ResponseEntity<Object> handleJsonValidException(InvalidFormatException ex) {
		log.error(ex.getMessage(), ex);
		return ResponseEntity.status(RespCode.ERROR_400_A0430.getStatus()).body(BaseResponse
				.error(new BaseException(RespCode.ERROR_400_A0430)));
	}
	/**
	 * 后端未曾捕获的异常返回默认对象
	 *
	 * @param ex Exception
	 * @return BaseResponse
	 */
	@ResponseStatus(INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
	public BaseResponse handlerException(Exception ex) {
		log.error(ex.getMessage(), ex);
		return BaseResponse.builder().message(ERROR_500_B0001.getMessage())
				.errorCode(ERROR_500_B0001.getErrorCode()).status(INTERNAL_SERVER_ERROR.value())
				.build();
	}
}
