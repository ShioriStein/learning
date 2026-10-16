package leetcode;


public class DuppSortArray80 {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for(int i = 1; i < nums.length - count - 1;) {
            if(nums[i] == nums[i - 1] && nums[i] == nums[i + 1]) {
                moveToLast(nums,i);
                count++;
            } else {
                i++;
            }
        }
        return nums.length - count;
    }

    public int removeDuplicatesOptimal(int[] nums) {
        int j=2;
        for(int i=2;i<nums.length;i++){

            if(nums[i]!=nums[j-2]){
                nums[j++]=nums[i];
            }
        }
        return j;
    }

    public static void moveToLast(int[] arr, int pos) {
        if (arr == null || arr.length == 0) return;
        if (pos < 0 || pos >= arr.length) return;

        int temp = arr[pos];
        // Shift elements left from pos to second-last
        for (int i = pos; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        // Put saved element at the last index
        arr[arr.length - 1] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new DuppSortArray80().removeDuplicatesOptimal(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
