package pl.wjug.testkata.arquillian;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import java.io.File;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-05-25
 */
public class Deployments {

  public static WebArchive createDeployment() {
    String path = Deployments.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "../";
    return ShrinkWrap.create(ZipImporter.class, "arquillianKata.war")
        .importFrom(new File(path + "arquillianKata.war")).as(WebArchive.class);
  }
}
