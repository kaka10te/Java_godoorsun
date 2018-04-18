import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
	        while(scan.hasNext()){
	        	LinkedList<String> list = new LinkedList<String>();
	        	int n=scan.nextInt();
	        	for(;n>0;n--) {
	        		String c = scan.next();
	        		switch(c){
	        		case "A":
	        			if(list.getLast().isEmpty())
	        				System.out.println("E");
	        			else System.out.println(list.getLast());
	        			continue;
	        		case "O":
	        			list.removeLast();
	        			continue;
	        		case "P":
	        			String x=scan.next();
	        			list.add(x);
	        		}
	        	}
	        	System.out.println();
	        	list.clear();
	        } 
	        scan.close();
}
}
