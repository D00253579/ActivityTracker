import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
//TODO: Date Comparator
public class DateComparator implements Comparator<ActivityDetails> {
    public void DateIsolation(ArrayList<ActivityDetails>activities){
        for (ActivityDetails a:activities){
            String str=a.getDate();
            String[] string=str.split("/",3);
            String DateSort= Arrays.toString(string);

        }

    }

    public int compare(ActivityDetails a1, ActivityDetails a2)
{
    return 1;
}
}
