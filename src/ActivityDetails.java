import java.util.ArrayList;
import java.util.Collections;

public class ActivityDetails {

    private String activityType;
    private String date;
    private int duration;
    private double distance;
    private double heartRate;

    //CONSTRUCTORS
    public ActivityDetails() {
        this.activityType = "";
        this.date = "";
        this.duration = 0;
        this.distance = 0.0;
        this.heartRate = 0.0;
    }

    public ActivityDetails(String activityType, String date, int duration, double distance, double heartRate) {
        this.activityType = activityType;
        this.date = date;
        this.duration = duration;
        this.distance = distance;
        this.heartRate = heartRate;
    }

    //GETTERS
    public String getActivityType() {
        return activityType;
    }

    public String getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    public double getDistance() {
        return distance;
    }

    public double getHeartRate() {
        return heartRate;
    }


    //SETTERS
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }


    @Override
    public String toString() {
        return "ActivityDetails{" + "activityType='" + activityType + '\'' + ", date='" + date + '\'' + ", duration=" + duration + ", distance=" + distance + ", heartRate=" + heartRate + '}';
    }
//Sorting duration by descending

    public int compareTo(ActivityDetails a) {
        if (duration < a.getDuration()) {
            return 1;
        } else if (duration > a.getDuration()) {
            return -1;
        }
        return 0;
    }

}


