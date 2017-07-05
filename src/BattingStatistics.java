import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jenny on 7/3/2017.
 */

public class BattingStatistics {
    public static void main(String[] args) {

        Scanner entry = new Scanner(System.in);

        System.out.println("Welcome to Batting Average Calculator!");

        //System.out.print("\nEnter the number of batters: ");
        //int numBatters = entry.nextInt();

        System.out.print("\nEnter number of times at bat: ");
        int numAtBats = entry.nextInt();

        int[] resultAtBat = new int[numAtBats];

        System.out.println("\n0=out, 1=single, 2=double, 3=triple, 4=home run");

        int baseEarned = 0;
        int numBasesEarned = 0;
        double battingAverage = 0.0;
        double sluggingAverage = 0.0;

        for (int i = 0; i < resultAtBat.length; i++) {
            System.out.print("Result for at-bat " + i + ": "); //Receive bases
            resultAtBat[i] = entry.nextInt();

            if (resultAtBat[i] >= 1) {
                baseEarned++;
            }
            numBasesEarned += resultAtBat[i];
        }

        battingAverage = (double) baseEarned / numAtBats;
        sluggingAverage = (double) numBasesEarned / numAtBats;

        DecimalFormat formatter = new DecimalFormat("#.000");

        System.out.printf("\nBatting average: " + formatter.format(battingAverage)); //output battingAverage
        System.out.printf("Slugging Percentage: " + formatter.format(sluggingAverage)); //output sluggingAverage
    }
}