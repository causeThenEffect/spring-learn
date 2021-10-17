package com.szp.aspectlearn;

import com.szp.aspectlearn.controller.ArticleController;
import com.szp.aspectlearn.service.ArticleListService;
import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AspectLearnApplicationTests {

  /*private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setup() {
    // 实例化方式一
//    mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//     实例化方式二
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void test() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/getCommentList"))
        .andDo(MockMvcResultHandlers.print());
  }
*/

//  @Autowired
  private TestRestTemplate restTemplate = new TestRestTemplate();

  @Test
  public void test() {
    this.restTemplate.getForObject("http://localhost:9004/getCommentList", String.class);
  }

}
