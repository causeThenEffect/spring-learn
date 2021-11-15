package com.cause.mybatis.springboot;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * spy和mock的区别，spy默认会走真实的方法，mock默认不会走真实的方法
 */
public class MockTest {

  // 测试 spy
  @Test
  public void test_spy() {

    ExampleService spyExampleService = spy(new ExampleService());

    // 默认会走真实方法
    Assert.assertEquals(3, spyExampleService.add(1, 2));

    // 打桩后，不会走了
    when(spyExampleService.add(1, 2)).thenReturn(10);
    Assert.assertEquals(10, spyExampleService.add(1, 2));

    // 但是参数不匹配的调用，依然走真实方法
    Assert.assertEquals(3, spyExampleService.add(2, 1));

  }

  // 测试 mock
  @Test
  public void test_mock() {

    ExampleService mockExampleService = mock(ExampleService.class);


    // 默认返回结果是返回类型int的默认值
    Assert.assertEquals(0, mockExampleService.add(1, 2));

    when(mockExampleService.add(1,2)).thenReturn(3);
    Assert.assertEquals(3, mockExampleService.add(1, 2));

  }

}

class ExampleService {

  int add(int a, int b) {
    return a + b;
  }

}