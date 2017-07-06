import java.util.Scanner;

/**
 * Created by jenny on 7/3/2017.
 */

//Calculate the batting average and slugging percentage for one or more baseball/softball players
public class BattingStatistics {

    private static Validator Validator = new Validator();

    public static void main(String[] args) {

        Scanner entry = new Scanner(System.in);

        System.out.println("Welcome to Batting Average Calculator!");

        String keepGoing = "y";

        while (keepGoing.equalsIgnoreCase("y")) {

            //Get the number of batters
            int numBatters = getNumBatters(entry);

            int[] baseEarned = new int[numBatters];
            int[] numBasesEarned = new int[numBatters];
            int[] numAtBats = new int[numBatters];

            int[][] battingResults = new int[numBatters][];

            double[] battingAverage = new double[numBatters];
            double[] sluggingPercentage = new double[numBatters];

            //Get the batter results - batting averages and slugging percentages
            getBatterResults(entry, numBatters, baseEarned, numBasesEarned, numAtBats, battingResults, battingAverage, sluggingPercentage);
            entry.nextLine();

            System.out.println();

            //Output batter results
            for (int k = 0; k < battingResults.length; k++) {
                System.out.printf("Batter %d average: %.3f   slugging percentage: %.3f\n", k + 1, battingAverage[k], sluggingPercentage[k]); //output batting average
            }

            System.out.println();

            String anotherBatterPrompt = "Would you like to calculate more? (y/n): ";
            String invalidAnotherBatterPrompt = "\nInvalid entry. Please specify y or n.";
            keepGoing = Validator.getString(entry, anotherBatterPrompt, invalidAnotherBatterPrompt);
        }
        System.out.println("\nGood-bye");
    }

    private static void getBatterResults(Scanner entry, int numBatters, int[] baseEarned, int[] numBasesEarned, int[] numAtBats, int[][] battingResults, double[] battingAverage, double[] sluggingPercentage) {
        for (int i = 0; i < numBatters; i++) {
            String numberAtBatsPrompt = String.format("\nEnter number of times batter %d is at bat: ", i + 1);
            String invalidAtBatsPrompt = "\nInvalid entry. Please enter 1 or more at-bats.";
            numAtBats[i] = Validator.getInt(entry, numberAtBatsPrompt, invalidAtBatsPrompt, 1, Integer.MAX_VALUE);

            battingResults[i] = new int[numAtBats[i]];

            System.out.println("\n0=out, 1=single, 2=double, 3=triple, 4=home run");

            //Get at bat results
            getAtBatResults(entry, baseEarned, numBasesEarned, numAtBats[i], battingResults, i);

            //Batting average: number of at bats with 1 or more bases earned / number of at bats
            battingAverage[i] = (double) baseEarned[i] / numAtBats[i];

            //Slugging percentage: number of bases earned / number of at bats
            sluggingPercentage[i] = (double) numBasesEarned[i] / numAtBats[i];
        }
    }

    private static void getAtBatResults(Scanner entry, int[] baseEarned, int[] numBasesEarned, int numAtBat, int[][] battingResults, int i) {
        for (int j = 0; j < numAtBat; j++) {
            String resultAtBatPrompt = String.format("Result for batter %d at-bat %d: ", i + 1, j + 1); //Receive bases
            String invalidResultAtBatPrompt = "\nInvalid entry. Please enter 0, 1, 2, 3, or 4 bases.\n";
            battingResults[i][j] = Validator.getInt(entry, resultAtBatPrompt, invalidResultAtBatPrompt, 0, 4);

            //Add at bat to total if 1 or more bases earned
            if (battingResults[i][j] >= 1) {
                baseEarned[i]++;
            }

            //Add number of bases earned
            numBasesEarned[i] += battingResults[i][j];
        }
    }

    private static int getNumBatters(Scanner entry) {
        // Get Number of Batters
        String numberBattersPrompt = "\nEnter the number of batters: ";
        String invalidNumberBattersPrompt = "\nInvalid entry. Please enter 1 or more batters.";
        return Validator.getInt(entry, numberBattersPrompt, invalidNumberBattersPrompt, 1, Integer.MAX_VALUE);
    }
}