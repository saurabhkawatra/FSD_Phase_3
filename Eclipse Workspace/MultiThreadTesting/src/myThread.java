
public class myThread extends Thread {

	@Override
	public void run() {
		
		System.out.println("This is my thread which is running");
		System.out.println("Making this thread wait for 10 secs now");
		try {
			for(int i=1;i<=10;i++) {
				Thread.currentThread().sleep(1000);
				System.out.println("Custom Thread Counter :: "+i);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("Custom Thread timeout over!!!!");
		
	}
	
	

}
