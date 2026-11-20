package com.jpb;


class BuildThread extends Thread {
	
	private StringBuilder sb;
	
	BuildThread(StringBuilder aSb) {
		this.sb = aSb;
	}
	
	public StringBuilder getSb() {
		return this.sb;
	}
	
	public void run() {
		int count = 0;
		
		while (true) {
			try {
				this.sb.append("Thread#" + this.threadId() + "-" + count);
				count++;
				System.out.println("Thread#" + this.threadId() + ": " + this.sb);
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted");
				break;
			}
		}
	}
}


class BufferThread extends Thread {
	
	private StringBuffer sbf;
	
	BufferThread(StringBuffer aSbf) {
		this.sbf = aSbf;
	}
	
	public StringBuffer getSb() {
		return this.sbf;
	}
	
	public void run() {
		int count = 0;
		
		while (true) {
			try {
				this.sbf.append("Thread#" + this.threadId() + "-" + count);
				count++;
				System.out.println("Thread#" + this.threadId() + ": " + this.sbf);
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted");
				break;
			}
		}
	}
}



public class Q14 {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1000; i++) sb.append(i);
		
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < 1000; i++) sbf.append(i);
		
		System.out.println("StringBuilder: " + sb);
		System.out.println("\nStringBuffer: " + sbf);
		System.out.println("Equal: " + (sb.toString() == sbf.toString()));
		
		// StringBuffer is thread-safe because the same buffer can be written
		// and read by multiple threads at the same time.
		
//		System.out.println("\ncross-thread StringBuilder test");
//		
//		StringBuilder sb1 = new StringBuilder();
//		BuildThread t1 = new BuildThread(sb1);
//		BuildThread t2 = new BuildThread(sb1);
//		
//		// After a while, there are some missing iterations; i.e.,
//		// not all times t1, for example, is supposed to have added
//		// to sb1 does it actually reflect that in its print statement
//		t1.start();
//		t2.start();
		
		
		System.out.println("\ncross-thread Stringbuffer test:");
		
		StringBuffer sbf1 = new StringBuffer();
		BufferThread t1 = new BufferThread(sbf1);
		BufferThread t2 = new BufferThread(sbf1);
		
		// When these run, there are no missed strings.
		// Each thread's print statement coincides with an appended string.
		// like it's supposed to.
		t1.start();
		t2.start();
	}

}
