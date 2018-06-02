import java.util.HashMap;  
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;  
import java.util.StringTokenizer;
import java.util.regex.Pattern;  
  
public class Main {  
  
    public static void main(String args[]) {  
    	Scanner scan = new Scanner(System.in);
    	while (scan.hasNext()) {
			String computeExpr = scan.nextLine();
			Main test = new Main(); 
	        int result2 = test.computeWithStack(computeExpr);  
	        System.out.println(result2);  
    	}
    	scan.close();
    }  
      
    /** 
     * ����java.util.Stack�������������ַ������ʽ��ֵ������׳��쳣����˵�����ʽ���������û�п��� 
     * java.util.Stack��ʵҲ�Ǽ̳���java.util.Vector�ġ� 
     * @param computeExpr ���������ַ������ʽ 
     * @return ������ 
     */  
    public int computeWithStack(String computeExpr) {  
        //�ѱ��ʽ������������ŷָ��һ��һ�εģ����ҷָ��Ľ�������ָ���  
        StringTokenizer tokenizer = new StringTokenizer(computeExpr, "+-*/()", true);  
        Stack<Integer> numStack = new Stack<Integer>();   //����������ֵ�ջ  
        Stack<Operator> operStack = new Stack<Operator>();  //��Ų�������ջ  
        Map<String, Operator> computeOper = this.getComputeOper();    //��ȡ���������  
        String currentEle;  //��ǰԪ��  
        while (tokenizer.hasMoreTokens()) {  
            currentEle = tokenizer.nextToken().trim();  //ȥ��ǰ��Ŀո�  
            if (!"".equals(currentEle)) {   //ֻ����ǿ��ַ�  
                if (this.isNum(currentEle)) { //Ϊ����ʱ����뵽����ջ��  
                    numStack.push(Integer.valueOf(currentEle));  
                } else { //������  
                    Operator currentOper = computeOper.get(currentEle);//��ȡ��ǰ���������  
                    if (currentOper != null) {  //��Ϊ��ʱ��Ϊ���������  
                        while (!operStack.empty() && operStack.peek().priority() >= currentOper.priority()) {  
                            compute(numStack, operStack);  
                        }  
                        //�������ѵ�ǰ���������뵽����ջ��  
                        operStack.push(currentOper);  
                    } else {//����  
                        if ("(".equals(currentEle)) { //������ʱ�������Ų�������ջ��  
                            operStack.push(Operator.BRACKETS);  
                        } else { //������ʱ, �������Ÿ�������֮��ʣ����������ִ���ˡ�  
                            while (!operStack.peek().equals(Operator.BRACKETS)) {  
                                compute(numStack, operStack);  
                            }  
                            operStack.pop();//�Ƴ�ջ����������  
                        }  
                    }  
                }  
            }  
        }  
        // �����������ı���������Ӧ����nums����ʣ����������������operators����ʣһ�����������������  
        while (!operStack.empty()) {  
            compute(numStack, operStack);  
        }  
        return numStack.pop();  
    }  
      
    /** 
     * �ж�һ���ַ����Ƿ����������� 
     * @param str 
     * @return 
     */  
    private boolean isNum(String str) {  
        String numRegex = "^\\d+(\\.\\d+)?$";   //���ֵ�������ʽ  
        return Pattern.matches(numRegex, str);  
    }  
      
    /** 
     * ��ȡ��������� 
     * @return 
     */  
    private Map<String, Operator> getComputeOper() {  
        return new HashMap<String, Operator>() { // �����  
            private static final long serialVersionUID = 7706718608122369958L;  
            {  
                put("+", Operator.PLUS);  
                put("-", Operator.MINUS);  
                put("*", Operator.MULTIPLY);  
                put("/", Operator.DIVIDE);  
                put("^", Operator.Fang); 
            }  
        };  
    }  
      
    /** 
     * ȡnumStack������������֣�operStack�����һ��������������㣬Ȼ����������ٷŵ�numStack����� 
     * @param numStack  ����ջ 
     * @param operStack ����ջ 
     */  
    private void compute(Stack<Integer> numStack, Stack<Operator> operStack) {  
        int num2 = numStack.pop(); // ��������ջ��ϵ�������Ϊ����ĵڶ�������  
        int num1 = numStack.pop(); // ��������ջ��ϵ�������Ϊ����ĵ�һ������  
        int computeResult = operStack.pop().compute(  
                num1, num2); // ��������ջ��ϵ���������м���  
        numStack.push(computeResult); // �Ѽ��������·ŵ����е�ĩ��  
    }  
      
    /** 
     * ����� 
     */  
    private enum Operator {  
        /** 
         * �� 
         */  
        PLUS {  
            @Override  
            public int priority() {  
                return 1;   
            }  
  
            @Override  
            public int compute(int num1, int num2) {  
                return num1 + num2;   
            }  
        },  
        /** 
         * �� 
         */  
        MINUS {  
            @Override  
            public int priority() {  
                return 1;   
            }  
  
            @Override  
            public int compute(int num1, int num2) {  
                return num1 - num2;   
            }  
        },  
        /** 
         * �� 
         */  
        MULTIPLY {  
            @Override  
            public int priority() {  
                return 2;   
            }  
  
            @Override  
            public int compute(int num1, int num2) {  
                return num1 * num2;   
            }  
        },  
        /** 
         * �� 
         */  
        DIVIDE {  
            @Override  
            public int priority() {  
                return 2;   
            }  
  
            @Override  
            public int compute(int num1, int num2) {  
                return num1 / num2;   
            }  
        },
        /**
		 * ƽ��
		 */
		Fang {
			@Override
			public int priority() {
				return 3;
			}

			@Override
			public int compute(int num1, int num2) {
				return (int) Math.pow(num1, num2);
			}
		},
        /** 
         * ���� 
         */  
        BRACKETS {  
            @Override  
            public int priority() {  
                return 0;   
            }  
  
            @Override  
            public int compute(int num1, int num2) {  
                return 0;   
            }  
        };  
        /** 
         * ��Ӧ�����ȼ� 
         * @return 
         */  
        public abstract int priority();  
  
        /** 
         * ������������Ӧ�������� 
         * @param num1  ��һ�������� 
         * @param num2  �ڶ��������� 
         * @return 
         */  
        public abstract int compute(int num1, int num2);  
    }  
}  