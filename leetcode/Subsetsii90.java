package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsetsii90 {
    List<List<Integer>> lst = new ArrayList<>();
    List<Integer> currentList = new ArrayList<>();
    boolean[] visited;
    int[] arr;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        arr = nums;
        run(0);
        return lst;
    }

    public void run(int currIndex) {
        if (currIndex == arr.length) {
            lst.add(new ArrayList<>(currentList));
            return;
        }


        //skip current value
        run(currIndex + 1);

        //if the previous item is same and not visted in this branch then skip
        //we make sure only the first dupplicate item get choose
        if(currIndex > 0 && currIndex < arr.length && arr[currIndex] == arr[currIndex - 1] && !visited[currIndex - 1]) {
            return;
        };
        //include current
        currentList.add(arr[currIndex]);
        visited[currIndex] = true;
        run(currIndex + 1);
        currentList.remove(currentList.size() - 1);
        visited[currIndex] = false;
    }

    public static void main(String[] args) {
        System.out.println(new Subsetsii90().subsetsWithDup(new int[]{1,1,4,4}));
    }
}
