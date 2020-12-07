package me.ramonasuncion;

import java.util.Random;


public class CodeMaker
{
    // Gives feedback with black and white pegs.
    public int[] scoreGuess(int[] currentGuess, int[] randomCode)
    {
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
                _randomCode[i] = -1;
                _currentGuess[i] = -1;
                countBlackPegs++;
            }
        }

        for (int i = 0; i < randomCode.length; i++)
        {
            if (_randomCode[i] == -1){ continue; } // Don't count first peg being black.

            // White Beg Counter
            for (int y = 0; y < randomCode.length; y++)
            {
                if (_currentGuess[y] == -1) { continue; }

                if (_randomCode[i] == _currentGuess[y])
                {
                    _currentGuess[y] = -1;
                    _randomCode[i] = -1;
                    countWhitePegs++;
                }
            }
        }

        // Element 0 is black pegs, Element 1 is white pegs
        gussedPegs[0] = countBlackPegs;
        gussedPegs[1] = countWhitePegs;

        // Debug
        // System.out.print("The number of pegs" + Arrays.toString(gussedPegs) + " ");

        return gussedPegs;
    }

    // Convert the code into integers
    public int[] covertToIntegers(String randomCode)
    {
        char[] characters = randomCode.toCharArray();
        int[] value = new int[4];

        for (int x = 0; x < randomCode.length(); x++)
        {
            switch (characters[x]) {
                case 'B':
                    value[x] = 1;
                    break;
                case 'G':
                    value[x] = 2;
                    break;
                case 'O':
                    value[x] = 3;
                    break;
                case 'P':
                    value[x] = 4;
                    break;
                case 'R':
                    value[x] = 5;
                    break;
                case 'Y':
                    value[x] = 6;
                    break;
                case ' ':
                    value[x] = 7;
                    break;
            }
        }
        return value;
    }

    // Generates a random Code
    public String makeRandomCode()
    {
        StringBuilder randomCode = new StringBuilder();
        int elementOfArray = 0;

        Random generator = new Random();
        for (int i = 0; i < _codeLegth; i++) {
            elementOfArray = generator.nextInt(colors.length);
            randomCode.append(colors[elementOfArray]);
        }

        System.out.println("Solution: " + randomCode.toString());
        return randomCode.toString();
    }

    public CodeMaker(){
        _codeLegth = Integer.parseInt(config.getKeyValue("codeSize"));
        _dupsAllowedInCode = Boolean.parseBoolean(config.getKeyValue("dupsAllowedInCode"));
        _blanksAllowedInCode = Boolean.parseBoolean(config.getKeyValue("blanksAllowedInCode"));
    }



    // Blue, Green, Orange, Purple, Red, Yellow
    public final String[] colors = new String[]{"B", "G", "O", "P", "R", "Y"};
    Configuration config = new Configuration();

    int _codeLegth;
    boolean _dupsAllowedInCode;
    boolean _blanksAllowedInCode;
}


