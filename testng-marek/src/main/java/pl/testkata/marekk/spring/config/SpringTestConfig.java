package pl.testkata.marekk.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.testkata.marekk.spring.AccountBean;
import pl.testkata.marekk.spring.PersonBean;

/**
 * User: marekkapowicki
 */
@ComponentScan("pl.testkata.marekk")
@Configuration
public class SpringTestConfig {

    @Bean
    public AccountBean account() {
        AccountBean accountBean = new AccountBean();
        accountBean.setBalance(6L);
        accountBean.setNo("321");
        return accountBean;
    }
    @Bean(name = "personBean")
    public PersonBean person() {
        return new PersonBean("marek", "kapowicki");
    }

}
