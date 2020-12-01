package me.ramonasuncion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.builder.fluent.Configurations;


public class Configuration
{
    // Member variables
    private boolean duplicationsAreAllowed;
    private boolean blanksAreAllowed;
    private int codeLength;
    private int numberOfRows;
    private PropertiesConfiguration config;
    private File configFile;

    // Get the properties file
    public Configuration(String propertiesFileName)
    {
        //<editor-fold desc="...">
        try {
            configFile = new File(getClass().getResource(propertiesFileName).getFile());
            Configurations configurations = new Configurations();

            if (!configFile.exists() && configFile.isDirectory())
            {
                defaults();
            }
            else {
                config = configurations.properties(configFile);
            }
        } catch(ConfigurationException cex)
        {
            System.out.println(cex.getMessage());
            System.exit(1);
        }
        //</editor-fold>
    }

    // Rewrites the mmind.properties file if not found
    public void defaults()
    {
        //<editor-fold desc="...">
        try
        {
            FileWriter writeMMIND = new FileWriter("assets/mmind.properties");
            writeMMIND.write("# Mastermind Properties File (mmind.properties)\n" +
                    "codeSize = 4\n" +
                    "codePegRows = 10\n" +
                    "dupsAllowedInCode = true\n" +
                    "blanksAllowedInCode = false\n" +
                    "playSounds = true\n" +
                    "maxTime = 0");
            writeMMIND.close();
        }
        catch (IOException e)
        {
            System.out.println("Error unoccured in creating default file ");
            e.printStackTrace();
        }
        //</editor-fold>
    }

    // (Encapsulation) Methods to get the variable value of private class variables.
    public boolean isDuplicationsAreAllowed() { return duplicationsAreAllowed; }
    public boolean isBlanksAreAllowed() { return blanksAreAllowed; }
    public int getCodeLength() { return codeLength; }
    public int getNumberOfRows() { return numberOfRows; }
}
