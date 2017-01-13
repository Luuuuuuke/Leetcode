import java.util.*;public class DeleteDigits {	/**     *@param A: A positive integer which has N digits, A is a string.     *@param k: Remove k digits.     *@return: A string     */    public String DeleteDigits(String A, int k) {        // use stack, push digit in from start        // before add, condition to pop from stack:        // 1. stack is not empty; 2. cur <= top; 3. stack.size + left number > A.length - k        if(A == null || A.length() <= k){            return "";        }        int len = A.length() - k;        Deque<Character> stack = new ArrayDeque<Character>();        for(int i = 0; i < A.length(); i++){            char ch = A.charAt(i);            while(!stack.isEmpty() && ch < stack.peek() && stack.size() + A.length() - i > len){                stack.pop();            }            stack.push(ch);        }                while(stack.size() > len){            stack.pop();        }                StringBuilder sb = new StringBuilder();                while(!stack.isEmpty()){            sb.insert(0, stack.pop());        }        // delete leading 0s        while(sb.length() > 0 && sb.charAt(0) == '0'){            sb.deleteCharAt(0);        }        return sb.toString();    }}