import java.util.Comparator;

public class DistanceComparator implements Comparator<ActivityDetails> {

    public int compare(ActivityDetails a1, ActivityDetails a2) {
        if (a1.getDistance() < a2.getDistance()) {
            return -1;
        } else if (a2.getDistance() < a1.getDistance()) {
            return 1;
        }
        return 0;
    }
}
