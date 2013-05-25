package org.springframework.samples.petclinic.it;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-05-24
 */
@Test(groups = "arquillian")
public class BasicWebTest extends Arquillian {

  @ArquillianResource
  private static URL url;

  @Drone
  private static FirefoxDriver browser;

  @Deployment
  public static WebArchive createDeployment() {
    String path = BasicWebTest.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "../";
    return ShrinkWrap.create(ZipImporter.class, "petclinic.war")
        .importFrom(new File(path + "petclinic.war")).as(WebArchive.class);
  }



}
