package leetcode;

public class SearchDupplicate81 {
    int[] nums;
    int target;

    public boolean search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int left = 0;
        int right = nums.length - 1;

        return run(left, right);
    }

    public boolean run(int left, int right) {
        if (left < 0 || right < left) {
            return false;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return true;
        } else if (nums[left] == nums[right]) {
            return run(left, mid - 1) || run(mid + 1, right);
        } else {
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return run(left, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SearchDupplicate81().search(new int[]{2,5,6,0,0,1,2}, 0));
    }
}
