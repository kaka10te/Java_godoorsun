//Java上机练习 自动化16 #5 (课后)
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] weeks = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};  
            int num=scan.nextInt();
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");  
            Calendar c1 = Calendar.getInstance();
            c1.set(2000, 1-1,1);
            c1.add(Calendar.DAY_OF_MONTH, num);
            System.out.println(df.format(c1.getTime())+" "+weeks[c1.get(Calendar.DAY_OF_WEEK)-1]);
        }
        scan.close();
    }
}
