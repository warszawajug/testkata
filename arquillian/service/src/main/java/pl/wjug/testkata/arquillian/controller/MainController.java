package pl.wjug.testkata.arquillian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-05-23
 */
@Controller
public class MainController {

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String printWelcome(ModelMap model) {
    model.addAttribute("message", "HelloFromSpring");
    return "output";
  }
}
