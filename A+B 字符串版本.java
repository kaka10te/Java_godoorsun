import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
 
        Scanner scan = new Scanner(System.in);
            while(scan.hasNext()){
                String a=scan.next();
                String b=scan.next();
//              int len1=a.length();
//              int len2=b.length();
                int cf=0;
                 
                for(int i=0;;i++){
                    if(i>=a.length())break;
                    char tem= a.charAt(i);
                    if(i==0&&tem=='-') {
                        cf=1;
                    }
                    switch(tem){
                    case '0':continue;
                    case '1':continue;
                    case '2':continue;
                    case '3':continue;
                    case '4':continue;
                    case '5':continue;
                    case '6':continue;
                    case '7':continue;
                    case '8':continue;
                    case '9':continue;
                    default: 
                        a=a.replace(tem, ' ');
                        i=i-1;
                    }
                    a=a.replaceAll(" ", "");
                }
                if(cf==1)
                    a='-'+a;
                 
                cf=0;
                for(int j=0;;j++){
                    if(j>=b.length())break;
                    char tem= b.charAt(j);
                    if(j==0&&tem=='-') {
                        cf=1;
                    }
                    switch(tem){
                    case '0':continue;
                    case '1':continue;
                    case '2':continue;
                    case '3':continue;
                    case '4':continue;
                    case '5':continue;
                    case '6':continue;
                    case '7':continue;
                    case '8':continue;
                    case '9':continue;
                    default: 
                        b=b.replace(tem, ' ');
                        j=j-1;
                    }
                    b=b.replaceAll(" ", "");
                }
                if(cf==1)
                    b='-'+b;
                 
                int m=Integer.parseInt(a);
                int n=Integer.parseInt(b);
                System.out.println(m+n);
            }
            scan.close();
            } 
}
/**************************************************************
    Problem: 1008
    User: 201603080303
    Language: Java
    Result: Accepted
    Time:304 ms
    Memory:8248 kb
****************************************************************/
