package POD;

import java.util.Arrays;

public class ContainerVerticalArea {
    public int maxWidthOfVerticalArea(int[][] points) {
        int ans=0;
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        for(int i = 0 ; i < points.length -1;i++){
            //find difference of points and comapare with previous answer
            ans = Math.max(ans,Math.abs(points[i][0] - points[i+1][0]));
        }
        return ans;
    }
}
