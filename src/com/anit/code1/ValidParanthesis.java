package com.anit.code1;

import java.util.*;

class ValidParenthesis {

    public static boolean isBalancedValid(String exp){
        List<Character> stack = new ArrayList<>();
        for(char c: exp.toCharArray()){
            if(c == '[' || c == '$'){
                stack.add(0,c);
            }else{
                if(stack.isEmpty())
                    return false;
                char tempFromStack = stack.get(0);
                if(((c == ']' || c == '$')  && (tempFromStack == '[' || tempFromStack == '$'))){
                    stack.remove(0);
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            int count = 0;
            char temp = stack.get(0);
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