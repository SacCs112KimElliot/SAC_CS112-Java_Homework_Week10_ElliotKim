/*
 * SAC_CS112-Java_Homework_Week10_ElliotKim
 * Objective:   	Extend the Dice class
 *			Keep track number of throws
 *			Keep track of history 
 *			Provide appropriate methods
 *		Rewrite Dice game to keep track of history in object.
https://github.com/SacCs112KimElliot/SAC_CS112-Java_Homework_Week10_ElliotKim/invitations
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class DiceGame {

    public static void main(String[] args) 
    {
         // Introduce the game to user
        JOptionPane.showMessageDialog( null, "Let's play Guess-A-Dice game");
                    
        // Making arrays to store values
        //      [0]First array is to count total number of games user played
        //      [1]Second array is to store whether the random number generated is odd number
        //      [2]Third array is to count total number of user's odd guess
        //      [3]Fourth array is to count total number of user's good guess
        //      [4]Fifth array is to store user's decision on playing the game again or not
        int [] ArraysToHoldValues = new int [6];
            // Store number of game played
            ArraysToHoldValues[0] = 0;
            // Store remainer of user's guess
            ArraysToHoldValues[1] = 0;
            // Store number of odd guess
            ArraysToHoldValues[2] = 0;
            // Store how many right guess user made
            ArraysToHoldValues[3] = 0;
            // Store whether user wants to play the game again (1 = yes)
            ArraysToHoldValues[4] = 1;
            // Store how many dice user wants to throw (among 1,2,3)
            ArraysToHoldValues[5] = 1;
                
        do
        {
            // Prompt user how many dice to be thrown among choices of 1,2,3
            // "Integer.parseInt(String)" will convert string into int
            int HowManyDice =
                Integer.parseInt( JOptionPane.showInputDialog("Why don't we start the game?\n"
                        + "Pick how many dice you want to be thrown between 1 to 3?"));
            ArraysToHoldValues[5] = HowManyDice;
            System.out.println("User decided to throw " + HowManyDice + " dice(s)");
            
            // Instantiate a class "RollingDice()" into an object to a variable "randonNum.." 
            RollingDice randomNumberFromOtherClass = new RollingDice();
            int randomNumber;
            // Method call. Call method "GetANumber()" into a variable "randomNum.."
            // Send required value of HowManyDice to the method
            // Receive value of randomly generated number and assign it to variable randomNumber
            randomNumber = randomNumberFromOtherClass.GetANumber(HowManyDice);
                                 
            // Prompt user to guess whether the dice thrown is odd or even number
            String UserGuessStr =
                    JOptionPane.showInputDialog("Can you guess total points from dice(s) thrown?:");
            // Convert string input to integer
            int UserGuessInt = Integer.parseInt(UserGuessStr); 
            // Display user's guess
            System.out.println("User's guess is " + UserGuessInt);
            
            // Is the random number same as number randomly generated?
            // Let the user know of the result
            if (randomNumber == UserGuessInt)
            {
                JOptionPane.showMessageDialog( null, "Wow! You won it.");
                // count how many right guess the user made
                ArraysToHoldValues[3] = ArraysToHoldValues[3] + 1;
            }
            else
            {
                JOptionPane.showMessageDialog( null, "Sorry. You lost it.");
            }
            // counter total number of games played
            ArraysToHoldValues[0] = ArraysToHoldValues[0] + 1;
            
            int [] GameStatus = {ArraysToHoldValues[0],ArraysToHoldValues[3],ArraysToHoldValues[2]};
            
                     // Get user a game statistic and ask whether wants to play again.
            String PlayAgainStr =
                JOptionPane.showInputDialog("Game Statistic is as follwing:\n"
                        + "Number of games you played is " + ArraysToHoldValues[0]
                        + ".\nRate of right guess is %" + (float)ArraysToHoldValues[3]/ArraysToHoldValues[0]*100
                        + ".\n\nHey, do you want to play it again?\nPress 1 to play again \nor press 2 to quie:");
            ArraysToHoldValues[4] = Integer.parseInt(PlayAgainStr);  
        }
        while (ArraysToHoldValues[4] == 1);
        
        JOptionPane.showMessageDialog( null, "Good Bye");
    
    }
    
}
