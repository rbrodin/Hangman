import java.io.File;
import java.util.Scanner;

// Created by Robert B - August 2018
// The game is designed to take a list of movies (movies.txt), and play hangman with a random movie name.
// The program is designed to work with any list of movies, and is seemingly reusable.
// Enjoy :)
public class Main {

    public static void main (String args[]) throws Exception{

        // Program needs to select a random movie from text file.
        // Then show how many letters it is made up of. -> with underscores!
        // The user then guesses a letter.
        // If that letter is in the movie, it shows the letter
        // Every time a user makes a wrong guess, they lose a point. 10 points and they lose the game.


        // First creating a new file object -> path is movies.txt
        File movie = new File("movies.txt");

        // Scanner object is created to read through the files.
        Scanner fileScanner = new Scanner(movie);

        // Creates an array for the list of movies.
        String [] moviesList;
        moviesList = new String[20];
        // It would be more efficient to just loop though the list and stop at a random number.

        // totalMovies will be used to store the count of the number of movies.
        int totalMovies = 0;

        // Going to have to sacrifice some efficiency...
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            moviesList[totalMovies] = line;
            totalMovies++;
        }

        // Will get a random index between 0 and the value of totalMovies.
        double randomInt = Math.random();
        int random = (int) (randomInt * totalMovies);

        // movieName will randomly select a movie from the movies.txt file.
        String movieName = moviesList[random];

        // User object takes arguments movieNameLength, and is used to add guesses and keep track of user data.
        User user = new User(movieName.length());

        // Hangman object takes arguments name, and User object, user.
        // Hangman will run the game and check the game state.
        Hangman myHangmanGame = new Hangman(movieName, user);

        // Scanner object will take user inputs.
        Scanner userScanner = new Scanner(System.in);

        // Used to print out the hidden name of the movie at the start of the game.
        user.printHiddenNameAndGuesses();

        // If myHangmanGame.checkActiveGame(user) is false, the game keeps running
        // True in this case means WIN OR LOSE
        // The while loop will keep accepting user guesses until either the game is won or points are 0.
        while(myHangmanGame.checkActiveGame(user)){
            //System.out.println("While loop running!");
            int i;

            // String userGuess used to store the user input from the Scanner object.
            String userGuess = userScanner.nextLine();

            // The for loop is used to loop through the userGuess, mainly because the user could guess multiple characters (eg, the entire movie name)
            for(i=0;i<=userGuess.length() - 1;i++){
                System.out.println();

                // Sort of a hack because the Scanner object doesn't have a nextChar() function. So just taking index 0 of the line.
                char userGuessChar = userGuess.charAt(i);

                // Uses the userGuess method, which changes the guess variable in the USER class.
                user.userGuess(userGuessChar);

                // The Hangman object uses the user object to see if the guess is correct. See under the HANGMAN class.
                myHangmanGame.guessChar(user);

            }
        }
    }

}
