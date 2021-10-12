package com.szp.configclient.control;

import com.szp.configclient.dto.SimpleDto;
import com.szp.configclient.dto.SimpleQry;
import com.szp.configclient.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	
	@Autowired
	private SimpleService simpleService;
	
	/**
	 * 无参服务
	 * @return
	 */
    @RequestMapping(value = "/simple")
    public SimpleDto simple() {
        return simpleService.simple();
    }
    
    /**
     * 单个参数请求
     * @param transparentString
     * @return
     */
    @RequestMapping(value = "/simplewithoneparam/{transparentString}")
    public SimpleDto simpleWithOneParam(@PathVariable("transparentString")String transparentString) {
        return simpleService.simpleWithOneParam(transparentString);
    }
    
    /**
     * 带多个参数请求
     * @param qry
     * @return
     */
    @RequestMapping(value = "/simplewithqry")
    public SimpleDto simpleWithQry(@RequestBody SimpleQry qry) {
        return simpleService.simpleWithQry(qry);
    }
    
}
