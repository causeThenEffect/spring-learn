import com.szp.service.config.MybatisConfig;
import com.szp.service.service.UserDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author songzhipeng
 * @DATE 2021/10/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MybatisConfig.class)
public class UserDetailServiceTest {

  @Autowired
  UserDetailService userDetailService;

  @Test
  public void test() {
    userDetailService.getUsers();
  }

}
