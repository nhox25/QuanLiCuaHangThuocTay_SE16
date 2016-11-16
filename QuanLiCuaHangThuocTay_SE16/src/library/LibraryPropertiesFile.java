package library;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

public class LibraryPropertiesFile {
    public static Properties readFileConfig(){
        Properties prop = new Properties();
        File file = new File("config.properties");
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            prop.load(fis);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: Load file config!");
        }
        return prop;
    }
}
