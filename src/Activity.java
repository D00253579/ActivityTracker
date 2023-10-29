import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Activity {
    ArrayList<ActivityDetails> activities = new ArrayList<>();

    //Method to display the data passed in from the CSV
    //Have the headers outputting too
    public void displayData(ArrayList<ActivityDetails> activities){
        System.out.println("\n==============DISPLAY DATA==============\n");
    /*enhanced for loop to cycle through the data in the arraylist and pass it to the object
         'a' to access class methods. */
        for (ActivityDetails a : activities) {
            //                    System.out.println(a.toString());
        /*Displaying the data in a neat matter using printf to include an appropriate amount of
                        white space and to round the doubles down to 1 decimal point*/

            System.out.printf("%10s,%11s,%4d,%5.1f,%7.1f\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getHeartRate());
        }
    }

    //Sorting duration by ascending and descending
    //using lambda expression
    public void displayDurationAsc(ArrayList<ActivityDetails> activities)  {
        Collections.sort(activities,
                (ActivityDetails a1, ActivityDetails a2) ->
                {
                    return a1.getDuration() - a2.getDuration();
                });
        displayData(activities);
    }

    public void displayDurationDesc(ArrayList<ActivityDetails> activities) {
        Collections.sort(activities,
                (ActivityDetails a1, ActivityDetails a2) ->
                {
                    return a2.getDuration() - a1.getDuration();
                });
        displayData(activities);
    }

    //display by natural ordering
    public void displayNaturalOrdering(ArrayList<ActivityDetails> activities) {
        Collections.sort(activities);
        displayData(activities);
    }

    public void displayIntensity(ArrayList<ActivityDetails> activities) {
        for (ActivityDetails a : activities) {
            if (a.getActivityType().equals("Swimming")) {
                System.out.println("Activity: " + a.getActivityType() + " Intensity: " + a.getIntensitySwimming());
            } else if (a.getActivityType().equals("Running")) {
                System.out.println("Activity: " + a.getActivityType() + " Intensity: " + a.getIntensityRunning());
            } else if (a.getActivityType().equals("Cycling")) {
                System.out.println("Activity: " + a.getActivityType() + " Intensity: " + a.getIntensityCycling());
            }
        }
    }

    public void displayCaloriesBurned(ArrayList<ActivityDetails> activities) {

        for (ActivityDetails a : activities) {

            System.out.println("Activity: " + a.getActivityType() + "\n Calories Burned: " + a.getCaloriesBurned() + "\n");
        }
    }

    public void AverageDistanceByActivity(ArrayList<ActivityDetails>activities){
        double totalSwimming = 0,totalRunning=0,totalCycling=0;
        double distanceSwimming=0, distanceRunning=0,distanceCycling=0;
        double averageDistanceSwimming,averageDistanceRunning,averageDistanceCycling;
        for (ActivityDetails a:activities){
            switch (a.getActivityType()) {
                case "Swimming": {
                    totalSwimming++;
                    distanceSwimming += a.getDistance();
                break;
                }
                case "Running" : {
                    totalRunning++;
                    distanceRunning += a.getDistance();

                break;
                }
                case "Cycling": {
                    totalCycling++;
                    distanceCycling += a.getDistance();
                break;
                }
            }
        }
        averageDistanceSwimming=distanceSwimming/totalSwimming;
        averageDistanceRunning=distanceRunning/totalRunning;
        averageDistanceCycling=distanceCycling/totalCycling;
        System.out.printf("Swimming: %.2fkm\n",averageDistanceSwimming);
        System.out.printf("Running: %.2fkm\n",averageDistanceRunning);
        System.out.printf("Cycling: %.2fkm\n",averageDistanceCycling);

    }
    public void AverageCaloriesBurned(ArrayList<ActivityDetails> activities) {
        double Calories = 0;
        double averageCalories = 0;
        double total = 0;
        for (ActivityDetails a : activities) {
            total++;
            Calories += a.getCaloriesBurned();
        }
        averageCalories = Calories / total;
        System.out.printf("Average Calories Burned: %.2f \n", averageCalories);
    }
//Was using this function temporarily to check if the split function had worked and thought of what how I would isolate them further.

//        public void DateIsolation(ArrayList<ActivityDetails>activities) {
//            for (ActivityDetails a : activities) {
//                String str = a.getDate();
//                String[] string = str.split("/");
//                String DateSort = Arrays.toString(string);
//                System.out.println(DateSort);
//            }
//        }

    //create a mini menu method for the subsets
    //options are:
    //activity type
    //above a minimum distance
    // type of energy expended (using the enums)
    //above a minimum duration
    //for minimum distance and duration - ask the user to input a number and output the distances and durations which are above this
    //use getters

    public void activityTypes(ArrayList<ActivityDetails> activities) {
        //declare a scanner, for the user to input which activity type they would like to view
        Scanner userKb = new Scanner(System.in);

        //runActivity is set to true, until it is set to false inside the do while loop
        boolean runActivity = true;

        //set to empty until user inputs
        String selectedActvity = "";
        String userAnswer = "";

        //do valid input for user to only type in cycling,running or swimming
        do {
            System.out.println("Select an activity type (cycling, running, or swimming): ");
            selectedActvity = userKb.nextLine();

            //using getActivityType to get the selected activity type
            for (ActivityDetails a : activities) {
                if (a.getActivityType().equalsIgnoreCase(selectedActvity)) {
                    System.out.println(a);
                }
            }

            System.out.println("\n" + "Would you like to view another activity? (yes or no)");
            userAnswer = userKb.nextLine();

            runActivity = userAnswer.equalsIgnoreCase("yes");
        } while (runActivity);
    }

    //alternative method to display the subset: will use cases similarly to the main menu
//    public void activityTypes(ArrayList<ActivityDetails> activities){
//        System.out.println("============================== SELECT AN ACTIVITY ==============================");
//        System.out.println("1: Cycling");
//        System.out.println("2: Running ");
//        System.out.println("3: Swimming");
//
//
//
//
//    }
}
