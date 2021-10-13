package com.szp.feignconsumer2.service;

import com.szp.feignconsumer2.dto.SimpleDto;
import com.szp.feignconsumer2.dto.SimpleQry;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements ISimpleClient {

	@Override
	public String call() {
		System.out.println(this);
		return "access remote server error!";
	}

	@Override
	public SimpleDto simpleWithOneParam(String transparentString) {
		SimpleDto dto = new SimpleDto();
		dto.setCode(-1);
		dto.setErrorMsg("access remote server error!");
		return dto;
	}

	@Override
	public SimpleDto simpleWithQry(SimpleQry qry) {
		SimpleDto dto = new SimpleDto();
		dto.setCode(-1);
		dto.setErrorMsg("access remote server error!");
		return dto;
	}

}
