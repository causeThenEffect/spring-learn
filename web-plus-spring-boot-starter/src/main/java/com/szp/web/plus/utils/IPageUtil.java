package com.szp.web.plus.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @Description: IPage
 */
public class IPageUtil {

    private static final IPage<Object> EMPTY_PAGE = new Page<>();

    public static <R, T> Page<R> transfer(IPage<T> source, List<R> target) {
        if (Objects.isNull(source)) {
            source = (Page<T>)EMPTY_PAGE;
        }
        Page<R> iPage = new Page<>(source.getCurrent(), source.getSize(), source.getTotal());
        iPage.setPages(source.getPages());
        iPage.setTotal(source.getTotal());
        iPage.setRecords(target);
        return iPage;
    }

    public static <T, S> IPage<T> supperTransfer(Supplier<IPage> source, Function<S, T> converter) {
        IPage iPage = source.get();
        if (Objects.isNull(iPage)) {
            iPage = (Page)EMPTY_PAGE;
        }
        List<S> records = iPage.getRecords();
        List<T> results = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(records)) {
            results = records.stream().map(converter).collect(Collectors.toList());
        }
        return transfer(iPage, results);
    }
}