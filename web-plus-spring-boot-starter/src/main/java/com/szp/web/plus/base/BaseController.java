package com.szp.web.plus.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.szp.web.plus.handler.BaseContextHandler;
import com.szp.web.plus.resp.BaseResponse;
import com.szp.web.plus.resp.RestResponse;
import com.szp.web.plus.utils.IPageUtil;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author cause
 * @version 1.0.0 create time 7/5/2020 6:48 PM
 */
@Log4j2
public class BaseController {

  protected BaseResponse base(Supplier<?> supplier) {
    supplier.get();
    return BaseResponse.ok();
  }

  protected BaseResponse baseWithUser(Consumer<Long> consumer) {
    consumer.accept(BaseContextHandler.getUserId());
    return BaseResponse.ok();
  }

  protected <T> RestResponse<T> rest(Supplier<T> supplier) {
    return RestResponse.ok(supplier.get());
  }

  protected <T> RestResponse<T> restWithUser(Function<Long, T> func) {
    return RestResponse.ok(func.apply(BaseContextHandler.getUserId()));
  }

  protected <T> RestResponse<IPage<T>> restPage(Supplier<IPage<T>> supplier) {
    return RestResponse.ok(supplier.get());
  }

  protected <T> RestResponse<IPage<T>> restPageWithUser(Function<Long, IPage<T>> func) {
    return RestResponse.ok(func.apply(BaseContextHandler.getUserId()));
  }

  @Deprecated
  protected <ReqVO> BaseResponse base(Supplier<BaseResponse> supplier, ReqVO reqVO) {
    return supplier.get();
  }

  @Deprecated
  protected <ReqVO> BaseResponse baseWithUser(Function<Long, BaseResponse> func, ReqVO reqVO) {
    return func.apply(BaseContextHandler.getUserId());
  }

  @Deprecated
  protected <ReqVO, T> RestResponse<T> rest(Supplier<RestResponse<T>> supplier, ReqVO reqVO) {
    return supplier.get();
  }

  @Deprecated
  protected <ReqVO, T> RestResponse<T> restWithUser(Function<Long, RestResponse<T>> func,
      ReqVO reqVO) {
    return func.apply(BaseContextHandler.getUserId());
  }

  @Deprecated
  protected <ReqVO, T> RestResponse<IPage<T>> restPage(Supplier<RestResponse<IPage<T>>> supplier,
      ReqVO reqVO) {
    return supplier.get();
  }

  @Deprecated
  protected <ReqVO, T> RestResponse<IPage<T>> restPageWithUser(
      Function<Long, RestResponse<IPage<T>>> func, ReqVO reqVO) {
    return func.apply(BaseContextHandler.getUserId());
  }

  protected <R, T> IPage<R> transfer(IPage<T> source, List<R> target) {
    return IPageUtil.transfer(source, target);
  }

  private <ReqVO> void printReqVo(ReqVO reqVO) {
    if (Objects.nonNull(reqVO)) {
      log.info("参数 ==> {} ",
          ToStringBuilder.reflectionToString(reqVO, ToStringStyle.SHORT_PREFIX_STYLE)
              .replaceAll("^(.{100}).*$", "$1..."));
    }
  }

  protected <T, S> IPage<T> supperTransfer(Supplier<IPage> source, Function<S, T> converter) {
    return IPageUtil.supperTransfer(source, converter);
  }
}
