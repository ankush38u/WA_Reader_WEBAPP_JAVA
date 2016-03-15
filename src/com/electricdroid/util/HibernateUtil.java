package com.electricdroid.util;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.electricdroid.classpath.ClassPath;

public class HibernateUtil {

	private static SessionFactory sessionFactoryWA;
	private static SessionFactory sessionFactoryMSG;
    private static final String PATH = "/db";

	public static SessionFactory getWASF(String username) { // get Whatsapp
															// Contacts db
															// Session Factory

		try {
			Configuration configuration = new Configuration().configure(); // configuration
			// settings
			// from
			// hibernate.cfg.xml
			
			
			//making a directory for db 
			 File f =null;
			   try {
			    	
				  f=new File(PATH);
			    	if(!f.exists()){
			    		f.setWritable(true);
			    		f.setReadable(true);
			    		f.mkdirs();
			    	}
			   }
			    	catch(Exception e){
			    		e.printStackTrace();
			    	}
			
			
			System.out.println(f.getPath());
			String url = "jdbc:sqlite:"+f.getPath() +File.separator  + "wa-" + username + ".db";
			System.out.print(url);

			configuration.setProperty("hibernate.connection.url", url);
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

			serviceRegistryBuilder.applySettings(configuration.getProperties());

			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

			sessionFactoryWA = configuration.buildSessionFactory(serviceRegistry);

			return sessionFactoryWA;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static SessionFactory getMsgstoreSF(String username) { // get
																	// whatsapp
																	// msgstore
																	// db of
																	// current
																	// user

		try {

			Configuration configuration = new Configuration().configure(); // configuration
			// settings
			// from
			// hibernate.cfg.xml
			
			
			
			
			//making a directory for db 
			 File f =null;
			   try {
			    	
				  f=new File(PATH);
			    	if(!f.exists()){
			    		f.setWritable(true);
			    		f.setReadable(true);
			    		f.mkdirs();
			    	}
			   }
			    	catch(Exception e){
			    		e.printStackTrace();
			    	}
			
			
			System.out.println(f.getPath());
			
			
			
			
			String url = "jdbc:sqlite:"+f.getPath() +File.separator   + "msgstore-" + username + ".db";
			System.out.print(url);

			configuration.setProperty("hibernate.connection.url",url);
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

			serviceRegistryBuilder.applySettings(configuration.getProperties());

			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

			sessionFactoryMSG = configuration.buildSessionFactory(serviceRegistry);
			return sessionFactoryMSG;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static SessionFactory getSessionFactoryWA() {
		return sessionFactoryWA;
	}
	public static SessionFactory getSessionFactoryMSG() {
		return sessionFactoryMSG;
	}

	public static void shutdownWA() {
		if (getSessionFactoryWA() != null) {
			getSessionFactoryWA().close();
		}
	}
	public static void shutdownMSG() {
		if (getSessionFactoryMSG() != null) {
			getSessionFactoryMSG().close();
		}
	}
}
