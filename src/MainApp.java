import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainApp {
    public static void readFile(String fileName, ArrayList<Activity> activities, boolean hasHeaders) throws IOException {
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
                    Activity a = parseLine(line);
                    activities.add(a);
                }

            }else{
                headersRead = true;
            }
            System.out.println(line);
        }
    }

    private static Activity parseLine(String line) {
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

        return new Activity(activityType, date, duration, distance, heartRate);
    }
    public static void displayMenu(){
        System.out.println("\n==============================ACTIVITY TRACKER===============================");
        System.out.println("0: Exit");
        System.out.println("1: Display All data");
        System.out.println("2: Calories Burned (Descending)");
        System.out.println("3: Date (Ascending/Descending)");
        System.out.println("4: Activity Duration (Ascending/Descending)");
        System.out.println("5: Type of Activity");
        System.out.println("6: Distance (Ascending/Descending)");
    }


    public static void main(String[] args) throws IOException {
        ArrayList<Activity> activities = new ArrayList<>();
        readFile("Activities.csv", activities, true);


        Scanner key=new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice=key.nextInt();
            switch (choice){
                case 1:{
                    /*Cycle through each piece of data in the CSV file and allows us to run our
                    class commands and isolate each piece of data.
                    */
                    System.out.println("\n==============DISPLAY ALL DATA==============\n");
                    for (Activity a:activities){
//                    System.out.println(a.toString());
                        /*Displaying the data in a neat matter using printf to include an appropriate amount of
                        white space and to round the doubles down to 1 decimal point*/

                        System.out.printf("%10s,%11s,%4d,%5.1f,%7.1f\n",a.getActivityType(),a.getDate(),a.getDuration(),a.getDistance(),a.getHeartRate());
                }
                }
            }
        }while(choice != 0);
    }

}