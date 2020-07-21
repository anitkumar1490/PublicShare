package com.anit.code1;

import java.util.*;

class ValidParenthesis {

    public static boolean isBalancedValid(String exp){
        if (exp.isEmpty())
            return true;
        Stack<Character> stack = new Stack<Character>();
        for(char c: exp.toCharArray()){
            if(c == '[' || c == '$'){
                stack.push(c);
            }else{
                if(stack.isEmpty())
                    return false;
                char tempFromStack = stack.peek();
                if(((c == ']' || c == '$')  && (tempFromStack == '[' || tempFromStack == '$'))){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            int count = 0;
            char temp = stack.peek();
            if((temp == '$' || temp == '[' || temp == ']') && count < 2){
                count++;
                return true;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Balanced Parantheses");
        System.out.println(isBalancedValid("[[]$"));
        System.out.println(isBalancedValid("[]"));
        System.out.println(isBalancedValid("[$]]"));
        System.out.println(isBalancedValid("$$"));
        System.out.println(isBalancedValid("[$]"));
        System.out.println(isBalancedValid("[[[$]]"));
        System.out.println(isBalancedValid("[[[$$$"));
        System.out.println(isBalancedValid("$$$]]"));
        System.out.println("Unbalanced Parantheses");
        System.out.println(isBalancedValid("]$["));

    }
}