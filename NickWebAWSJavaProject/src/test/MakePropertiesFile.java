package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;

public class MakePropertiesFile {
	
	@org.junit.Test
    public void makeProperties()
    {
    	Properties prop = new Properties();
 
    	try {
    		//set the properties value
    		String RDSUrl = "jdbc:mysql://nickdbinstance.caqyn82rsye8.ap-northeast-1.rds.amazonaws.com:3306/nickdb";
    		byte[] encoded = Base64.encodeBase64(RDSUrl.getBytes());
    		RDSUrl = new String(encoded);
    		String RDSuser = "nick";
    		encoded = Base64.encodeBase64(RDSuser.getBytes());
    		RDSuser = new String(encoded);
    		String RDSpassword = "nickime76";
    		encoded = Base64.encodeBase64(RDSpassword.getBytes());
    		RDSpassword = new String(encoded);
    		prop.setProperty("RDSUrl", RDSUrl);
    		prop.setProperty("RDSuser", RDSuser);
    		prop.setProperty("RDSpassword", RDSpassword);
    		
 
    		//save properties to project root folder
    		prop.store(new FileOutputStream("DB.properties"), null);
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
    }
	
    public void base64Sample() throws IOException {
        String orig = "original String before base64 encoding in Java";

        //encoding  byte array into base 64
        byte[] encoded = Base64.encodeBase64(orig.getBytes());     
      
        System.out.println("Original String: " + orig );
        System.out.println("Base64 Encoded String : " + new String(encoded));
      
        //decoding byte array into base64
        byte[] decoded = Base64.decodeBase64(encoded);      
        System.out.println("Base 64 Decoded  String : " + new String(decoded));

    }
}
