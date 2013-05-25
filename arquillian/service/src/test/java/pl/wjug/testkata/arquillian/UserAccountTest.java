package pl.wjug.testkata.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.persistence.ShouldMatchDataSet;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.annotations.Test;
import pl.wjug.testkata.arquillian.model.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.testng.Assert.assertEquals;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-03-25
 */
@Test(groups = {"arquillian"})
public class UserAccountTest extends Arquillian {

  @Deployment
  public static WebArchive createDeployment() {
    return Deployments.createDeployment();
  }

  @PersistenceContext
  private EntityManager em;


}
