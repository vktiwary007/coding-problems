package com.vivekasu;

import java.util.PriorityQueue;

public class MedianFinder {


    public static void main(String[] args){

        MedianFinder obj = new MedianFinder();

        obj.addNum(40);
        System.out.println(obj.findMedian());
        obj.addNum(12);
        System.out.println(obj.findMedian());
        obj.addNum(16);
        System.out.println(obj.findMedian());
        obj.addNum(14);
        System.out.println(obj.findMedian());
        //obj.addNum(-5);
        //System.out.println(obj.findMedian());
    }

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>((a,b)->(b-a));
        maxHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {

        int minsize = minHeap.size();
        int maxsize = maxHeap.size();
        int diff = minsize - maxsize;
        if(minsize<1){
            minHeap.add(num);
        }
        else{

            if(diff==0){
                if(num>=maxHeap.peek()){
                    maxHeap.add(num);
                    minHeap.add(maxHeap.poll());
                }
                else{
                    minHeap.add(num);
                    maxHeap.add(minHeap.poll());
                }
            }
            else if(num>minHeap.peek() && diff > 0){
                maxHeap.add(num);
            }
            else if(num<=minHeap.peek() && diff > 0){
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
            else if(num>maxHeap.peek() && diff < 0){
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
            else{
                minHeap.add(num);
            }

        }


    }

    public double findMedian() {

        int minsize = minHeap.size();
        int maxsize = maxHeap.size();
        double ans = 0.0;
        if((minsize+maxsize)%2==0){
            ans = (minHeap.peek()+maxHeap.peek())/2.0;
        }
        else{
            if(minsize>maxsize){
                ans = minHeap.peek();
            }
            else
                ans = maxHeap.peek();
        }
        return ans;

    }
}
