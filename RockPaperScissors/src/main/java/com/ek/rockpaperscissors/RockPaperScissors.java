package com.ek.rockpaperscissors;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Easmile
 */
public class RockPaperScissors {
    //these variables hold the win,lose, and tie count of each game
    static int winCount;
    static int loseCount;
    static int tieCount;
    
    public static void main(String[] args){
        int playerChoice; //stores the players choice of hand
        int computerChoice; //stores the computers random hand
        String playAgain; //stores players input for if they want another game
        boolean keepPlaying = true; //allows the player to play multiple games
        Scanner sc = new Scanner(System.in);
        
/*
     The following block of code is the main segment of the program. If the keep playing variable is true, the game
     will be played once fully the number of rounds specified by the user. For each round, the user inputs their
     'hand' corresponsding with the the values 1, 2, or 3. The computer then randomly chooses a number within
      this range and calculates the result of the round. After all rounds are played, the final result is printed
      on screen and asks the user if they like to play again. If they choose yes, the code block is ran again. If
      they choose no, the program is terminated.
 */        
        while(keepPlaying){
        //the score count is reset at the beginning of each game
        winCount = 0;
        loseCount = 0;
        tieCount = 0;
        int numRounds = readValue("How many rounds would you like to play?");
        if (numRounds > 10 || numRounds < 1){
            System.out.println("Please enter a number between 1 and 10...");
            System.exit(0); //terminates game if number of rounds isnt between the range
        }
            for(int i = 0; i < numRounds; i++){
                playerChoice = readValue("What hand would you like to choose? Rock is 1, Paper is 2, Scissors is 3");
                computerChoice = 1 + new Random().nextInt(3);
                result(playerChoice,computerChoice);
            }
            
            printResult(winCount,loseCount,tieCount);
            System.out.println("Would you like to play again? Type yes or no.");
            playAgain = sc.nextLine();
            
            if(playAgain.equals("no")){
                keepPlaying = false;
                System.out.println("Thanks for playing!");
                break;
            }
            else{
                keepPlaying = true;
            }
        }
        
        
    }
    
    //this method reads the user input and returns it as a parsed integer
    public static int readValue(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String input = sc.nextLine();
        int intVal = Integer.parseInt(input);
        return intVal;
    }
    
    //this method subtracts the computers random number from the players chosen number.
    //It then decides if the round ends in a win, lose , or draw and updates the count
    public static void result(int player,int computer){
        int subValue = player - computer;
        if(subValue == 0){
            tieCount++;
            System.out.println("You Tied!");
        }
        else if(subValue == 1 || subValue == -2){
            winCount++;
            System.out.println("You Won!");
        }
        else if(subValue == 2 || subValue == -1){
            loseCount++;
            System.out.println("You Lost!");        
        }
        
    }
    
    //this method prints the final result of the game and calculates if the player has won or lost.
    public static void printResult(int wins, int losses, int ties){
        System.out.println("Thanks for playing! You won: " + wins + " rounds, lost: " + losses + " rounds, and tied: " + ties + " rounds.");
        if(wins > losses){
            System.out.println("Congratultions, you won!");
        } else if (losses > wins){
            System.out.println("Sorry, you lost...");
        }else {
            System.out.println("It was a tie!");
        }
        
    }
    
}
