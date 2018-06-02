import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
//����˼·��
//�����ֽ��зּ���������Ϊ4
//�Էּ����ÿ���ֱ��������õ��ַ�������
//�磺123456=12|3456
//�ڶ�����12=Ҽʰ�� + ����
//��һ����3456 =��ǧ������ʰ½ + ����
public final class Main {
  private String amount = null;
  private static final String NUM = "��Ҽ��������½��ƾ�";
  private static final String UNIT = "Ǫ��ʰ��";
  private static final String GRADEUNIT = "Ǫ������";
  private static final String DOTUNIT = "�Ƿ���";
  private static final int GRADE = 4;
  public Main(String amount) {
    this.amount = amount;
  }
  
  private static String toBigAmt(String amount){
//    String amt = nf.format(amount);
//    Double d = new Double(amount);
    String dotPart = ""; //ȡС��λ
    String intPart = ""; //ȡ����λ
//    int dotPos;
	  String part[]=amount.split("\\.");
	  int len=part.length;
    if ( len==2) {
      intPart = part[0];
      dotPart = part[1];
    }
    else {
      intPart = part[0];
    }
    String intBig = intToBig(intPart);
    String dotBig = dotToBig(dotPart);
    
    
    //���´��������޸ģ������������Ĵ�������
    if ((dotBig.length() == 0)&&(intBig.length() != 0)) {
      return intBig + "Ԫ��";
    }else if((dotBig.length() == 0)&&(intBig.length() == 0)){
      return intBig + "��Ԫ";  
    }else if((dotBig.length() != 0)&&(intBig.length() != 0)) {
      return intBig + "Ԫ" + dotBig;
    }else{
      return dotBig;  
    }
/*
    if(dotBig.length() == 0) return intBig +"Ԫ��";
    else return intBig + "Ԫ" + dotBig;
*/
    }
  
  private static String dotToBig(String dotPart){
      //�õ�ת����Ĵ�д��С�����֣�
    String strRet = "";
    for(int i=0; i<dotPart.length() && i<3; i++){
      int num;
      if((num = Integer.parseInt(dotPart.substring(i,i+1))) != 0)
        strRet += NUM.substring(num,num+1) + DOTUNIT.substring(i,i+1);
    }
    return strRet;
  }
  private static String intToBig(String intPart){
      //�õ�ת����Ĵ�д���������֣�
      int grade; //����
      String result = "";
      String strTmp = "";
      //�õ�������
      grade = intPart.length() / GRADE;
      //�������γ���
      if(intPart.length() % GRADE != 0) grade += 1;
      //��ÿ�����ִ���
      for(int i = grade; i >= 1; i--){
          strTmp = getNowGradeVal(intPart, i);//ȡ�õ�ǰ��������
          result += getSubUnit(strTmp);//ת����д
          result = dropZero(result);//����
          //�Ӽ��ε�λ
          if( i>1 ) //ĩλ���ӵ�λ
              //��λ����������
              if(getSubUnit(strTmp).equals("��������")){
                  result += "��"+GRADEUNIT.substring(i - 1, i);
              }else{
                  result += GRADEUNIT.substring(i - 1, i);
              }
      }
      return result;
  }
  private static String getNowGradeVal(String strVal,int grade){
      //�õ���ǰ���εĴ�
      String rst;
      if(strVal.length() <= grade * GRADE)
          rst = strVal.substring(0,strVal.length() - (grade-1)*GRADE);
      else
          rst = strVal.substring(strVal.length() - grade*GRADE,strVal.length() - (grade-1)*GRADE);
      return rst;
  }
  private static String getSubUnit(String strVal){
      //��ֵת��
      String rst = "";
      for(int i = 0;i< strVal.length(); i++){
          String s = strVal.substring(i,i+1);
          int num = Integer.parseInt(s);
          if(num == 0){
              //���㡱�����⴦��
              if(i != strVal.length()) //ת������ĩλ����Ϊ��
                  rst += "��";
          }else{
              //If IntKey = 1 And i = 2 Then
                  //��Ҽʰ�������⴦��
                  //��Ҽʰ������
              //Else
                  rst += NUM.substring(num,num+1);
              //End If
              //׷�ӵ�λ
              if(i != strVal.length()-1 )//��λ���ӵ�λ
                rst += UNIT.substring(i+4-strVal.length(),i+4-strVal.length()+1);
          }
      }
      return rst;
  }
  private static String dropZero(String strVal){
      //ȥ�����̵ġ��㡱
      String strRst;
      String strBefore; //ǰһλ���ַ�
      String strNow;    //����λ���ַ�
      strBefore = strVal.substring(0,1);
      strRst = strBefore;
      for(int i= 1; i<strVal.length(); i++) {
          strNow = strVal.substring(i, i+1);
          if(strNow.equals("��") && strBefore.equals("��"))
              ;//ͬʱΪ��
          else
              strRst += strNow;
          strBefore = strNow;
      }
      //ĩλȥ��
      if(strRst.substring(strRst.length()-1, strRst.length()).equals("��"))
        strRst = strRst.substring(0,strRst.length()-1);
      return strRst;
  }
  public static void main(String[] args) {
	  Scanner scan = new Scanner(System.in);
	  while (scan.hasNext()) {
		  String a=scan.next();
		  System.out.println(Main.toBigAmt(a));
	  }
	  scan.close();
  }
} 