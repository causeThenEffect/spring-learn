package com.szp.basic.web.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szp.basic.web.handler.BaseContextHandler;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lombok.NonNull;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @Author: songzhipeng
 * @Description:
 */
public class BaseService<M extends VYBaseMapper<T>, T extends BasePO> extends ServiceImpl<M, T> {


	/**
	 * 分页查询数据
	 *
	 * @param q 查询对象
	 * @param supplier 查询条件
	 * @param compose 数据转换函数
	 * @param <R> 返回数据结构
	 * @param <Q> 查询数据结构
	 * @return IPage<R>
	 */
	protected <R, Q extends BasePageReqVO> IPage<R> page(Q q, Supplier<QueryWrapper<T>> supplier,
			Function<T, R> compose) {
		Page<T> queryPage = new Page<>(q.getStartPage(), q.getPageSize(), true);
		Page<T> poPage = baseMapper.selectPage(queryPage, supplier.get());
		List<T> records = poPage.getRecords();
		if (CollectionUtils.isNotEmpty(records)) {
			List<R> finalResult = records.stream().map(compose).collect(Collectors.toList());
			Page<R> rPage = new Page<>(q.getStartPage(), q.getPageSize(), true);
			rPage.setTotal(poPage.getTotal());
			rPage.setRecords(finalResult);
			rPage.setCurrent(poPage.getCurrent());
			return rPage;
		}
		return new Page<>(q.getStartPage(), q.getPageSize(), true);
	}


	protected T saveWithCreator(@NonNull T t) {
		t.setCreator(BaseContextHandler.getUserId());
		t.setCreatedTime(new Date());
		save(t);
		return t;
	}

	protected T updateWithModifier(@NonNull T t) {
		t.setModifier(BaseContextHandler.getUserId());
		t.setUpdatedTime(new Date());
		saveOrUpdate(t);
		return t;
	}

}
