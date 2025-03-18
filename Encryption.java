import java.util.Scanner;                                                               //scanner class to take input

public class Encryption {                                                               //create class
    String key = null;                                                                  //create key variable

    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);                                        //create scanner
        while (scanIn.hasNextLine()) {                                                  //loops as long there is an input given
            String userInput = scanIn.nextLine();                                       //take in input
            if (!userInput.isEmpty() && userInput.matches("^[a-zA-Z\\s]*$")) {          //if input is valid and only letter/spaces
                userInput.toUpperCase();                                                //turn to uppercase
                completeInput(userInput);                                               //complete line given
            } else {                                                                    //invalid input
                System.out.println("Invalid input line");                               //error message
            }
        }
        System.out.println("All inputs completed.");                                    //completed all inputs
        scanIn.close();                                                                 //close scanner
    }

    public static void completeInput(String userInput) {                                //function to deal with valid input line
        String[] wordsArr = userInput.split(" ", 2);                                    //split command ([0]) and argument ([1])
        switch (wordsArr[0]) {                                                          //switch statement to match and deal with command
            case "PASSKEY":                                                             //sets passkey with argument
                key = wordsArr[1];                                                      //set passkey
                System.out.println("RESULT");                                           //print sucess statement
                break;
            case "ENCRYPT":                                                             //encrypts
                if (key == null) {                                                      //checks if key exists
                    System.out.println("ERROR Password not set");                       //error message for no key
                    break;
                }
                System.out.println("RESULT " + applyCipher(wordsArr[1], true));         //success --> print message and new word
                break;
            case "DECRYPT":                                                             //decrypts
                if (key == null) {                                                      //checks if key exists
                    System.out.println("ERROR Password not set");                       //error message for no key
                    return;
                }
                System.out.println("RESULT " + applyCipher(wordsArr[1], false));        //success --> print message and decrypted
                break;
            case "QUIT":                                                                //quit
                System.exit();                                                          //end program
                break;
            default:                                                                    //wrong command
                System.out.println("ERROR " + wordsArr[1]);                             //print error and remaining line
        }
    }

    public static String applyCipher(String input, boolean cipherDirection) {           //applies cipher to input word while direction determines (en = true/de = false)crypt
        String outcome = "";                                                            //creates result string
        char inEach = '';                                                               //creates char variable to travel by each letter
        input = input.replaceAll("[^A-Z]", "");                                         //remove spaces
        for (int i = 0, j = 0; i != input.length(); i++) {                              //loop until each letter of argument is decrypted
            inEach = input.charAt(i);                                                   //get current input letter
            if (cipherDirection) {                                                      //if true = encrypt
                outcome += (char)((inEach + key.charAt(j) - 2 * 'A') % 26 + 'A');       //encrypt letter by calculating and applying Caesar shift --> append encrypted letter to outcome
            }
            else {                                                                      //if false = decrypt
                outcome += (char)((inEach - key.charAt(j) + 26) % 26 + 'A');            //decrypt letter by calculating and reverse applying Caesar shift --> append decrypted letter to outcome
            }
            j = ++j % key.length();                                                     //move to next for key
        }
        return outcome;                                                                 //return final outcome
    }
}

