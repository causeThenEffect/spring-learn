package com.szp.web.plus.config.mybatisplus.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class PhysicalDeleteById  extends AbstractMethod {

	@Override
	public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass,
			TableInfo tableInfo) {
		String sql;
		VYSqlMethod sqlMethod =  VYSqlMethod.PHYSICAL_DELETE_BY_ID;
		sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(), tableInfo.getKeyColumn(),
				tableInfo.getKeyProperty());
		SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, Object.class);
		return this.addDeleteMappedStatement(mapperClass, sqlMethod.getMethod(), sqlSource);
	}
}
