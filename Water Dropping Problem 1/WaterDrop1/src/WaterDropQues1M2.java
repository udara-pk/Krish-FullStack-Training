import java.util.Arrays;
import java.util.Scanner;

public class WaterDropQues1M2 {
    public static void main(String[] args) {
        double inputValue = 100;
        double [] bucketArray = {0,0,0,0,0,0,0};
        int [][] pattern ={
                {0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0},
                {0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0},
                {1,1,1,0,0,1,0},
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0}
                };

        System.out.print("Enter the position:" );
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt() - 1;
        bucketArray[index] = inputValue;

        double [] currCalculated;

        for (int i = 0; i < pattern.length; i++) {
            int [] currentRow = pattern[i];
            double [] waterDivideValues;

            currCalculated = Arrays.copyOf(bucketArray, bucketArray.length);

            for (int j = 0; j < currentRow.length; j++) {
                if (currentRow[j] == 1 && bucketArray[j] > 0){
                    waterDivideValues = waterSupplier(currentRow.length, bucketArray[j], currentRow[j], j);

                    // check left
                    if (waterDivideValues[0] > 0){
                        currCalculated[j - 1] = currCalculated[j - 1] + waterDivideValues[0];
                    }

                    // check right
                    if (waterDivideValues[1] > 0){
                        currCalculated[j + 1] = currCalculated[j + 1] + waterDivideValues[1];
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