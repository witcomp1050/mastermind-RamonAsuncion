package me.ramonasuncion;


import java.util.Arrays;
import java.util.Random;


public class CodeMaker
{

    // Generates a random Code
    public String makeRandomCode()
    {
        //<editor-fold desc="...">

        int codeLength = 4; // DEFAULT MAX COLORS MASTERMIND

        StringBuilder randomCode = new StringBuilder();
        Random generator = new Random();
        for (int i = 0; i < codeLength; i++)
        {
            int elementOfArray = generator.nextInt(colors.length);
            randomCode.append(colors[elementOfArray]);
        }

        System.out.println("Solution: " + randomCode.toString());
        return randomCode.toString();
        //</editor-fold>
    }

    // Gives feedback with black and white pegs.
    public int[] scoreGuess(int[] currentGuess, int[] randomCode)
    {
        //<editor-fold desc="...">

        // Variables;
        int[] _randomCode = new int[4], _currentGuess = new int[4];
        int countBlackPegs = 0, countWhitePegs = 0;
        int[] gussedPegs = new int[2];


        for (int i = 0; i < 4; i++)
        {
            _randomCode[i] = randomCode[i];
            _currentGuess[i] = currentGuess[i];
        }

        // Black Peg Counter
        for (int i = 0; i < randomCode.length; i++)
        {
            if (_randomCode[i] == _currentGuess[i])
            {
                countBlackPegs++;
                _randomCode[i] = -1;
                _currentGuess[i] = -1;
            }
        }

        // Test case continue
        for (int i = 0; i < randomCode.length; i++)
        {
            if (_randomCode[i] == -1)
                continue;

            // White Beg Counter
            for (int y = 0; y < randomCode.length; y++)
            {

                if (_currentGuess[y] == -1)
                    continue;

                if (_randomCode[i] == _currentGuess[y])
                {
                    countWhitePegs++;
                    _currentGuess[y] = -1;
                    _randomCode[i] = -1; // From past black counter
                }
            }
        }

        // Element 0 is black pegs, Element 1 is white pegs
        gussedPegs[0] = countBlackPegs;
        gussedPegs[1] = countWhitePegs;

        // Debug
        System.out.print("The number of pegs" + Arrays.toString(gussedPegs) + " ");

        return gussedPegs;
        //</editor-fold>
    }

    // Convert the code into integers (easier to deal with handle ints)
    public int[] covertToIntegers(String randomCode)
    {
        //<editor-fold desc="...">
        int[] codeIntegers = new int[4];

        char[] characters = randomCode.toCharArray();

        for (int x = 0; x < randomCode.length(); x++)
        {
            switch (characters[x]) {
                case 'B':
                    codeIntegers[x] = 0;
                    break;
                case 'G':
                    codeIntegers[x] = 1;
                    break;
                case 'O':
                    codeIntegers[x] = 2;
                    break;
                case 'P':
                    codeIntegers[x] = 3;
                    break;
                case 'R':
                    codeIntegers[x] = 4;
                    break;
                case 'Y':
                    codeIntegers[x] = 5;
                    break;
                case ' ':
                    codeIntegers[x] = 6;
                    break;
            }
        }

        return codeIntegers;
        //</editor-fold>
    }



    // Blue, Green, Orange, Purple, Red, Yellow
    public final String[] colors = new String[]{"B", "G", "O", "P", "R", "Y"};
    public int codeLength;
}
