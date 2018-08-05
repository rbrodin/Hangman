// Class User is used to store all the necessary information for the player to run the Hangman game.
public class User {
    // char guess is used to store the character that the user guesses.
    public char guess;

    // int points is used to store the points the user has (defaults at 10)
    public int points;

    // int wrongGuesses is used to store the number of wrong guesses (used mainly to append to the guesses array)
    public int wrongGuesses;

    // character array hiddenName is used to store each individual character of the movie's name. Will be updated with (correct) user guesses.
    public char[] hiddenName;

    // character array guesses is used to store the character's that the user has incorrectly guessed.
    public char[] guesses;

    // Initializes the Class. Takes argument charLength (used to set the size of the array)
    User(int charLength) {

        // points is set (default) to 10.
        points = 10;

        // wrong guesses is set (default) to 0.
        wrongGuesses = 0;

        // Inits array the size of characters in the movieName.
        hiddenName = new char[charLength];

        // Inits array the size of the alphabet to hold the number of guesses.
        guesses = new char[26];

        int i;
        // The for loop is used to add spaces in the hiddenName variable (makes it easier for the user to guess the name of the movie)
        for (i = 0; i < charLength; i++) {
            hiddenName[i] = '_';

        }
        System.out.println("User object created!");
    }

    // getChar() wil return char guess. Is used to get the guess character.
    char getChar() {
        return guess;
    }

    // Replaces the user guess. Used mainly in the MAIN class. when updating guesses.
    void userGuess(char guess) {
        this.guess = guess;
    }

    // Used to subtract a point from int points.
    void subtractPoint() {
        points--;
        System.out.println("You guessed wrong! Total Points: " + points);
    }

    // Used to add a wrong guess to the array.  Takes the wrong guess character as an input.
    void addWrongGuess(char wrongGuess) {

        guesses[wrongGuesses] = wrongGuess;
        wrongGuesses++;
    }

    // Used to substitute underscores in the hiddenName array for characters.
    // Takes the index to be replaced, and the character to substitute that index with.
    void substituteCharacterInArray(int index, char characterToSubstitute) {

        hiddenName[index] = characterToSubstitute;

    }

    // Private method used to get the wrongGuesses.
    // returns a string of the wrong guesses.
    // Used in the printHiddenNameAndGuesses() method exclusively.
    private String getWrongGuesses() {
        int i;
        String guessString = "";
        for (i = 0; i < wrongGuesses; i++) {
            guessString = (guessString + " " + guesses[i]);
        }
        return guessString;
    }

    // Public method used to get the hiddenName (variable used to store the updated hangman board with user's guesses)
    // returns the contents of the hiddenName array as a concatenated array.
    public String getHiddenName() {

        String fullHiddenName = "";
        int i;
        // Goes through hiddenName and adds each index of hiddenName to a string.
        for (i = 0; i < hiddenName.length; i++) {
            fullHiddenName = fullHiddenName + hiddenName[i];
        }
        return fullHiddenName;
    }

    // Used to simply print out the updated hangman board (hiddenName), and the wrong guesses.
    void printHiddenNameAndGuesses() {

        System.out.println(getHiddenName() + " Wrong Guesses: " + getWrongGuesses());

    }
}