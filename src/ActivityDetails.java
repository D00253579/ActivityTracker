import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;

public class ActivityDetails implements Comparable<ActivityDetails> {

    @Override
    public int compareTo(ActivityDetails a) {
        if (duration == a.duration) {
            if (distance == a.distance) {
                return activityType.compareTo(a.activityType);
            }
            return (int) (distance - a.distance);
        }
        return duration - a.duration;
    }

//    @Override
//    public int compareTo(ActivityDetails a) {
//        if (duration < a.getDuration()) {
//            return -1;
//        } else if (duration > a.getDuration()) {
//            return 1;
//        }
//        return 0;
//    }

    private String activityType;
    private String date;
    private int duration;
    private double distance;
    private double heartRate;

    public static enum Intensity {VeryLight, Light, Moderate, Vigorous, VeryVigorous}


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

    public Intensity getIntensitySwimming() {
        if (distance < 1.25) {
            return Intensity.VeryLight;
        } else if (distance < 2) {
            return Intensity.Light;
        } else if (distance < 2.75) {
            return Intensity.Moderate;
        } else if (distance < 3.5) {
            return Intensity.Vigorous;
        } else {
            return Intensity.VeryVigorous;
        }
    }

    public Intensity getIntensityRunning() {
        if (distance > 4) {
            return Intensity.VeryLight;
        } else if (distance > 4 && distance < 8) {
            return Intensity.Light;
        } else if (distance > 8 && distance < 12) {
            return Intensity.Moderate;
        } else if (distance > 12 && distance < 16) {
            return Intensity.Vigorous;
        } else {
            return Intensity.VeryVigorous;
        }
    }

    public Intensity getIntensityCycling() {
        if (distance > 8) {
            return Intensity.VeryLight;
        } else if (distance > 8 && distance < 16) {
            return Intensity.Light;
        } else if (distance > 17 && distance < 25) {
            return Intensity.Moderate;
        } else if (distance > 25 && distance < 33) {
            return Intensity.Vigorous;
        } else {
            return Intensity.VeryVigorous;
        }
    }

    public double getCaloriesBurned() {
        double calories = 0;
        calories = distance * duration;
        return calories;
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


}


