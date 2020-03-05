package infrastructure.utilities.data_readers;

public class ConfigPropertiesReader extends PropertiesReader {

    private static String projectPath = System.getProperty("user.dir");
    private static String configFilePath = projectPath + "/src/main/resources/config.properties";
    private final String BROWSER_TYPE_PROPERTY = "browser_type";

    public ConfigPropertiesReader() {
        super(configFilePath);
    }

    public String getBrowserType() {
        return getProperty(BROWSER_TYPE_PROPERTY);
    }
}
