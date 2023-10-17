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

    public static void main(String[] args) throws IOException {
        ArrayList<Activity> activities = new ArrayList<>();
        readFile("Activities.csv", activities, true);
    }
}