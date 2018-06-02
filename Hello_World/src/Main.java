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
     * 利用java.util.Stack计算四则运算字符串表达式的值，如果抛出异常，则说明表达式有误，这里就没有控制 
     * java.util.Stack其实也是继承自java.util.Vector的。 
     * @param computeExpr 四则运算字符串表达式 
     * @return 计算结果 
     */  
    public int computeWithStack(String computeExpr) {  
        //把表达式用运算符、括号分割成一段一段的，并且分割后的结果包含分隔符  
        StringTokenizer tokenizer = new StringTokenizer(computeExpr, "+-*/()", true);  
        Stack<Integer> numStack = new Stack<Integer>();   //用来存放数字的栈  
        Stack<Operator> operStack = new Stack<Operator>();  //存放操作符的栈  
        Map<String, Operator> computeOper = this.getComputeOper();    //获取运算操作符  
        String currentEle;  //当前元素  
        while (tokenizer.hasMoreTokens()) {  
            currentEle = tokenizer.nextToken().trim();  //去掉前后的空格  
            if (!"".equals(currentEle)) {   //只处理非空字符  
                if (this.isNum(currentEle)) { //为数字时则加入到数字栈中  
                    numStack.push(Integer.valueOf(currentEle));  
                } else { //操作符  
                    Operator currentOper = computeOper.get(currentEle);//获取当前运算操作符  
                    if (currentOper != null) {  //不为空时则为运算操作符  
                        while (!operStack.empty() && operStack.peek().priority() >= currentOper.priority()) {  
                            compute(numStack, operStack);  
                        }  
                        //计算完后把当前操作符加入到操作栈中  
                        operStack.push(currentOper);  
                    } else {//括号  
                        if ("(".equals(currentEle)) { //左括号时加入括号操作符到栈顶  
                            operStack.push(Operator.BRACKETS);  
                        } else { //右括号时, 把左括号跟右括号之间剩余的运算符都执行了。  
                            while (!operStack.peek().equals(Operator.BRACKETS)) {  
                                compute(numStack, operStack);  
                            }  
                            operStack.pop();//移除栈顶的左括号  
                        }  
                    }  
                }  
            }  
        }  
        // 经过上面代码的遍历后最后的应该是nums里面剩两个数或三个数，operators里面剩一个或两个运算操作符  
        while (!operStack.empty()) {  
            compute(numStack, operStack);  
        }  
        return numStack.pop();  
    }  
      
    /** 
     * 判断一个字符串是否是数字类型 
     * @param str 
     * @return 
     */  
    private boolean isNum(String str) {  
        String numRegex = "^\\d+(\\.\\d+)?$";   //数字的正则表达式  
        return Pattern.matches(numRegex, str);  
    }  
      
    /** 
     * 获取运算操作符 
     * @return 
     */  
    private Map<String, Operator> getComputeOper() {  
        return new HashMap<String, Operator>() { // 运算符  
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
     * 取numStack的最顶上两个数字，operStack的最顶上一个运算符进行运算，然后把运算结果再放到numStack的最顶端 
     * @param numStack  数字栈 
     * @param operStack 操作栈 
     */  
    private void compute(Stack<Integer> numStack, Stack<Operator> operStack) {  
        int num2 = numStack.pop(); // 弹出数字栈最顶上的数字作为运算的第二个数字  
        int num1 = numStack.pop(); // 弹出数字栈最顶上的数字作为运算的第一个数字  
        int computeResult = operStack.pop().compute(  
                num1, num2); // 弹出操作栈最顶上的运算符进行计算  
        numStack.push(computeResult); // 把计算结果重新放到队列的末端  
    }  
      
    /** 
     * 运算符 
     */  
    private enum Operator {  
        /** 
         * 加 
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
         * 减 
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
         * 乘 
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
         * 除 
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
		 * 平方
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
         * 括号 
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
         * 对应的优先级 
         * @return 
         */  
        public abstract int priority();  
  
        /** 
         * 计算两个数对应的运算结果 
         * @param num1  第一个运算数 
         * @param num2  第二个运算数 
         * @return 
         */  
        public abstract int compute(int num1, int num2);  
    }  
}  