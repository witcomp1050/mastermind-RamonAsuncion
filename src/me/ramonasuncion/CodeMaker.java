package me.ramonasuncion;

import java.util.Random;

public class CodeMaker
{
    public String[] colors = new String[]{"B", "G", "O", "P", "R", "Y"};

    /**
     * Generates a random code (Blue, Green, Orange, Purple, Red, Yellow)
     * @return the generated code
     */
    public String randomColorCombination()
    {

        int codeLength = 4; // DEFAULT MAX COLORS MASTERMIND

        StringBuilder randomCode = new StringBuilder();
        Random generator = new Random();
        for (int i = 0; i < codeLength; i++)
        {
            int elementOfArray = generator.nextInt(colors.length);
            randomCode.append(colors[elementOfArray]);
        }
        return randomCode.toString();
    }
}