package udemy.DSA;

import java.util.*;

public class dev {

    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderHelper(this.root, result);
        return result;
    }

    private void inorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.value);
        inorderHelper(node.right, result);
    }


    public List<String> summaryRanges(int[] nums) {
        List<String> returnList = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != end) {
                end--;
                returnList.add(start != end ? start + "->" + end : String.valueOf(start));
                start = nums[i];
                end = nums[i] + 1;
            } else {
                end++;
            }
        }
        end--;
        returnList.add(start != end ? start + "->" + end : String.valueOf(start));
        return returnList;
    }

    public void sortedArrayToBST(int[] nums) {
        this.root = sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private Node sortedArrayToBST(int[] nums, int left, int right) {
        int middleIndex = ((right - left) / 2) + left;
        if (right < 0 || left >= right || nums.length == 0) {
            return null;
        }
        Node newNode = new Node(nums[middleIndex]);
        if (right - left > 1) {
            newNode.left = sortedArrayToBST(nums, left, middleIndex - 1);
            newNode.right = sortedArrayToBST(nums, middleIndex + 1, right);
        }

        return newNode;

    }

    public int[] plusOne(int[] digits) {
        int spare = 0;
        int i = digits.length - 1;
        while (i >= 0) {
            int currentValue = digits[i] + 1 + spare;
            digits[i] = currentValue % 10;
            if (currentValue > 9) {
                spare = currentValue / 10;
                if (i == 0) {
                    int[] oldDitgits = digits;
                    digits = new int[digits.length + 1];
                    System.arraycopy(oldDitgits, 0, digits, 1, oldDitgits.length);
                    i = -1;
                } else {
                    i--;
                }
            } else {
                i = -1;
            }

        }
        return digits;
    }

    public boolean isPalindrome(String s) {
        String newString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int i = 0;
        while (i <= (newString.length() - 1) - i) {
            if (newString.charAt(i) != newString.charAt(newString.length() - 1 - i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> sortArray = Arrays.stream(nums)        // Convert int[] to IntStream
                .boxed()
                .sorted()// Box each int to Integer
                .toList();
        Set<List<Integer>> set = new HashSet<>();
        int k = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < sortArray.size(); i++) {
            int left = i + 1;
            int right = sortArray.size() - 1;
            while (left < right) {
                int currentSum = sortArray.get(i) + sortArray.get(left) + sortArray.get(right);
                if (currentSum == 0) {
                    var setOfInteger = Arrays.asList(sortArray.get(i), sortArray.get(left), sortArray.get(right));
                    Collections.sort(setOfInteger);
                    if (set.add(setOfInteger)) {
                        list.add(setOfInteger);
                    }
                    left++;
                    right--;
                } else if (currentSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
        Map<String,String> map = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        list.pol
        map.containsKey()
//        System.out.println(new dev().summaryRanges(nums));

    }
}
