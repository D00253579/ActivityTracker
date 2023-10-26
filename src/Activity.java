import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Activity {
    ArrayList<ActivityDetails> activities = new ArrayList<>();

    //Method to display the data passed in from the CSV
    public void displayData(ArrayList<ActivityDetails> activities) throws IOException {
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
    public void displayDurationAsc(ArrayList<ActivityDetails> activities) throws IOException {
        Collections.sort(activities,
                (ActivityDetails a1, ActivityDetails a2) ->
                {
                    return a1.getDuration() - a2.getDuration();
                });
        displayData(activities);
    }

    public void displayDurationDesc(ArrayList<ActivityDetails> activities) throws IOException {
        Collections.sort(activities,
                (ActivityDetails a1, ActivityDetails a2) ->
                {
                    return a2.getDuration() - a1.getDuration();
                });
        displayData(activities);
    }

    //display by natural ordering
    public void displayNaturalOrdering(ArrayList<ActivityDetails> activities) throws IOException {
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

            System.out.println("Calories Burned: " + a.getCaloriesBurned());
        }
    }
    public void DateIsolation(ArrayList<ActivityDetails> activities){
        for (ActivityDetails a:activities) {
            int d, m, y;
//            System.out.println(a.getDate());
            int slashcounter = 0;
            if (a.getDate().contains("/")) {
                System.out.println(a.getDate().indexOf("/"));
                if (slashcounter==1) {
                    d = a.getDate().length();
//                    System.out.println(d);
                } else if (slashcounter == 2) {
                    m = a.getDate().length();
                } else {
                    y = a.getDate().length();
                }
            }
        }
        }
}
