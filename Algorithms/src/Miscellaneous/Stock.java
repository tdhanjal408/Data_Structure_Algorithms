package Miscellaneous;


// The cost of a stock on each day is given in an array, find the max profit that you can make by buying and 
// selling in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the
// maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. 
// If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.

// {100, 180, 260, 310, 40, 535, 695}

public class Stock {

	public static int getStockProfit(int[] arr){
		if(arr==null || arr.length<2) return 0;
		int profit=0;
		int index;
		int buyIndex=0,soldIndex=0;
		
		for(int i =0;i<arr.length-1;i++){
			index=i;
			while(index< arr.length-1 && arr[index]>arr[index+1]){
				index++;
			}
			
			if(index==arr.length-1) return profit;
			buyIndex=index;
			
			while(index< arr.length-1 && arr[index]<arr[index+1]){
				index++;
			}
			soldIndex= index;
			System.out.println("buy :" + buyIndex + " sold:" + soldIndex);
			profit+= arr[soldIndex]-arr[buyIndex];
			buyIndex=0;
			soldIndex=0;
			i=index;
		}
		
		if(buyIndex!=0) profit+= arr[arr.length-1]-arr[buyIndex];
		
		return profit;
	}
	
	
	public static void main(String[] args) {
		int[] input = {100,70,20};
		System.out.println(Stock.getStockProfit(input));
	}

}
