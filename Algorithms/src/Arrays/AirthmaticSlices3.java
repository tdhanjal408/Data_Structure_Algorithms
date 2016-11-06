package Arrays;

//https://leetcode.com/contest/12/problems/arithmetic-slices-ii-subsequence/
public class AirthmaticSlices3 {
    int sliceCount = 0;    
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return sliceCount;
        if(A.length == 3 && (A[2]-A[1]!=A[1]-A[0])) return sliceCount;
        for(int i = 0 ;i < A.length-2;i++){
            helper(A,1,i);
        }
        return sliceCount;
    }
    
    public void helper(int[] nums ,int jump,int index){
        if(jump >= nums.length) return;
        int count =0;
        for(int i =index;i<nums.length;i=i+jump){
            count++;
            if(count >=3) sliceCount++;
        }
        helper(nums,jump+1,index);
    }
}
