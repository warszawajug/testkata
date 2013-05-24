package pl.testkata.marekk.service;

import org.apache.commons.lang.StringUtils;

/**
 * used to say hello to new user
 */
public class GreetingsService {
	private final String firstName;
	
	public GreetingsService(String firstName) {
		this.firstName = firstName;
	}
	public String sendHello() throws Exception {
		if (StringUtils.isEmpty(firstName)) {
			throw new IllegalArgumentException("name is empty!!!");
		}
	    return 	getPrefix()+" "+firstName;
	} 
	protected static String getPrefix() {
		return "hello";
	}
}
