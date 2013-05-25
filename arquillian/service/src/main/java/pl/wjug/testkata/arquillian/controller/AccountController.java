package pl.wjug.testkata.arquillian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import pl.wjug.testkata.arquillian.model.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-05-24
 */
@Controller
@SessionAttributes
public class AccountController {

  @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
  public String addAccount(@ModelAttribute("account")
                             Account account, BindingResult result) {

    System.out.println("First Name:" + account.getFirstname() +
        "Last Name:" + account.getLastname());

    return "redirect:accounts.html";
  }

  @RequestMapping("/accounts")
  public ModelAndView showAccount() {

    return new ModelAndView("account", "command", new Account());
  }
}
