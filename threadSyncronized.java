class counter {
    public int counter = 0;
    //synchronized make a method or variable thread safety
    //syncronized makes sure only one thread uses the method
    public synchronized void increment() {
        counter++;
    }
}

public class Main
{
	public static void main(String[] args) throws Exception {
		
		counter c1 = new counter();
		
		Thread t1 = new Thread(new Runnable() {
		    public void run() {
		        for(int i=0;i<1000;i++){
		            c1.increment();
		        }
		    }
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
		    public void run() {
		        for(int i=0;i<1000;i++){
		            c1.increment();
		        }
		    }
		});
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Count" + c1.counter);
	}
}

//Run using https://www.onlinegdb.com/online_java_compiler
