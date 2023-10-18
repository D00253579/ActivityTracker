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

    //Sorting duration by ascending
    //using lambda

    public void displayDurationAsc ()throws IOException {
        Collections.sort(activities,
                (ActivityDetails a1, ActivityDetails a2) ->
                {
                    return a1.getDuration() - a2.getDuration();
                });
        displayData(activities);
    }

//        Collections.sort(activities, (a1, a2) ->
//        {
//            return  a1.getDuration() - a2.getDuration());
//        });


}
