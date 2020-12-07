package me.ramonasuncion;

import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.*;

public class Configuration
{
    //Get the properties file
    public Configuration()
    {
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> _configurationFile = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class).configure(params.properties().setFileName("mmind.properties"));
        try
        {
            _config = _configurationFile.getConfiguration();
        } catch (ConfigurationException e)
        {
            defaults();
        }
    }

    public String getKeyValue(String key)
    {
        return _config.getProperty(key).toString();
    }

    // Rewrites the mmind.properties file if not found (Scuffed way to do it)
    public void defaults()
    {
        try
        {
            FileWriter writeMMIND = new FileWriter("mmind.properties");
            writeMMIND.write("# Mastermind Properties File (mmind.properties)\n" +
                    "codeSize = 4\n" +
                    "codePegRows = 10\n" +
                    "dupsAllowedInCode = true\n" +
                    "blanksAllowedInCode = false\n" +
                    "playSounds = true\n" +
                    "maxTime = 0");
            writeMMIND.close();
        } catch (IOException e)
        {
            System.out.println("Error unoccured in creating default file. Exiting completely");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void saveConfiguration()
    {
        try
        {
            BufferedReader _configurationFile = new BufferedReader(new FileReader("../resources/mmind.properties"));


        } catch (FileNotFoundException e)
        {
            System.out.println("FileNotFound, rewriting the file: defaults being applied");
            defaults();
        }
    }

    // Member Variable
    private FileBasedConfiguration  _config;
}