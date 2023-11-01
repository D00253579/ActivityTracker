import java.util.Comparator;

/*For the date Comparator I was trying different methods on how to perform the task and came across the Integer.compare method.
I went online and did some research and found out that I was able to use it for what I wanted to achieve. It works exactly the same
as if I was to create a comparator for an integer to sort in ascending or descending.
If x>y then the method returns a value greater than 0
If x<y then the method returns a value less than 0
If x=y then the method returns 0
AMP TutorialKart Pvt Ltd(2018).Java Integer.compare() – Compare two integer values [online].
    Available at: https://www.tutorialkart.com/java/java-integer-compare/#gsc.tab=0
    [accessed 29 October 2023].
*/
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