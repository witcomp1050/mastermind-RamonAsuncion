package me.ramonasuncion;

import java.io.File;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.builder.fluent.Configurations;


public class ConfigGame
{
    // Get the properties file
    public ConfigGame(String propertiesFileName)
    {
        try {
            configFile = new File(getClass().getResource(propertiesFileName).getFile());
            if (!configFile.exists() && configFile.isDirectory())
            {
                return;
            }
            else {
                var configuration = new Configurations();
                config = configuration.properties(configFile);
            }
        } catch(ConfigurationException cex) {
            System.out.println(cex.getMessage());
            System.exit(1);
        }
    }

    // (Encapsulation) Methods to get the variable value of private class variables.
    public boolean isDuplicationsAreAllowed() { return duplicationsAreAllowed; }

    public boolean isBlanksAreAllowed() { return blanksAreAllowed; }

    public int getCodeLength() { return codeLength; }

    public int getNumberOfRows() { return numberOfRows; }


    // Member variables
    private boolean duplicationsAreAllowed;
    private boolean blanksAreAllowed;
    private int codeLength;
    private int numberOfRows;
    private PropertiesConfiguration config;
    private File configFile;
}
