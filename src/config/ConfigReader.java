package config;

import java.util.*;
import java.io.*;

public class ConfigReader {
	
	private String db_path;
	private String db_user;
	private String db_password;
	
	public ConfigReader(){
		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("config.props"));
			db_path = properties.getProperty("db_path");
			db_user = properties.getProperty("db_user");
			db_password = properties.getProperty("db_password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String getDb_path() {
		return db_path;
	}

	public String getDb_user() {
		return db_user;
	}

	public String getDb_password() {
		return db_password;
	}


	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigReader cf = new ConfigReader();
		System.out.println("Path= "+cf.getDb_path());
		System.out.println("User= "+cf.getDb_user());
		System.out.println("Password= "+cf.getDb_password());
	}*/

}
