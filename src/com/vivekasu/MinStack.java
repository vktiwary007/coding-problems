package com.vivekasu;

import java.util.Stack;

public class MinStack {


    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }

    /** initialize your data structure here. */
    private Stack<Integer> min;
    private Stack<Integer> stack;
    public MinStack() {
        min = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || min.peek()>=x){
            min.push(x);
        }

    }

    public void pop() {
        if(!stack.isEmpty()){
            if(stack.peek().compareTo(min.peek())==0){
                min.pop();
            }
            stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
