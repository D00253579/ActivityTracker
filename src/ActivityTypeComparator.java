import java.util.Comparator;

public class ActivityTypeComparator implements Comparator<ActivityDetails> {
    public int compare(ActivityDetails a1, ActivityDetails a2){
        return a1.getActivityType().compareTo(a2.getActivityType());
    }

}
