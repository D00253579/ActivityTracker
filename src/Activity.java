import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Activity {
    ArrayList<ActivityDetails> activities = new ArrayList<>();

    //Method to display the main menu, called in the mainApp
    public static void displayMenu(ArrayList<ActivityDetails> activities) {
        System.out.println("\n==============================ACTIVITY TRACKER===============================");
        System.out.println("0: Exit");
        System.out.println("1: Display All data");
        System.out.println("2: Calories Burned (Descending)");
        System.out.println("3: Date (Ascending/Descending)");
        System.out.println("4: Activity Duration (Ascending/Descending)");
        System.out.println("5: Type of Activity");
        System.out.println("6: Distance (Ascending/Descending)");
        System.out.println("7: Display Natural Ordering");
        System.out.println("8: Display intensity");
        System.out.println("9: Display Statistics");
        System.out.println("10: View Activity Fields");
    }

    //Method to display the data passed in from the CSV
    //Have the headers outputting too
    public void displayData(ArrayList<ActivityDetails> activities) {
        System.out.println("\n==============================DISPLAY DATA===============================\n");
    /*enhanced for loop to cycle through the data in the arraylist and pass it to the object
         'a' to access class methods. */
        System.out.printf("%-12s,%-12s,%-12s,%-12s,%-12s", "Activity Type", "Date", "Duration", "Distance", "Average Heart Rate\n");

        for (ActivityDetails a : activities) {
            //                    System.out.println(a.toString());
        /*Displaying the data in a neat matter using printf to include an appropriate amount of
                        white space and to round the doubles down to 1 decimal point*/
            System.out.printf("%-12s,%-12s,%-12d,%-12.1f,%-12.1f\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getHeartRate());
        }
    }

//    public void displayData(ArrayList<ActivityDetails> activities) {
//        System.out.println("\n==============DISPLAY DATA==============\n");
//    /*enhanced for loop to cycle through the data in the arraylist and pass it to the object
//         'a' to access class methods. */
//        System.out.printf("%10s,%2s,%6s,%9s,%10s", "Activity Type", "Date", "Duration", "Distance", "Average Heart Rate\n");
//
//        for (ActivityDetails a : activities) {
//            //                    System.out.println(a.toString());
//        /*Displaying the data in a neat matter using printf to include an appropriate amount of
//                        white space and to round the doubles down to 1 decimal point*/
//            System.out.printf("%10s,%11s,%4d,%5.1f,%7.1f\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getHeartRate());
//        }
//    }

    //Sorting duration by ascending - and calling the displayData to view the sorted ascending duration
    //Using lambda expression
    public void displayDurationAsc(ArrayList<ActivityDetails> activities) {
        Collections.sort(activities,
                (ActivityDetails a1, ActivityDetails a2) ->
                {
                    return a1.getDuration() - a2.getDuration();
                });
        displayData(activities);
    }

    //Sorting duration by descending - and calling the displayData to view the sorted ascending duration
    //Using lambda expression
    public void displayDurationDesc(ArrayList<ActivityDetails> activities) {
        Collections.sort(activities,
                (ActivityDetails a1, ActivityDetails a2) ->
                {
                    return a2.getDuration() - a1.getDuration();
                });
        displayData(activities);
    }

    //Display by natural ordering - using the compareTo in the ActivityDetails class
    //Comparing each of the activity fields - so the sorted fields can be used for binary search
    public void displayNaturalOrdering(ArrayList<ActivityDetails> activities) {
        Collections.sort(activities);
        displayData(activities);
    }
/*Accessing the enums that have been set in the ActivityDetails Class and uses an if statement to display the data based on
    the different activity types as each activity have different intensity levels.
    */
    public void displayIntensity(ArrayList<ActivityDetails> activities) {
        for (ActivityDetails a : activities) {
            if (a.getActivityType().equals("Swimming")) {
                System.out.println("Activity: " + a.getActivityType() + "    Intensity: " + a.getIntensitySwimming());
            } else if (a.getActivityType().equals("Running")) {
                System.out.println("Activity: " + a.getActivityType() + "     Intensity: " + a.getIntensityRunning());
            } else if (a.getActivityType().equals("Cycling")) {
                System.out.println("Activity: " + a.getActivityType() + "     Intensity: " + a.getIntensityCycling());
            }
        }
    }
//Accesses the getCaloriesBurned method created in the ActivityDetails Class and displays it based on each activity
    public void displayCaloriesBurned(ArrayList<ActivityDetails> activities) {

        for (ActivityDetails a : activities) {

            System.out.println("Activity: " + a.getActivityType() + "\n Calories Burned: " + a.getCaloriesBurned() + "\n");
        }
    }

    //This method gets the averageDistance covered based one each different activity and displays it
    public void AverageDistanceByActivity(ArrayList<ActivityDetails> activities) {
        //Counters for how many activities were read from file.
        double totalSwimming = 0, totalRunning = 0, totalCycling = 0;
        //Variables that stored the total distance based on each activity
        double distanceSwimming = 0, distanceRunning = 0, distanceCycling = 0;
        //Variables that stored the average at the end of the loop and displayed it.
        double averageDistanceSwimming, averageDistanceRunning, averageDistanceCycling;
        for (ActivityDetails a : activities) {
            switch (a.getActivityType()) {
                case "Swimming": {
                    totalSwimming++;
                    distanceSwimming += a.getDistance();
                    break;
                }
                case "Running": {
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
        averageDistanceSwimming = distanceSwimming / totalSwimming;
        averageDistanceRunning = distanceRunning / totalRunning;
        averageDistanceCycling = distanceCycling / totalCycling;
        System.out.printf("Swimming: %.2fkm\n", averageDistanceSwimming);
        System.out.printf("Running: %.2fkm\n", averageDistanceRunning);
        System.out.printf("Cycling: %.2fkm\n", averageDistanceCycling);
    }

    //This method gets the averageCaloriesBurned overall and dislays it.
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

    //Created a mini menu method for the subsets to be displayed
    //Gives the user the options of which subset they would like to view
    public void displaySubsetMenu(ArrayList<ActivityDetails> activities) {
        System.out.println("============================== ACTIVITY FIELDS ==============================");
        System.out.println("11: Activity Types");
        System.out.println("12: Minimum Distance");
        System.out.println("13: Type Of Energy Expended");
        System.out.println("14: Minimum Duration ");
        System.out.println("15: Exit");
    }

    //Declare scanner outside the methods - can access key in the methods
    //Instead of repeatedly declaring scanners within the methods
    Scanner key = new Scanner(System.in);

    //Method to display the subset menu, using a similar do while loop to the main menu
    public void subsetMenu(ArrayList<ActivityDetails> activities) {
        //Declaring an activity object - used to access methods
        Activity a = new Activity();

//        boolean exit = true;
        int choice;
        do {
            a.displaySubsetMenu(activities);
            choice = key.nextInt();
            switch (choice) {
                case 11: {
                    System.out.println("===============ACTIVITY TYPES================");
                    a.selectActivityType(activities);
                    break;
                }
                case 12: {
                    System.out.println("===============MINIMUM DISTANCE================");
                    a.minDistance(activities);
                    break;
                }
                case 13: {
                    System.out.println("=============TYPE OF ENERGY EXPENDED============");
                    a.typeEnergyExpended(activities);
                    break;
                }
                case 14: {
                    System.out.println("===============MINIMUM DURATION================");
                    a.minDuration(activities);
                }
                case 15: {
                    //Breaks the do while loop - by exiting the program
//                    exit = false;
                    System.exit(0);
                    break;
                }
            }
        } while (true);
    }

//
//    Caitlin: I was having issues with exiting the subset menu, I originally wanted it to be able to go back to the main menu,
//    however the main menu is not within a method so I couldn't access it in this class from the mainApp.
//    The reference below is what I used for 'System.exit(0);
//
     /*
    user3452963(2014).Putting a loop on a switch-case. exit menu when option 5 is selected by user, Stack Overflow [online].
    Available at: https://stackoverflow.com/questions/22596416/putting-a-loop-on-a-switch-case-exit-menu-when-option-5-is-selected-by-user
    [accessed 01 November 2023].
     */

    //Caitlin: I attempted doing the activity type this way and decided there isn't a need to ask the user "Would they like to view another activity?":
//    public void selectActivityType(ArrayList<ActivityDetails> activities) {
//        //declare a scanner, for the user to input which activity type they would like to view
//
//        //runActivity is set to true, until it is set to false inside the do while loop
//        boolean runActivity = true;
//
//        //set to empty until user inputs
//        String selectedActvity = "";
//        String userAnswer = "";
//
//        //do valid input for user to only type in cycling,running or swimming
//        do {
//            System.out.println("Select an activity type (cycling, running, or swimming): ");
//            selectedActvity = key.nextLine();
//
//            //using getActivityType to get the selected activity type
//            for (ActivityDetails a : activities) {
//                if (a.getActivityType().equalsIgnoreCase(selectedActvity)) {
//                    System.out.println(a);
//                }
//            }
//
//            System.out.println("\n" + "Would you like to view another activity? (yes or no)");
//            userAnswer = key.nextLine();
//
//            runActivity = userAnswer.equalsIgnoreCase("yes");
//        } while (runActivity);

    //Method to view the activity type subsets
    public void selectActivityType(ArrayList<ActivityDetails> activities) {
        String selectedActvity = "";
        boolean activityExists = false;

        //set to empty until user inputs
        System.out.println("Select an activity type (cycling, running, or swimming): ");
        selectedActvity = key.nextLine();

        System.out.printf("%-12s,%-12s,%-12s,%-12s,%-12s", "Activity Type", "Date", "Duration", "Distance", "Average Heart Rate\n");

        //Iterates through the activities arrayList in an enhanced for loop
        //Using getActivityType to get the selected activity type
        //Returns true if the inputted activity exists in the arrayList
        for (ActivityDetails a : activities) {
            if (a.getActivityType().equalsIgnoreCase(selectedActvity)) {
                System.out.printf("%-12s,%-12s,%-12d,%-12.1f,%-12.1f\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getHeartRate());
                activityExists = true;
            }
        }

        //If the inputted activity does not exist in the arraylist
        //Then a message is output
        if (!activityExists) {
            System.out.println("No activities found called " + selectedActvity);
        }
        //Take the user back to the subset menu
        subsetMenu(activities);
    }

    //Declare boolean outside the methods as it is used in both the minDistance() and minDuration()
    boolean aboveMin = false;

    //Method to view the activities above a minimum distance subset
    public void minDistance(ArrayList<ActivityDetails> activities) {
        double min = 0.0;

        //Asking the user to input a number
        System.out.println("Input a minimum distance");
        min = key.nextDouble();

//       Output the activity distances which are above the users number
        //Using getter method
        //If there are distances above the users minimum then they will be output and aboveMin will turn true

        System.out.printf("%-12s,%-12s,%-12s,%-12s,%-12s", "Activity Type", "Date", "Duration", "Distance", "Average Heart Rate\n");
        for (ActivityDetails a : activities) {
            if (a.getDistance() > min) {
                System.out.printf("%-12s,%-12s,%-12d,%-12.1f,%-12.1f\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getHeartRate());
                aboveMin = true;
            }
        }

        //If aboveMin is false then message will be output
        if (!aboveMin) {
            System.out.println("No activities found above the minimum distance: " + min);
        }

        //Take the user back to the subset menu
        subsetMenu(activities);
    }

    //Method to view the activities above a minimum duration subset
    public void minDuration(ArrayList<ActivityDetails> activities) {
        int min = 0;

        //Asking the user to input a number
        System.out.println("Input a minimum duration");
        min = key.nextInt();

//       Output the activity durations which are above the users number
        //Using getter method
        //If there are durations above the users minimum then they will be output and aboveMin will turn true

        System.out.printf("%-12s,%-12s,%-12s,%-12s,%-12s", "Activity Type", "Date", "Duration", "Distance", "Average Heart Rate\n");
        for (ActivityDetails a : activities) {
            if (a.getDuration() > min) {
                System.out.printf("%-12s,%-12s,%-12d,%-12.1f,%-12.1f\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getHeartRate());
                aboveMin = true;
            }
        }

        //If aboveMin is false then message will be output
        if (!aboveMin) {
            System.out.println("No activities found above the minimum duration: " + min);
        }

        //Take the user back to the subset menu
        subsetMenu(activities);
    }

    //Method to view the type of energy expended subset
    //Using the enums
    public void typeEnergyExpended(ArrayList<ActivityDetails> activities) {
        String selectedEnergy = "";
        boolean energyTypeExists = false;

        //set to empty until user inputs
        System.out.println("Select an activity type (cycling, running, or swimming): ");
        selectedEnergy = key.nextLine();

        //using getActivityType to get the selected activity type
//if statement each for swimming,cycling and running
        for (ActivityDetails a : activities) {
            if (a.getActivityType().equalsIgnoreCase(selectedEnergy)) {
                if (selectedEnergy.equalsIgnoreCase("Swimming")) {
                    System.out.println("Activity: " + a.getActivityType() + " Intensity: " + a.getIntensitySwimming());
                    energyTypeExists = true;
                }
                if (selectedEnergy.equalsIgnoreCase("Running")) {
                    System.out.println("Activity: " + a.getActivityType() + " Intensity: " + a.getIntensityRunning());
                    energyTypeExists = true;
                } else if (selectedEnergy.equalsIgnoreCase("Cycling")) {
                    System.out.println("Activity: " + a.getActivityType() + " Intensity: " + a.getIntensityCycling());
                    energyTypeExists = true;
                }
            }
        }

        //If energyTypeExists is set to false then a message will be output to the user
        if (!energyTypeExists) {
            System.out.println("No activities found called " + selectedEnergy);
        }
        //Take the user back to the subset menu
        subsetMenu(activities);
    }
}
