package loop;

public class ForLoop1 {

	public static void main(String[] args) {
		for(int i=1;i<=10;i++) {
			System.out.println(i);
		}
		System.out.println("********************************");
      for(int j=20;j>=1;j--) {
	   System.out.println(j);
}
      System.out.println("************************");
      int sum = 0;
      for(int k=1;k<=100;k++) {
    	  sum = sum+k;
    	  
      }
      System.out.println("the sum of first 100 natural numbers is:"+sum);
	}
	

}
