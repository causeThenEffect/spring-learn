import com.szp.spring.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextTest {

  @Test
  public void test() {
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean-test.xml");
    User user = classPathXmlApplicationContext.getBean(User.class);
    Assert.assertEquals("cause", user.getName());
  }

}
