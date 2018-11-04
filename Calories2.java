//Author: Alexis Navarro
//Lab 2 
//Last modification: 9/18/18

//PURPOSE OF THE PROGRAM:
//To  be able to read a text file and use it in a ragged array and successfully read it. Also this program will need to find the average of each row and column.
import java.io.*;
import java.util.Scanner;

public class Calories2{

    //method to print the average of calories consumed each day
    public static void printdailyAvg(int[][] a){
        String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}; 
            System.out.println("The average calories consumed each day are:");
            for(int r = 0; r < a.length; r++){
                double sum =0;
                for(int c = 0; c < a[r].length; c++){	
                    sum=sum+a[r][c];
                }
                double avg = sum/a[r].length;
                System.out.println(days[r]+" average calories are: "+avg);
            }
        System.out.println();
	}//end print row 
    
	
	//method to find the size of each row which will be used later when looking for the average of each column
    public static int lengthOfTheLongestRow(int[][] z){
	int maxLength =z[0].length;
		for(int i=1; i <z.length;i++){
			if(z[i].length>maxLength){
				maxLength = z[i].length;
			}
		}
		return maxLength;
	}//end  lengthOfTheLongestRow
    
	
	//Method used to find the average of each meal
     public static void printMealAvg(int[][] y){
            System.out.println("The average calories of each meal are:");
            int len =lengthOfTheLongestRow(y);
			int i=1;
            for(int c=0; c<len;c++){
						int counter=0;
						double sum=0;
						
			                for(int r=0; r<y.length;r++){
								if(c<y[r].length){
			                    sum=sum+y[r][c];
								counter++;
								}
              				 }	
				double avg= sum/counter;
				System.out.println("meal "+i+ " is "+ avg);
				i++;
            }//end for
}//end print row 
    
    
	public static void main(String[] args) throws FileNotFoundException{
        Scanner s = null;
        int[][] mealArr = new int[7][];
        
        try{
          s = new Scanner(new File("input2.txt")); 
            int counter=0;
		   while(s.hasNextLine()){
               String line = s.nextLine(); 
				String[] Split= line.split(" ");
               mealArr[counter]=new int[Split.length];
	               for(int i = 0; i <Split.length; i++){
								mealArr[counter][i] = Integer.parseInt(Split[i]);
						}
                     counter++;
           }//end while
		   
		   //calls the method printdailyAvg to find the average of each day
            printdailyAvg(mealArr);
			
			//calls the method printMealAvg to find the average of each meal
            printMealAvg(mealArr);
	}catch(Exception e){
            e.printStackTrace();
        }
    }//end main
}//end class