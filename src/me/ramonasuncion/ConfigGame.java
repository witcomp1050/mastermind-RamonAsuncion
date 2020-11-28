package me.ramonasuncion;

import java.io.File;

import org.apache.commons.configuration2.PropertiesConfiguration;

public class ConfigGame
{

    public ConfigGame(String propertiesFileName)
    {
        configFile = new File(getClass().getResource(propertiesFileName).getFile());

    }


    //<editor-fold desc="get config vars">
    public boolean isDuplicationsAreAllowed() { return duplicationsAreAllowed; }

    public boolean isBlanksAreAllowed() { return blanksAreAllowed; }

    public int getCodeLength() { return codeLength; }

    public int getNumberOfRows() { return numberOfRows; }
    //</editor-fold>
    

    private boolean duplicationsAreAllowed;
    private boolean blanksAreAllowed;
    private int codeLength;
    private int numberOfRows;
    private PropertiesConfiguration config;
    private File configFile;
}
