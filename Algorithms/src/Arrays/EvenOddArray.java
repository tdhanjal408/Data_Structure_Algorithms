package Arrays;

import java.util.Arrays;


/*Given an array of numbers, Rearrange the numbers to make the even and odd numbers alternate. 
If any one type is in excess, let it come in the end. 
*/
public class EvenOddArray {

	public static int[] alternateEvenOdd(int[] arr){
		if(arr.length ==0  || arr.length == 1) return arr;
		int finder = arr.length-1;
		
		for(int i =1;i<arr.length;i++){
		    finder = arr.length-1;
			if(arr[i-1]%2 == 1){
				if(arr[i]%2 ==0) continue;
				while(finder>i && arr[finder]%2==1){
					finder--;
				}
				if(finder>i){
					int temp = arr[i];
					arr[i]= arr[finder];
					arr[finder]=temp;
				}
			}else{
				if(arr[i]%2 ==1) continue;
				while(finder>i && arr[finder]%2==0){
					finder--;
				}
				if(finder>i){
					int temp = arr[i];
					arr[i]= arr[finder];
					arr[finder]=temp;
				}	
			}
			
			if(finder < i) break;
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = {2, 3, 10, 6, 4, 8, 1};
		EvenOddArray.alternateEvenOdd(arr);
		System.out.println(Arrays.toString(arr));

	}

}
