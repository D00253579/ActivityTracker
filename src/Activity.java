public class Activity {
private String activityType;
private String date;
private int duration;
private double distance;
private double heartRate;

//CONSTRUCTORS
    public Activity(){
        this.activityType = "";
        this.date = "";
        this.duration = 0;
        this.distance = 0.0;
        this.heartRate = 0.0;
    }

    public Activity(String activityType, String date, int duration, double distance, double heartRate) {
        this.activityType = activityType;
        this.date = date;
        this.duration = duration;
        this.distance = distance;
        this.heartRate = heartRate;
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



    @Override
    public String toString() {
        return "Activity{" +
                "activityType='" + activityType + '\'' +
                ", date='" + date + '\'' +
                ", duration=" + duration +
                ", distance=" + distance +
                ", heartRate=" + heartRate +
                '}';
    }
}
