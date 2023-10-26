import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Comparator;

public class MainApp {
    public static void readFile(String fileName, ArrayList<ActivityDetails> activities, boolean hasHeaders) throws IOException {
        //reads in the activities csv file
        File f = new File(fileName);
        //scanning through the csv file
        Scanner in = new Scanner(f);

        String line;
        boolean headersRead = false;

        while (in.hasNextLine()) {
            line = in.nextLine();
            if (!hasHeaders || hasHeaders && headersRead) {
                if (line != "") {
                    ActivityDetails a = parseLine(line);
                    activities.add(a);
                }

            } else {
                headersRead = true;
            }
//            System.out.println(line);
        }
    }

    private static ActivityDetails parseLine(String line) {
        String activityType;
        String date;
        int duration;
        double distance;
        double heartRate;

        //check for commas in activities csv file
        StringTokenizer st = new StringTokenizer(line, ",");
        activityType = st.nextToken();

        //use trim to remove white space
        date = st.nextToken().trim();
        duration = Integer.parseInt(st.nextToken().trim());
        distance = Double.parseDouble(st.nextToken().trim());
        heartRate = Double.parseDouble(st.nextToken().trim());

        return new ActivityDetails(activityType, date, duration, distance, heartRate);
    }

    public static void displayMenu() {
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
        System.out.println("9: Display Calories Burned");

    }


    public static void main(String[] args) throws IOException {
        ArrayList<ActivityDetails> activities = new ArrayList<>();
        readFile("Activities.csv", activities, true);
  /*Cycle through each piece of data in the CSV file and allows us to run our
                    class commands and isolate each piece of data.
                    */
        Activity a = new Activity();
        Scanner key = new Scanner(System.in);
        int choice;
        Comparator<ActivityDetails> comp = null;
        do {
            displayMenu();
            choice = key.nextInt();
            switch (choice) {
                case 1: {
                    a.displayData(activities);
                    break;
                }
                case 2: {
                    System.out.println("Calories Burned Descending");

                    Collections.sort(activities, new Comparator<ActivityDetails>() {
                        @Override
                        public int compare(ActivityDetails o1, ActivityDetails o2) {
                            if (o1.getCaloriesBurned() > o2.getCaloriesBurned()) {
                                return -1;
                            } else if (o1.getCaloriesBurned() < o2.getCaloriesBurned()) {
                                return 1;
                            }
                            return 0;
                        }
                    });
                    a.displayCaloriesBurned(activities);
                    break;
                }
                case 3: {
//                    System.out.println("Date Ascending");
//                    comp = new DateComparator();
//                    Collections.sort(activities, comp);
//                    a.displayData(activities);
a.DateIsolation(activities);
                    break;
                }
                case 4: {
/*Accessing compareTo method in ActivityDetails class
                    to sort data by duration (Ascending/Descending)
                     */
                    //Descending
                    System.out.println("Duration Descending");
                    a.displayDurationDesc(activities);
                    System.out.println("Duration Ascending");
                    a.displayDurationAsc(activities);
                    break;
                }
                case 5: {
                    System.out.println("Type Of Activity");
                    comp = new ActivityTypeComparator();
                    Collections.sort(activities, comp);
                    a.displayData(activities);
                    break;
                }
                case 6: {
                    System.out.println("Ascending Distance:");
                    comp = new DistanceComparator();
                    Collections.sort(activities, comp);
                    a.displayData(activities);

                    System.out.println("\nDescending Distance:");
                    comp = new DescDistanceComparator();
                    Collections.sort(activities, comp);
                    a.displayData(activities);
                    break;
                }
                case 7: {
                    System.out.println("Natural Ordering: ");
                    a.displayNaturalOrdering(activities);
                    break;
                }

                case 8: {
                    System.out.println("=================INTENSITY===============");
                    a.displayIntensity(activities);
                    break;
                }
                //TODO: Inner class for calories burned
                case 9: {
                    System.out.println("=====CALORIES BURNED=====");
                    a.displayCaloriesBurned(activities);


                }


            }
        } while (choice != 0);
    }
}

