import java.util.Comparator;

public class DescDistanceComparator implements Comparator<ActivityDetails> {
    public int compare(ActivityDetails a1, ActivityDetails a2) {
        if (a1.getDistance() > a2.getDistance()) {
            return -1;
        } else if (a1.getDistance() < a2.getDistance()) {
            return 1;
        }
        return 0;
    }
}
