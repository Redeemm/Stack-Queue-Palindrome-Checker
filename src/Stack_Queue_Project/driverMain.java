/* Author:  Zachary Gunning
 * Date:    12.13.19
 * Purpose: Create a palindrome checker that uses stack and queue
 *          capabilities to compare the word given by the user
 */

package Stack_Queue_Project;

import java.util.Scanner;

public class driverMain {

    public static void main(String[] args) {

        final int MAX_NUMBER_CHARACTERS = 50;
        StringBuilder stringAllLetters = new StringBuilder();

        Scanner keyboard = new Scanner(System.in);

        // Greet the user and ask if they want to play!
        System.out.print("Please enter a string to test for a palindrome or type 'quit' to exit: ");
        String userString = keyboard.nextLine();


        // while the user does not want to play the game
        while (!userString.equalsIgnoreCase("quit")) {


            // Test that the user input is less than 100 characters in length
            while (!testCharacterCount(userString, MAX_NUMBER_CHARACTERS)) {
                System.out.println("Please enter a palindrome that is 100 characters or less... ");
                userString = keyboard.nextLine();
            }


            // Append a character to 'stringAllLetters' if it is a letter
            for (int a = 0; a < userString.length(); ++a) {
                if (Character.isLetter(userString.charAt(a))) {
                    stringAllLetters.append(userString.charAt(a));
                }
            }


            // Convert 'stringAllLetters' to capital letters
            String stringAllCapitals = stringAllLetters.toString().toUpperCase();


            // Create stack and queue objects, setting array elements to '\0'
            stack characterStack = new stack(stringAllCapitals.length());
            characterStack.clearArray();
            queue characterQueue = new queue(stringAllCapitals.length());
            characterQueue.clearArray();


            // Push 'stringCapitalLetters' onto the stack and the queue arrays
            for (int z = 0; z < stringAllCapitals.length(); ++z) {
                characterStack.push(stringAllCapitals.charAt(z));
                characterQueue.enqueue(stringAllCapitals.charAt(z));
            }


            // Create an stackExpress[] and collect all letters from the stack array
            char[] stackExpress = new char[stringAllCapitals.length()];
            for (int j = 0; j < stringAllCapitals.length(); ++j)
                stackExpress[j] = characterStack.pop();


            // Create a queueExpress[] and collect all letters from the queue array
            char[] queueExpress = new char[stringAllCapitals.length()];
            for (int i = 0; i < stringAllCapitals.length(); ++i)
                queueExpress[i] = characterQueue.dequeue();


            // Create new strings to test as palindromes
            String stackExpressString = new String(stackExpress);
            String queueExpressString = new String(queueExpress);


            // Send strings to be tested as palindromes to each other
            isPalindrome(stackExpressString, queueExpressString);


            // Set array elements to '\0' and empty appended string
            characterStack.clearArray();
            characterQueue.clearArray();
            stringAllLetters = new StringBuilder();


            // Ask the user if they with to play again; if so, test word length
            System.out.print("\n\nTry another string or type 'quit' to exit: ");
            userString = keyboard.nextLine();

        } // end while loop
    } // end main()


    // Compare stack string with the queue string; determine if they are palindromes to each other
    public static void isPalindrome(String stackString, String queueString) {

        boolean stackTest = testPalindromeQualities(stackString);
        boolean queueTest = testPalindromeQualities(queueString);


        if (stackTest && queueTest)
            System.out.println("The input is a palindrome.");

        else
            System.out.println("The input is not a palindrome.");

    } // end isPalindrome

    // Test that each string has palindrome qualities
    public static boolean testPalindromeQualities(String inputString) {

        boolean validPalindrome = true;

        // Check the word by testing the front and back letters for equality
        int forward = 0;
        int backward = inputString.length() - 1;
        while (backward > forward) {
            char forwardChar = inputString.charAt(forward++);
            char backwardChar = inputString.charAt(backward--);
            if (forwardChar != backwardChar) {
                validPalindrome = false;
                break;
            }
        }
        // String is a palindrome
        return validPalindrome;

    }  // end testPalindromeQualities

    // Verify that the user's character count is less than OR equal to 100 characters
    public static boolean testCharacterCount(String userWord, int maxNumChars) {

        int userWordLength = userWord.length();

        // Returns false if the word has more than 100 characters
        return userWordLength <= maxNumChars;

        // Return the word as is (no adjustments)

    } // end testCharacterCount

} // end driverMain() 



