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
		double [] currCalculated=new double []{0,0,0,0,0,0,0};
		double [] tempCalculated=new double [] {0,0,0,0,0,0,0};
		
        // print
        /*System.out.println("Result:");
        for (double bucket: bucketArray ) {
            System.out.print(bucket+ ", ");
        }*/	
		double percentage;
		
		for(int i=0; i< waterPattern.length;i++) {
			for(int j=0;j<bucketArray.length;j++) {
				if(bucketArray[j]>0) {
					percentage=bucketArray[j];
					if(waterPattern[i][j]==1) {
						//Turn Right
						for(int k=j;k<waterPattern.length;k++) {
							if(waterPattern[i][k]==0 && waterPattern[i-1][j+1]!=1) {
								currCalculated[k]=currCalculated[k]+percentage/2;
								currCalculated[j]=0;
								break;
							}
						}
						//Turn Left
						for(int k=j;k>=0;k--) {
							if(waterPattern[i][k]==0 && waterPattern[i-1][j-1]!=1) {
								currCalculated[k]=currCalculated[k]+percentage/2;
								currCalculated[j]=0;
								break;
							}
						}
						currCalculated[j]=0;
					}
					else {
						currCalculated[j]=percentage;
					}
				}
			}
			if(!Arrays.equals(tempCalculated,currCalculated)) {
				bucketArray=currCalculated;
				tempCalculated=currCalculated;
			}
			//bucketArray=currCalculated;
		}
		
		System.out.println("Result:");
        for (double bucket: bucketArray ) {
            System.out.print(bucket+ ", ");
        }
    }
	
	

    
	

}
