package com.Anurag;

import java.util.Iterator;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String name = "Anurag"; char temp; int count=1; for(int
		 * i=0;i<name.length();i++) { temp=name.charAt(i); if(temp==)
		 * }
		 */
		Stack<Character> stack= new Stack<>();
		
		
		String input = "{[((([{()}])))]}{}";
		String input1 = "public static void main(String[] args)";
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
			System.out.println("Balanced");
		}
		
		else {
			System.out.println("Not Balanced");
		}
		
		for(Character ch:stack) {
			System.out.println(ch);
		}

	}
}
