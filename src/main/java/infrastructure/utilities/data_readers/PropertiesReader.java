package infrastructure.utilities.data_readers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public abstract class PropertiesReader {

    protected static Properties properties;

    public PropertiesReader(String filePath) {
        try {
            properties = new Properties();
            InputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);

        }catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

}
