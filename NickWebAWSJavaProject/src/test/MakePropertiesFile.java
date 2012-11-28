package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MakePropertiesFile {
	
	@org.junit.Test
    public void makeProperties()
    {
    	Properties prop = new Properties();
 
    	try {
    		//set the properties value
    		prop.setProperty("RDSUrl", "jdbc:mysql://nickdbinstance.caqyn82rsye8.ap-northeast-1.rds.amazonaws.com:3306/nickdb");
    		prop.setProperty("RDSuser", "nick");
    		prop.setProperty("RDSpassword", "nickime76");
    		
 
    		//save properties to project root folder
    		prop.store(new FileOutputStream("config.properties"), null);
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
    }
}
