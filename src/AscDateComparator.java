import java.util.Comparator;

public class AscDateComparator implements Comparator<ActivityDetails> {
    public int compare(ActivityDetails a1,ActivityDetails a2){
        /*This compare method for comparator isolates the String of dates from the csv file by the "/"
     and stores them into a String array. It then stores the day month and year into its own variables using the index
      and by parsing the data in the string array to an integer.
    */
        String[] str1=a1.getDate().split("/");
        String[] str2=a2.getDate().split("/");
        int day1=Integer.parseInt(str1[0]);
        int month1=Integer.parseInt(str1[1]);
        int year1=Integer.parseInt(str1[2]);
        int day2=Integer.parseInt(str2[0]);
        int month2=Integer.parseInt(str2[1]);
        int year2=Integer.parseInt(str2[2]);
//If the years are not the same then it compares the years and sorts in ascending order.

if (year1!=year2){
    return Integer.compare(year1,year2);
    //If the months are not the same then it compares the months and sorts in ascending order.
}else if (month1!=month2){
    return Integer.compare(month1,month2);
}
        //If the days are not the same then it compares the days and sorts in ascending order.
return Integer.compare(day1,day2);
    }

}