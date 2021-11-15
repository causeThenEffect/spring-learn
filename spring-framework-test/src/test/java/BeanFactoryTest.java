import com.szp.spring.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {

  @Test
  public void test() {
    XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("bean-test.xml"));
    User user = (User) xmlBeanFactory.getBean("user");
    Assert.assertEquals("cause", user.getName());
  }

}
