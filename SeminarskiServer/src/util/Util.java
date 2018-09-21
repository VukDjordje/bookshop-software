/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Djordje Vukicevic
 */
public class Util {
    private Properties props;

    public Util() throws RuntimeException {
        try {
            loadProperties();
        } catch (IOException ex) {
            throw new RuntimeException("settings.properties nije ucitan!\n"+ex);
        }
    }
    
    private void loadProperties() throws FileNotFoundException, IOException{
        props = new Properties();
        FileInputStream fis = new FileInputStream("settings.properties");
        props.load(fis);
    }
    
    public String getValue(String key){
        return props.getProperty(key, "n/a");
    }
}
