package test;

public class ThreadTest implements Runnable{
	private final String message;
	private final long interval;
	public ThreadTest(String msg, long interval){
		this.message = msg;
		this.interval = interval;
	}
	public void run() {
		try {
			while (true){
				System.out.println(message);
				Thread.sleep(interval);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
