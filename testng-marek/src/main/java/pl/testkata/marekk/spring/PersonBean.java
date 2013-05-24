package pl.testkata.marekk.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: marekkapowicki
 */

@Component
public class PersonBean {
    private String firstName;

    private String lastName;

    public PersonBean() {}

    public PersonBean(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
