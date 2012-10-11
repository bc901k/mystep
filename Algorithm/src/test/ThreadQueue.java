package test;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadQueue {
	  private volatile static Queue<Integer> uniqueQueue;
	  private ThreadQueue() {}

	  public static synchronized Queue<Integer> getInstance(){
	    if(uniqueQueue==null){
	      synchronized(ThreadQueue.class){
	        if(uniqueQueue==null){
	        	uniqueQueue = new LinkedList<Integer>();
	        }
	      }
	    }
	    return uniqueQueue;
	  }
}
