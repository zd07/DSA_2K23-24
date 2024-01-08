package POD;

import java.util.ArrayList;
import java.util.List;

class ArrayInto2D {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] map = new int[nums.length + 1];
        for (int num : nums) {
            map[num]++;
        }
        List<List<Integer>> ans = new ArrayList();
        while(true) {
            List<Integer> list = new ArrayList();
            int j = 0;
            for (int i = 0; i < map.length; i++) {
                if (map[i] > 0) {
                    list.add(i);
                    map[i]--;
                } else {
                    j++;
                }
            }
            if (j == map.length) {
                break;
            }
            ans.add(new ArrayList(list));
        }
        return ans;
    }
}
