package Arrays;

import java.util.Arrays;

/*Rotate/Shift the elements of a square array clockwise by one at a time. (Not by 90 degrees, but by one element. Think of concentric circles)

Example:
1 2
3 4

Output:
3 1
4 2*/

public class MatrixRotation {
	
	public static int[][] rotateMatrix(int[][] arr){
		int rowCount = arr.length-1;
		int colCount = arr[0].length-1;
		
		// To find the number of rotations you need.
		int rotation = arr.length/2;
		
		for(int i =0;i <rotation;i++){
			
			for(int j=i;j<colCount-i;j++){	
				int temp = arr[i][j];
				arr[i][j] = arr[rowCount-i-j][i];
				arr[rowCount-i-j][i]=arr[rowCount-i][colCount-i-j];
				arr[rowCount-i][colCount-i-j]=arr[i+j][colCount-i];
				arr[i+j][colCount-i]=temp;
			}
		}
		
		return arr;
		
	}
	public static void main(String[] args) {
		int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] res = MatrixRotation.rotateMatrix(arr);
		System.out.println(Arrays.deepToString(res));
	}

}
