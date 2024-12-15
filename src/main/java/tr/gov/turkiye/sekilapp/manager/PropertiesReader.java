package tr.gov.turkiye.sekilapp.manager;

import com.fasterxml.jackson.databind.JsonMappingException;


import java.io.*;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;

public class PropertiesReader {

    protected Properties properties = new Properties();

    public PropertiesReader() {


        try {
        InputStream is = new FileInputStream("src/main/resources/application.properties");
        properties.load(is);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
