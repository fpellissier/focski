package org.franck.focski.modele;

import org.apache.log4j.Logger;


public class User {

    private static final Logger logger = Logger.getLogger(User.class);
	
	private String login;
	private String passwd;
	private String role;
	private boolean accessEnabled;

	public User (){
		super();
		logger.debug("User Constructor (super())");
	}
	
	public User(String login, String passwd, String role, boolean accessEnabled) {
		super();
		this.login = login;
		this.passwd = passwd;
		this.role = role;
		this.accessEnabled = accessEnabled;
		logger.debug("User Constructor (specific)");
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public boolean isAccessEnabled() {
		return accessEnabled;
	}
	public void setAccessEnabled(boolean accessEnabled) {
		this.accessEnabled = accessEnabled;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}
}
