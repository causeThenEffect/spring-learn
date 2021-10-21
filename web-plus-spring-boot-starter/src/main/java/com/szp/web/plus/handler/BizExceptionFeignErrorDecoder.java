package com.szp.web.plus.handler;

import com.alibaba.fastjson.JSONObject;
import com.szp.web.plus.exception.BaseException;
import com.szp.web.plus.resp.BaseResponse;
import com.szp.web.plus.resp.RespCode;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import java.util.Objects;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @Author: songzhipeng
 * @Description: 该类用于搭配全局异常使用，用于处理feign调用 时 异常转换
 */
@Log4j2
@Component
public class BizExceptionFeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		if (HttpStatus.valueOf(response.status()).isError()) {
			try {
				BaseResponse baseResponse = JSONObject
						.parseObject(Util.toString(response.body().asReader()), BaseResponse.class);
				if(Objects.isNull(baseResponse) || Objects.isNull(baseResponse.getMessage())){
					return new BaseException(response.status(), Util.toString(response.body().asReader()),
							RespCode.ERROR_500_B0001.getErrorCode());
				}
				return new BaseException(response.status(), baseResponse.getMessage(),
						baseResponse.getErrorCode());
			} catch (Exception e){
				log.error(e.getMessage(), e);
				return e;
			}
		}
		return feign.FeignException.errorStatus(methodKey, response);
	}
}
