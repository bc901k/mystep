package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
	
	@org.junit.Test
    public void ReadProperties()
    {
    	Properties prop = new Properties();
 
    	try {
               //load a properties file
    		prop.load(new FileInputStream("config.properties"));
 
               //get the property value and print it out
                System.out.println(prop.getProperty("RDSdatabase"));
    		System.out.println(prop.getProperty("RDSdbuser"));
    		System.out.println(prop.getProperty("RDSdbpassword"));
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
 
    }
}
