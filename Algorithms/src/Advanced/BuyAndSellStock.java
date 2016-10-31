package Advanced;

public class BuyAndSellStock {

	public static int maxProfitBuySell(int[] arr){
		if(arr.length == 1) return 0;
		
		int maxProfit =0;
		int startIndex=0;
		for(int i =1;i< arr.length;i++){
			if(arr[i]<arr[i-1]){
				if((arr[i-1]-arr[startIndex])> maxProfit) maxProfit = arr[i-1]-arr[startIndex];
				startIndex=i;
			}
		}
		if((arr[arr.length-1]-arr[startIndex])>maxProfit) maxProfit = arr[arr.length-1]-arr[startIndex];
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 3, 10, 6, 4, 8, 1};
		System.out.println(BuyAndSellStock.maxProfitBuySell(arr));
	}

}
