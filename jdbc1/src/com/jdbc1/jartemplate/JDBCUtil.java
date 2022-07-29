package com.jdbc1.jartemplate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil implements JdbcConfiguration{
private static Connection con;
private static Properties prop;

static {
	try {
		prop = readFile(FILENAME);
		Class.forName(prop.getProperty(DRIVER));
		con=DriverManager.getConnection(prop.getProperty(URL),prop.getProperty(USERNAME),prop.getProperty(PASSWORD));
		
	} catch (ClassNotFoundException |SQLException e) {
		e.printStackTrace();
	} 
}

public static Connection getConnection() {
	return con;
}

private static Properties readFile(String FileName) {
	FileInputStream fis=null;
	Properties prop=null;
	try {
		fis=new FileInputStream(FileName);
		prop=new Properties();
		prop.load(fis);
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}finally {
		try {
			if(fis!=null)
				fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return prop;
}
}
