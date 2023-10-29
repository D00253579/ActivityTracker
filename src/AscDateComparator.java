import java.util.Comparator;

public class AscDateComparator implements Comparator<ActivityDetails> {
    public int compare(ActivityDetails a1,ActivityDetails a2){
        String[] str1=a1.getDate().split("/");
        String[] str2=a2.getDate().split("/");
        int day1=Integer.parseInt(str1[0]);
        int month1=Integer.parseInt(str1[1]);
        int year1=Integer.parseInt(str1[2]);
        int day2=Integer.parseInt(str2[0]);
        int month2=Integer.parseInt(str2[1]);
        int year2=Integer.parseInt(str2[2]);

if (year1!=year2){
    return Integer.compare(year1,year2);
}else if (month1!=month2){
    return Integer.compare(month1,month2);
}
return Integer.compare(day1,day2);
    }
}