package me.ramonasuncion;


import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;


import java.io.*;
import java.net.URL;
import java.util.Properties;

public class Configuration {

    Configurations configure = new Configurations();


    // Get the properties file
    public Configuration() {
        try {
            File _configFile = new File(getClass().getResource("mmind.properties").getFile());

            if (!_configFile.exists()) {
                defaults();
            } else {
                _config = configure.properties(_configFile);
            }

        } catch (ConfigurationException cex) {
            cex.printStackTrace();
            System.exit(-1);
        }

    }

    public int getCodeSize()
    {
        int codeSize = 4;

        new Configuration();
        codeSize = _config.getInt("codeSize");

        return codeSize;
    }

    public int getCodePegRows()
    {
        int codePegRows = 10;

        new Configuration();
        codePegRows = _config.getInt("codePegRows");

        return codePegRows;
    }


    public boolean getDuplicationsAllowedInCode()
    {
        boolean dupsAllowedInCode = true;

        new Configuration();
        dupsAllowedInCode = _config.getBoolean("dupsAllowedInCode");

        return dupsAllowedInCode;
    }

    public boolean getBanksAllowedInCode() throws ConfigurationException {
        boolean blanksAllowedInCode = false;

        new Configuration();
        blanksAllowedInCode = _config.getBoolean("blanksAllowedInCode");

        return blanksAllowedInCode;
    }


    // Rewrites the mmind.properties file if not found
    public void defaults() {
        try {
            FileWriter writeMMIND = new FileWriter("mmind.properties");
            writeMMIND.write("# Mastermind Properties File (mmind.properties)\n" +
                    "codeSize = 4\n" +
                    "codePegRows = 10\n" +
                    "dupsAllowedInCode = true\n" +
                    "blanksAllowedInCode = false\n" +
                    "playSounds = true\n" +
                    "maxTime = 0");
            writeMMIND.close();
        } catch (IOException e) {
            System.out.println("Error unoccured in creating default file ");
            e.printStackTrace();
        }
    }

    //   // Member Variable
    private PropertiesConfiguration _config;
}