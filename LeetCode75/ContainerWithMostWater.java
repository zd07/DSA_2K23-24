package LeetCode75;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int x1=0;
        int x2=height.length-1;
        int maxWater=0;
        while(x1<x2){
            int width = x2 - x1;
            int minHeight=Math.min(height[x1],height[x2]);
            maxWater=Math.max(maxWater,minHeight * width);
            if(height[x1]<height[x2]){
                x1++;
            }
            else{
                x2--;
            }
        }
        return maxWater;
    }
}
