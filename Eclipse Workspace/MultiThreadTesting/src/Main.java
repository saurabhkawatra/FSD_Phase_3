
public class Main {
	
	public static void main(String[] args) {
		
		myThread t1 = new myThread();
		
		
		t1.start();
		System.out.println("Making Main thread wait for 40 secs");
		try {
			for(int i=1;i<=40;i++) {
				Thread.currentThread().sleep(1000);
				System.out.println("Main Thread Counter :: "+i);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("Main Thread timeout over!!!!!");
		
		Thread t2=new Thread(()->{System.out.println("this is a new Annonymous Thread!!!");});
		
		t2.start();
		
		System.out.println("Main Thread ends now");
	}

}
