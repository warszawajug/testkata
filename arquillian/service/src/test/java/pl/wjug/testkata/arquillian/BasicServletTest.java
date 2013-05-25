package pl.wjug.testkata.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertTrue;

//import org.jboss.arquillian.warp.WarpTest;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-03-24
 */
@Test(groups = "arquillian")
//@WarpTest // have to be added while arquillian-warp-impl dependency is present
public class BasicServletTest extends Arquillian {

  @ArquillianResource
  private static URL url;

  @Drone
  private static FirefoxDriver browser;

  @Deployment
  public static WebArchive createDeployment() {
    return Deployments.createDeployment();
  }

  @RunAsClient
  public void shouldReturnMainElement() {
    System.out.println("Starting under url: " + url);
    browser.get(url + "hello");
    System.out.println("Page source: " + browser.getPageSource());
    assertTrue(isElementPresent(By.xpath("//p[contains(text(), 'HelloFromSpring')]")));
  }

  private boolean isElementPresent(By by) {
    try {
      browser.findElement(by);
      return true;
    } catch (NoSuchElementException ignore) {
      return false;
    }
  }
}
