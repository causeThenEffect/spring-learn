package com.szp.basic.web.config.mybatisplus.injectoor;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;
import com.szp.basic.web.config.mybatisplus.methods.PhysicalDeleteById;
import java.util.List;

public class MySqlInjector extends DefaultSqlInjector {
/*
  @Override
  public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
    List<AbstractMethod> methodList = super.getMethodList(mapperClass);

    //TODO 内部自定义通用方法

    //Mybatis Plus自定义方法，即选装件
    methodList.add(new InsertBatchSomeColumn());
    methodList.add(new AlwaysUpdateSomeColumnById());
    methodList.add(new LogicDeleteByIdWithFill());
    methodList.add(new PhysicalDeleteById());
    return methodList;
  }*/
}
