public class Solution {
    public int findSpecialInteger(int[] arr) {
        int count=0;
        for(int i=0 ; i<arr.length -1 ; i++){
            if(arr[i]==arr[i+1]){
                count++;
                int per = ((count+1)*100)/arr.length;
                
                if(per >= 25){
                    System.out.println(arr[i]);
                    return arr[i];
                }
            }
            else count = 0;
      
        }
        return arr[0];
    }
    public static void main(String[] args){
        Solution s1 = new Solution();
        int[] arr={1,2,2,6,6,6,6,7,10};
        s1.findSpecialInteger(arr);
    }
}
