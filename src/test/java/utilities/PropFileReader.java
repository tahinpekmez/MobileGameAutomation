package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropFileReader {
    private static final String PROPERTIES_FILE = "config.properties";
    private Properties props = null;
    public PropFileReader() {
        loadProperties(PROPERTIES_FILE);
    }
    private void loadProperties(String filename) {
        props = new Properties();
        InputStream instream = null;
        ClassLoader loader = this.getClass().getClassLoader();
        instream = loader.get(filename);
        if (instream == null) {
            System.err.println("Unable to open properties file "+filename);
            return;
        }
        try {
            props.load(instream);
        }
        catch (IOException e) {
            System.err.println("Error reading properties file "+filename);
            System.err.println(e.getMessage());
        }
        try {
            instream.close();
        } catch (IOException ioe) { /* should not happen */ }
    }
    public String getProperty(String name) {
        return props.getProperty(name);
    }
}