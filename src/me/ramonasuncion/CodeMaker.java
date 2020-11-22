package me.ramonasuncion;

import java.util.Random;

public class CodeMaker {

    /**
     * Generates a random code (Blue, Green, Orange, Purple, Red, Yellow)
     * @return the generated code
     */
    public String randomColorCombination()
    {
        final String[] colors = {"B", "G", "O", "P", "R", "Y"};

        StringBuilder randomCode = new StringBuilder();
        Random generator = new Random();

        int codeLength = 4; // DEFAULT MAX COLORS MASTERMIND

        for (int i = 0; i < codeLength; i++) {
            int elementOfArray = generator.nextInt(colors.length);
            randomCode.append(colors[elementOfArray]);
        }
        return randomCode.toString();
    }
}
