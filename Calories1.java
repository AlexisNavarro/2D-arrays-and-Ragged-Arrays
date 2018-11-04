//Author: Alexis Navarro
//Lab 2 
//Last modification: 9/18/18

//PURPOSE OF THE PROGRAM:
//To  be able to read a text file and use it in 2D arrays in order to  complete each task given like finding the largest number in the rows and columns of the 2D array
//also to be able to get the sum of each row and column in the 2D array and then get the average.

import java.io.*;
import java.util.Scanner;

public class Calories1{

//Method to find the sum of each row
	public static int[] sumCaloriesRow(int[][] a){
        int[] sum = new int[a.length];
        
		for(int r = 0; r < a.length; r++){
            sum[r]=0;
			for(int c = 0; c < a[r].length; c++){	
				sum[r]=sum[r]+a[r][c];
			}
		}
        return sum;
	}//end sumCalories
	
	
  //Method to find the average of each row
    public static double[] avgCaloriesRow(int[][] a){
        double[] average=new double[a.length];
        for(int r = 0; r < a.length; r++){
            double sum=0;
            for(int c = 0; c < a[r].length; c++){
                sum = sum+a[r][c];
            }
            average[r] = sum/a[r].length;
        }
        return average;
    }//end avgOfDay
    
	
	//Method to find the average calories of each column
    public static double[] avgCaloriesColumn(int[][] a){
        double[] average=new double[a[0].length];
			for(int c=0; c<a[0].length;c++){
                double sum=0;
				for(int r=0; r<a.length;r++){
				sum= sum+a[r][c];
			}
			average[c] = sum/a.length;
		}
        return average;
    }//end avgCaloriesColumn
    
	//Method to find the largest number of the row
    public static int[] maxCaloriesRow(int[][] a){
		int[] max = new int[a.length];
		for(int r = 0; r < a.length; r++){
			for(int c = 0; c <	 a[r].length; c++){
				if(a[r][c]>max[r])
				max[r]=a[r][c];	
			}
		}
		return max;
	}//end maxCaloriesRow
    
	
	//Method to find the largest number of each column
    public static void maxCaloriesColumn(int[][] a){
        String[] meal={"Breakfast","Lunch","Dinner"};
		for(int r = 0; r < a[0].length; r++){
            int max=a[0][r];
			for(int c = 0; c < a.length; c++){
				if(a[c][r]>max)
				max=a[c][r];	
                
			}
            System.out.println("\n"+meal[r]+" max calories are: "+max);
		}
	
	}//end maxCaloriesRow
    

	public static void main(String[] args) throws FileNotFoundException{
		Scanner s = null;  
        String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};  
        String[] meal={"Breakfast","Lunch","Dinner"};
			try{
				 s = new Scanner(new File("input1.txt")); 
				 int[][] mealArr = new int[7][3];
                 int r=0;
				 while(s.hasNextLine()){
				 
				 	String line = s.nextLine(); 
					System.out.println(line);
					String[] aSplit= line.split(" ");
					
					for(int i = 0; i <3; i++){
							mealArr[r][i] = Integer.parseInt(aSplit[i]);
					}
                     r++;
				 }//end while
                
				
                //calls method for the sumCaloriesRow for the total calories each day
                int[] caloriesOfDays=sumCaloriesRow(mealArr);
                System.out.println("\nThe sum of calories in each day is:");
                 for(int i=0; i<7; i++){
                    System.out.println(days[i]+" Calories: "+caloriesOfDays[i]);
                }//end for
                
				
                //calls the method to find the average calories of each day
                double[] avgRow=avgCaloriesRow(mealArr);
                System.out.println("\nThe average calories of each meal in a day is:");
                for(int i=0; i<7; i++){
                    System.out.println(days[i]+": "+avgRow[i]);
                }//end for
                
				
                //calls the method to find the average calories of each meal
                double[] avgCol=avgCaloriesColumn(mealArr);
                System.out.println("\nThe average calories of each meal is:");
                for(int i=0; i<3; i++){
                    System.out.println(meal[i]+": "+avgCol[i]);
                }//end for
             
			 //calls the method to find the largest number each day
                int[] maxCalInDays=maxCaloriesRow(mealArr);
                System.out.println("\nThe maximum number of  calories of each day is:");
                for(int i=0; i<7; i++){
                    System.out.println(days[i]+": "+maxCalInDays[i]);
                }//end for
                
			//calls the method to find the largest number each column	
                maxCaloriesColumn(mealArr);
                
			}catch(Exception e){
				e.printStackTrace();//prints the exceptions found
			}//end catch
	}//end main
	
}//end Calories