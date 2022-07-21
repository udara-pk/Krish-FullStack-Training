import java.util.Scanner;

public class WaterDropQues1 {

	public static void main(String[] args) {
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
		
		
    
		Scanner scanner=new Scanner(System.in);
		System.out.print("Please Enter Position for Water dropping:");
		int position=scanner.nextInt();
		
		
		
		int j=position-1;
		double portion=100;
		double result[]=new double[7];
		//right
		for(int i=0;i< waterPattern.length;i++) {
				for(int k=0;k<7;k++) {
					if(j==k && waterPattern[i][j]==0) {
						result[j]=portion;
						j=k;
						break;
					}else if(j==k && waterPattern[i][j]==1){
						//portion=portion/2;
						
						if(j != 6 && waterPattern[i][j+1]==0) {
							portion=portion/2;
							result[j]=portion;
							j=j+1;
							break;
						}else if(j != 6 && waterPattern[i][j+1]==1) {
							
							portion=portion/4;
							result[j]=portion;
							j=j+2;
							break;
						}else if(j == 6 && waterPattern[i][j]==1) {
							portion=0;
							result[j]=portion;
							break;
						}else {
							i=waterPattern.length;
						}
					}
					
				}
			}
		
		//left
		j=position-1;
		portion=100;
		for(int i=0;i< waterPattern.length;i++) {
			for(int k=0;k<7;k++) {
				if(j==k && waterPattern[i][j]==0) {
					result[j]=portion;
					j=k;
					break;
				}else if(j==k && waterPattern[i][j]==1){
					//portion=portion/2;
					
					if(j != 0 && waterPattern[i][j-1]==0) {
						portion=portion/2;
						result[j]=portion;
						j=j-11;
						break;
					}else if(j != 0 && waterPattern[i][j-1]==1) {
						
						portion=portion/4;
						result[j]=portion;
						j=j-2;
						break;
					}else if(j == 0 && waterPattern[i][j]==1) {
						portion=0;
						result[j]=portion;
						break;
					}else {
						i=waterPattern.length;
					}
				}
				
			}
		}
			
			
		
		
			
		System.out.println("Portion"+portion);
		for (double bucket : result) {
            System.out.print(bucket + ", ");
        }
		
		
	}
	

    

	

}
