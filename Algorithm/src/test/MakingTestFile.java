package test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class MakingTestFile {
	
//	@Test
	public void numberRead(){
		try {
			File file = new File("numberSample.txt");
			String str = FileUtils.readFileToString(file);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void numberGenerate(){
		Random randomGenerator = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(randomGenerator.nextInt(10000)).append(" ");
		}
		try {
			File file = new File("numberSample.txt");
			FileUtils.writeStringToFile(file, sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void binarySearching(){ 
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean again = true;
		while(again){
			System.out.println("--------------------------------------------------");
			System.out.println("input your number between 0 and 1000000");
			System.out.println("--------------------------------------------------");
			double target = scan.nextDouble();
			double listSize = 100000.0;
			double half 	= 0.0;
			double max 	= listSize;
			boolean chk = true;
			int count		= 1;
			while(chk){
				half = (double) Math.ceil(max/2);
				System.out.println("target: "+target+"       Half: "+half+"      realNumber: "+(max/2));
				if (half == target) {
					chk = false;
				} else {
					if(half < target) {
						max = max + (double) Math.ceil(listSize/(Math.pow(2,count)));
					} else {
						max = max - (double) Math.ceil(listSize/(Math.pow(2,count))); 
					}
					count++;
				}
				if (count>=listSize) chk = false;
				if (max/2>listSize) max = (double) Math.ceil(listSize*2);
				System.out.println("max: "+max);
			}
			System.out.println(count);	
			System.out.println("--------------------------------------------------");
			System.out.println("test again? (y/n)");
			System.out.println("--------------------------------------------------");
			if(scan.next().equalsIgnoreCase("n")) again = false;
		}
	}
	
	public Queue<Integer> queueTest() {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(1);
		que.add(2);
		que.add(3);
		
		return que;
	}
	
//	@Test
	public void showQueue() {
		Queue<Integer> queueValue = queueTest();
		int queueSize = queueValue.size();
		System.out.println("Befor polling Queue size: " + queueTest().size() );
		for (int i = 0; i < queueSize; i++) {
			System.out.println(i+"th Queue: "+queueValue.poll());
		}
		System.out.println("After polling Queue size: " + queueSize );
	}
	
	Runnable r1 = new Runnable() {
		
		@Override
		public void run() {
			try {
				int cnt = 0;
				boolean flg = true;
				while (true) {
					System.out.println("hello");
					Thread.sleep(1000L);
					if (cnt > 10) flg = false;
					cnt ++;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	};
	
	Runnable r2 = new Runnable() {
		
		@Override
		public void run() {
			try {
				int cnt = 0;
				boolean flg = true;
				while (true) {
					System.out.println("Bye");
					Thread.sleep(2000L);
					if (cnt > 10) flg = false;
					cnt++;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	};
	
//	@Test
	public void threadTest() throws InterruptedException {
		Thread thr1 = new Thread(r1);
		Thread thr2 = new Thread(r2);
		thr1.start();
		thr2.start();
		Thread.sleep(10000L);
	}
	
//	@Test
	public void threadConstructorTest() throws InterruptedException {
		Runnable r = new ThreadTest("Hello sydney", 1000L);
		Thread thr = new Thread(r);
		thr.start();
		Thread.sleep(10000L);
	}
	
//	@Test
	public void threadOverrideTest() throws InterruptedException {
		Runnable r = new ThreadTest("Hello sydney?", 1000L);
		runTask(r, true);
		Thread.sleep(10000L);
	}
	
	public void runTask(Runnable r, boolean separateThread){
		if (separateThread){
			(new Thread(r)).start();
		} else {
			r.run();
		}
	}
	

	private long x=System.nanoTime();

	public synchronized long randomNumber() {
		x ^= (x << 21);
		x ^= (x >>> 35);
		x ^= (x << 4);
		return x;
	}
	
	private final CountDownLatch startLatch;
	
	public MakingTestFile (CountDownLatch startLatch) {
		this.startLatch = startLatch;
	}
	
	
	Runnable r3 = new Runnable() {
		
		@Override
		public void run() {
			Random randomGenerator = new Random();
			long interval = 1000L;
			try {
				while (true) {
					ThreadQueue.getInstance().add(randomGenerator.nextInt(10000));
					interval = randomGenerator.nextInt(1000);
					//System.out.println("que: "+ThreadQueue.getInstance().toString()+"         interval: "+interval+"     ThreadName: "+Thread.currentThread().toString());
					Thread.sleep(interval);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	};
	
	Runnable r4 = new Runnable() {
		
		@Override
		public void run() {
			List<String> list = new ArrayList<String>();
			try {
				while (true) {
					if(!ThreadQueue.getInstance().isEmpty()) {
						list.add(ThreadQueue.getInstance().poll().toString());
						list.add(Thread.currentThread().toString());
						DBTest insert = new DBTest();
						insert.dbInsertPolledData(list);
						//System.out.println("polledValue: "+list.toString()+"     ThreadName: "+Thread.currentThread().toString()+"     time: "+x);
						list.clear();
					}
					Thread.sleep(2000L);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	};
	
	Runnable r5 = new Runnable() {
		
		@Override
		public void run() {
			List<String> list = new ArrayList<String>();
			try {
				while (true) {
					if(!ThreadQueue.getInstance().isEmpty()) {
						list.add(ThreadQueue.getInstance().poll().toString());
						list.add(Thread.currentThread().toString());
						DBTest insert = new DBTest();
						insert.dbInsertPolledData(list);
						//System.out.println("polledValue: "+list.toString()+"     ThreadName: "+Thread.currentThread().toString()+"     time: "+x);
						list.clear();
					}
					Thread.sleep(2000L);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	};
	
	Runnable r6 = new Runnable() {
		
		@Override
		public void run() {
			List<String> list = new ArrayList<String>();
			try {
				while (true) {
					if(!ThreadQueue.getInstance().isEmpty()) {
						list.add(ThreadQueue.getInstance().poll().toString());
						list.add(Thread.currentThread().toString());
						DBTest insert = new DBTest();
						insert.dbInsertPolledData(list);
						//System.out.println("polledValue: "+list.toString()+"     ThreadName: "+Thread.currentThread().toString()+"     time: "+x);
						list.clear();
					}
					Thread.sleep(2000L);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	};
	
	@Test
	public void queueGenerator() throws InterruptedException {
		Thread thrGenerator = new Thread(r3);
		thrGenerator.start();
		Thread thrPoller01 = new Thread(r4);
		thrPoller01.start();
		Thread.sleep(300L);
		Thread thrPoller02 = new Thread(r5);
		thrPoller02.start();
		Thread.sleep(300L);
		Thread thrPoller03 = new Thread(r6);
		thrPoller03.start();
		Thread.sleep(600000L);
		Thread.interrupted();
	}
	
	//mysql root//'' and test//'1234'
	//http://javamex.com/tutorials/threads/CountDownLatch.shtml
	
	
}
