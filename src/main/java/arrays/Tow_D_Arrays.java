package arrays;

public class Tow_D_Arrays {

	public static void main(String[] args) {
		int i[][]= {{1,2,3,4,5,6},
				{5,6,7,8,9}};
		System.out.println("the no of rows for int array is:"+i.length);
		System.out.println("the no of cols for int array is:"+i[0].length);
		
		String str[][]=new String[3][4];
		str[0][0]= "HelloWorld";
		str[0][1]="Wellcome";
		str[0][2]="MyJava";
		str[0][3]="MySelenium";
		
		str[1][0]= "HelloWorld1";
		str[1][1]="Wellcome1";
		str[1][2]="MyJava1";
		str[1][3]="MySelenium1";
		
		str[2][0]= "HelloWorld2";
		str[2][1]="Wellcome2";
		str[2][2]="MyJava2";
		str[2][3]="MySelenium2";
		
		int rows = str.length;
		int cols= str[0].length;
		for(int rowNum = 0;rowNum<rows;rowNum++) {
			for(int colNum = 0;colNum<cols;colNum++) {
				System.out.print(str[rowNum][colNum]+ " ");
				
			}
			System.out.println();
		}
		
		
		}
				
	}


