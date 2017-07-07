import java.util.Scanner;

/**
 * Created by jenny on 7/3/2017.
 */

//Calculate the batting average and slugging percentage for one or more baseball/softball players
public class BattingStatistics {

    //Validate user inputs:
    private static Validator Validator = new Validator();

    public static void main(String[] args) { //METHOD

        //Initialize Scanner
        Scanner entry = new Scanner(System.in);

        //Print welcome to console
        System.out.println("Welcome to Batting Average Calculator!");

        //Initialize variable and loop to repeat batting calculations based on user input
        String keepGoing = "y";
        while (keepGoing.equalsIgnoreCase("y")) {

            //Get number of batters:
            int numBatters = getNumberOfBatters(entry); //METHOD

            //Create arrays to store batting statistics and calculation results
            int[] numAtBats = new int[numBatters];
            int[] ifBaseEarned = new int[numBatters];
            int[] numBasesEarned = new int[numBatters];
            double[] battingAverage = new double[numBatters];
            double[] sluggingPercentage = new double[numBatters];

            //Loop through each batter
            for (int i = 0; i < numBatters; i++) {

                //Get Batter [i]'s number of at bats:
                numAtBats[i] = getNumberofAtBats(entry, i); //METHOD

                //Create array to store batting results
                int[][] battingResults = new int[numBatters][numAtBats[i]];

                //Provide at bat result options
                System.out.println("\n0=out, 1=single, 2=double, 3=triple, 4=home run\n");

                //Loop through Batter [i]'s at bats
                for (int j = 0; j < numAtBats[i]; j++) {

                    //Get at bat result:
                    battingResults[i][j] = getResultAtBat(entry, i, j); //METHOD

                    //Increment if base earned from at bat [j]
                    if (battingResults[i][j] >= 1) {
                        ifBaseEarned[i]++;
                    }
                    //Sum Batter [i]'s bases earned
                    numBasesEarned[i] += battingResults[i][j];
                }

                //Calculate Batter [i]'s batting average and slugging percentage
                battingAverage[i] = (double) ifBaseEarned[i] / numAtBats[i];
                sluggingPercentage[i] = (double) numBasesEarned[i] / numAtBats[i];
            }

            System.out.println();

            //Print Batter [k]'s batting average and slugging percentage
            for (int k = 0; k < numBatters; k++) {
                System.out.printf("Batter %d average: %.3f   slugging percentage: %.3f\n", k + 1, battingAverage[k], sluggingPercentage[k]);
            }

            System.out.println();

            //Get user input "y" or "Y" to continue:
            keepGoing = getMoreBatterStats(entry); //METHOD
        }
        //Print good-bye to console
        System.out.println("\nGood-bye");

        //Close scanner
        entry.close();
    }

    //Get number of batters:
    public static int getNumberOfBatters(Scanner entry){
        String numberBattersPrompt = "\nEnter the number of batters: ";
        String invalidNumberBattersPrompt = "\nInvalid entry. Please enter 1 or more batters.";
        int numBatters = Validator.getInt(entry, numberBattersPrompt, invalidNumberBattersPrompt, 1, Integer.MAX_VALUE);

        return numBatters;
    }

    //Get Batter's number of at bats:
    public static int getNumberofAtBats(Scanner entry, int i) {
        String numberAtBatsPrompt = String.format("\nEnter number of times batter %d is at bat: ", i + 1);
        String invalidAtBatsPrompt = "\nInvalid entry. Please enter 1 or more at-bats.";
        int numAtBats = Validator.getInt(entry, numberAtBatsPrompt, invalidAtBatsPrompt, 1, Integer.MAX_VALUE);

        return numAtBats;
    }

    //Get at bat result:
    public static int getResultAtBat(Scanner entry, int i, int j){
        String resultAtBatPrompt = String.format("Result for batter %d at-bat %d: ", i + 1, j + 1); //Receive bases
        String invalidResultAtBatPrompt = "\nInvalid entry. Please enter 0, 1, 2, 3, or 4 bases.\n";
        int battingResults = Validator.getInt(entry, resultAtBatPrompt, invalidResultAtBatPrompt, 0, 4);

        return battingResults;
    }

    //Get user input "y" or "Y" to continue:
    public static String getMoreBatterStats(Scanner entry) {
        String anotherBatterPrompt = "Would you like to calculate more? (y/n): ";
        String invalidAnotherBatterPrompt = "\nInvalid entry. Please specify y or n.\n";
        String keepGoing = Validator.getString(entry, anotherBatterPrompt, invalidAnotherBatterPrompt);

        return keepGoing;
    }
}