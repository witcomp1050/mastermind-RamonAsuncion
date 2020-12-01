package me.ramonasuncion;



import java.io.File;

public class Manager {



    private static Configuration gameConfig = null;
    static Configuration getConfig() { return gameConfig; }


    public Manager(CodeMaker codeMaker, CodeBreaker codeBreaker, Configuration config){
        new CodeMaker();
        new Configuration("mmind.properties");
        new CodeBreaker();
        new AboutControl();
    }
}
