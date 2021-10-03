package com.Anurag;

import java.util.Stack;

public class checker {
	
	static Stack<Character> stack=new Stack<>();
	
	public static String check(String input) {
		
		for(int i= 0; i<input.length();i++) {

			if(input.charAt(i)=='{'|| input.charAt(i)=='(' || input.charAt(i)=='[') {
				stack.push(input.charAt(i));
			}
			else if(input.charAt(i)=='}') {
				if(stack.isEmpty()) {
					stack.push(input.charAt(i));
					break;
				}
				else if(stack.peek()=='{') {
					stack.pop();
				}
				else {
					break;
				}
				
			}
			
			else if(input.charAt(i)==')') {
				if(stack.isEmpty()) {
					stack.push(input.charAt(i));
					break;
				}
				else if(stack.peek()=='(') {
					stack.pop();
				}
				
				else {
					break;
				}
			}
			
			else if(input.charAt(i)==']') {
				if(stack.isEmpty()) {
					stack.push(input.charAt(i));
					break;
				}
				else if(stack.peek()=='[') {
					stack.pop();
				}
				else {
					break;
				}
			}
			
		}
		
		if(stack.isEmpty()) {
			//System.out.println("Balanced");
			return "Balanced";
		}
		
		else {
			//System.out.println("Not Balanced");
			String s="";

			for(Character ch:stack) {
				//System.out.println(ch);
				s=s.concat(ch+"\n");
			}
			s=s.concat("Not Balanced");
			return s;
		}
			
	}

}
