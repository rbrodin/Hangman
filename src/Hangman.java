// Hangman class is used to run the game, specifically taking user guesses and validating them, as well as checking the game state.
public class Hangman {

    // String name will be used to store the name of the movie.
    public String name;

    // Initializes the Hangman class, and takes the movie name and the USER class.
    Hangman(String movieName, User user){

        int i;
        this.name = movieName;

        // Substitutes spaces in the hiddenName variable. (Will make it so the hiddenName and guess variable can be compared)
        for(i=0;i<movieName.length();i++){
            // If the name at index i is a space, substitute that space into the hiddenName variable (see User)
            if(movieName.charAt(i) ==  ' '){
                user.substituteCharacterInArray(i, ' ');

            }

        }
        System.out.println("Hangman Object Created!");
        System.out.println(" ");
    }

    // method guessChar takes User object as argument.
    // guessChar will check if the user's guess is in the movieName, if so, that character is substituted into the hiddenName as plaintext.
    void guessChar(User user) {

        // boolean charInName used to differentiate between if the character is in the name or not.
        boolean charInName = false;

        // lowerCaseName and upperCaseName are both used to compare to the user guess.
        String lowerCaseName = name.toLowerCase();
        String upperCaseName = name.toUpperCase();

        // Inefficient usage of i...
        int i;

        // For loop will loop through at index i up to the length of name.
        for (i = 0; i < name.length(); i++) {
            // Times is reset at the start of every loop. Times will be used to make sure letters are not counted twice.

            // Checks if name at index i is equal to the user guess, regardless of lower or upper case.
            if ((lowerCaseName.charAt(i) == user.getChar()) || (upperCaseName.charAt(i) == user.getChar())) {

                // If so, that character is substituted into the array using the substituteCharacterInArray method.
                user.substituteCharacterInArray(i, name.charAt(i));

                // Finally, the new hiddenName is printed with the new, correct, character.
                user.printHiddenNameAndGuesses();

                // charInName is set to true.
                charInName = true;
            }
            }

        // If none of the characters match, then the user's guess is incorrect.
        if (charInName == false) {
            // A point is removed, using the addWrongGuess method, and the wrong guess is added to the wrongGuesses array (used to display wrong guesses to help the user)
            user.addWrongGuess(user.getChar());
            user.subtractPoint();

            user.printHiddenNameAndGuesses();
        }
    }

    // boolean method checkActiveGame takes argument object User.
    // The method will return false if the game is over (whether or not the number of points is zero or the user guessed correctly)
    boolean checkActiveGame(User user){

        int i;
        // If the user.points variable is equal to 0, the game is over.
        // returns false.
        if(user.points == 0){
            System.out.println("You have no points! Game Over!");
            return false;
        }
        // Will check to see if the hiddenName(user guesse's) is equal to the complete movie name. If so, the game is won.
        // Issue here was I originally used == instead of .equals() for an object. Remember, use it for objects!
        if(name.equals(user.getHiddenName())){
            System.out.println("You win! You guessed everything correctly!");
            return false;
        }
        // If both of the conditions are false, the game will keep running until one of the conditions is met.
        return true;
    }
}
