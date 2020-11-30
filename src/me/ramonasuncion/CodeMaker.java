package me.ramonasuncion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CodeMaker
{
    public String makeRandomCode()
    {
        int codeLength = 4; // DEFAULT MAX COLORS MASTERMIND

        StringBuilder randomCode = new StringBuilder();
        Random generator = new Random();
        for (int i = 0; i < codeLength; i++)
        {
            int elementOfArray = generator.nextInt(colors.length);
            randomCode.append(colors[elementOfArray]);
        }

        // Debug
        System.out.println("Solution: " + randomCode.toString());

        return randomCode.toString();
    }

    public int[] scoreGuess(int[] currentGuess, int[] randomCode)
    {

        int[] _randomCode = new int[4], _currentGuess = new int[4];
        int countBlackPegs = 0, countWhitePegs = 0;
        int[] result = new int[2];


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
                _randomCode[i]=-1;
                _currentGuess[i]=-1;
            }
        }

        // Test case countinue
        for (int i = 0; i < randomCode.length; i++)
        {
            if (_randomCode[i] == -1) {
                continue;
            }

            // White Beg Counter
            for (int j=0;j < randomCode.length; j++)
            {
                if (_currentGuess[j] == -1)
                {
                    continue;
                }

                if (_randomCode[i] == _currentGuess[j])
                {
                    countWhitePegs++;
                    _randomCode[i]=-1;
                    _currentGuess[j]=-1;
                }
            }
        }

        result[0] = countBlackPegs;
        result[1] = countWhitePegs;

        // Debug
        System.out.print("The number of pegs" + Arrays.toString(result));

        return result;
    }

    public void getSolution(){}







    // Convert the code into integers (easier to handle ints)
    public int[] codeConverstionToIntegers(String randomCode){
        int[] codeIntegers = new int[4];
        char[] characters = randomCode.toCharArray();

        for (int x = 0; x < randomCode.length(); x++)
        {
            switch (characters[x]) {
                case 'B':
                    codeIntegers[x] = 0; break;
                case 'G':
                    codeIntegers[x] = 1; break;
                case 'O':
                    codeIntegers[x] = 2; break;
                case 'P':
                    codeIntegers[x] = 3; break;
                case 'R':
                    codeIntegers[x] = 4; break;
                case 'Y':
                    codeIntegers[x] = 5; break;
            }
        }

        // Debug
        System.out.println("Code in ints " + Arrays.toString(codeIntegers));

        return codeIntegers;
    }

    public final String[] colors = new String[]{"B", "G", "O", "P", "R", "Y"};
}


