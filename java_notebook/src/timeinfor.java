

import java.util.Calendar;

public class timeinfor {

	Calendar cal=Calendar.getInstance();
	  
	
	int month=cal.get(Calendar.MONTH);
	int day=cal.get(Calendar.DAY_OF_MONTH);
	int hour=cal.get(Calendar.HOUR);
	int min=cal.get(Calendar.MINUTE);
   
	
  
    String temptime=("���� ������: "+month+"��"+day+"��"+"  "+hour+"ʱ"+min+"��");
    String temptime2=(month+"��"+day+"��  "+hour+"ʱ"+min+"��");
   
}
