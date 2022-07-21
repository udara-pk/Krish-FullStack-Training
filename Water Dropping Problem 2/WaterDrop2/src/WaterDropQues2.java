import java.util.Arrays;
import java.util.Scanner;

public class WaterDropQues2 {

	public static void main(String[] args) {
		double inputValue = 100;
        double [] bucketArray = {0,0,0,0,0,0,0};
		// TODO Auto-generated method stub
		int[][] waterPattern =  {
				{ 0, 0, 0, 0, 0, 0, 0 },
	            { 1, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 1, 1, 1, 0, 0 },
	            { 0, 0, 0, 0, 0, 0, 0 },
	            { 1, 1, 1, 0, 0, 1, 0 },
	            { 0, 0, 0, 0, 0, 0, 1 },
	            { 0, 0, 0, 0, 0, 0, 0 },
			};



		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter Position for Water dropping:");
		int position=sc.nextInt() - 1;//possition=3
		bucketArray[position] = inputValue;//{ 0, 0, 0, 100, 0, 0, 0 }
		double [] currCalculated;
		
		for (int i = 0; i < waterPattern.length; i++) {
            int [] currentRow = waterPattern[i];
            int [] nextRow = waterPattern[i+1];
            double [] waterDivideValues;

            currCalculated = Arrays.copyOf(bucketArray, bucketArray.length);//{ 0, 0, 0, 100, 0, 0, 0 }

            for (int j = position; j < currentRow.length; j++) {
                if (nextRow[j] == 1 && bucketArray[j] > 0){
                    waterDivideValues = waterSupplier(currentRow.length, bucketArray[j], currentRow[j], j);

                    // check right
                    if (waterDivideValues[1] > 0){
                        currCalculated[j + 1] = currCalculated[j + 1] + waterDivideValues[1];
                    }
                    currCalculated[j] = 0;
                }
                
            }
            
            for (int j = position; j <= 0; j--) {
                if (nextRow[j] == 1 && bucketArray[j] > 0){
                    waterDivideValues = waterSupplier(currentRow.length, bucketArray[j], currentRow[j], j);

                    // check left
                    if (waterDivideValues[0] > 0){
                        currCalculated[j - 1] = currCalculated[j - 1] + waterDivideValues[0];
                    }

                    
                    currCalculated[j] = 0;
                }
                
            }
            
            // update basket array
            bucketArray = currCalculated;
            
        }

        // print
        System.out.println("Result:");
        for (double bucket: bucketArray ) {
            System.out.print(bucket+ ", ");
        }
    }

    public static double[] waterSupplier(int colCount,double inputValue, int bucketValue, int bucketColIndex){
        double [] waterDivideValues = {0,0};
        if (bucketValue == 1){
            // split now
            if(bucketColIndex == 0){
                waterDivideValues[1]  = inputValue / 2;
            }
            else if (bucketColIndex == colCount - 1){
                waterDivideValues[0]  = inputValue / 2;
            }else{
                waterDivideValues[0] = inputValue / 2;
                waterDivideValues[1] = inputValue / 2;
            }
        }
        return waterDivideValues;
    }
	

}
