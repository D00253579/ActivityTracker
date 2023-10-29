import java.util.Comparator;

public class DescDateComparator implements Comparator<ActivityDetails>  {
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
                return Integer.compare(year2,year1);
            }else if (month1!=month2){
                return Integer.compare(month2,month1);
            }
            return Integer.compare(day2,day1);
        }

}
