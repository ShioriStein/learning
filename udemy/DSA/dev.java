package udemy.DSA;

import java.util.*;

public class dev {

    private static int countRun = 0;

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

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> returnList = new ArrayList<>();
        returnList.add(Arrays.asList(1));
        if (numRows == 1) {
            return returnList;
        }
        returnList.add(Arrays.asList(1, 1));
        for (int i = 2; i < numRows; i++) {
            List<Integer> prevList = returnList.get(i - 1);
            List<Integer> currentList = new ArrayList<>();
            currentList.add(1);
            for (int j = 1; j < i; j++) {
                int leftIndex = j - 1;
                int left = 0;
                int right = 0;
                if (leftIndex < 0) {
                    left = 0;
                } else {
                    left = prevList.get(leftIndex);
                }
                right = prevList.get(j);
                currentList.add(left + right);
            }
            currentList.add(1);
            returnList.add(currentList);
        }
        return returnList;
    }

    public static List<List<Integer>> generateV2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            int value = 1;
            for (int j = 0; j <= i; j++) {
                row.add(value);
                value = value * (i - j) / (j + 1);
            }
            result.add(row);
        }
        long a = 1;
        return result;
    }

    public static int totalRunOfNumBit = 0;

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int j = 1; j <= n; j++) {
            int hold = j;
            int currentTotalNum = 0;
            int i = -1;
            while (i != 0 && hold != 0) {
                if (result[hold] != 0) {
                    currentTotalNum += result[hold];
                    hold = 0;
                } else {
                    i = (int) (Math.log(hold) / Math.log(2));
                    hold = (int) (hold - Math.pow(2, i));
                    currentTotalNum++;
                }
                totalRunOfNumBit++;
            }
            result[j] = currentTotalNum;
        }

        return result;
    }

    public static boolean isSubsequence(String s, String t) {

        int i = 0;
        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            if (i >= s.length()) {
                return true;
            }
        }

        return false;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int hold = 0;
        int j = n - 1;
        if (m == 0) {
            while (j >= 0) {
                nums1[m + j] = nums2[j];
                j--;
            }
            return;
        }
        if (nums2.length == 0) {
            return;
        }
        for (int i = m - 1; j >= 0; ) {
            if (nums1[i] == 0) {
                hold = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = hold;
            }
            if (nums1[i] > nums2[j]) {
                hold = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = hold;
                i--;
            } else {
                i--;
            }
            if (i < 0) {
                i = m - 1;
                j--;
            }
        }
        j = 0;
        while (j < n) {
            nums1[m + j] = nums2[j];
            j++;
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> dupMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer dupIndex = dupMap.get(nums[i]);
            if (dupIndex != null) {
                if (Math.abs(i - dupIndex) <= k) {
                    return true;
                } else {
                    dupMap.put(nums[i], i);
                }
            } else {
                dupMap.put(nums[i], i);
            }
        }
        return false;
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] patternArray = pattern.split("");
        String[] sArray = s.split(" ");
        Map<String, String> mapWord = new HashMap<>();
        Map<String, String> mapPattern = new HashMap<>();
        if (patternArray.length != sArray.length) {
            return false;
        }

        for (int i = 0; i < patternArray.length; i++) {
            String currentWordMap = mapWord.get(sArray[i]);
            String currentPatternMap = mapPattern.get(patternArray[i]);
            if (currentWordMap == null ^ currentPatternMap == null) {
                return false;
            }
            if (currentWordMap != null) {
                if (!currentWordMap.equals(patternArray[i]) || !currentPatternMap.equals(sArray[i])) {
                    return false;
                }
            } else {
                mapWord.put(sArray[i], patternArray[i]);
                mapPattern.put(patternArray[i], sArray[i]);
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        int[] array = new int[3];
        for (int i = 0; i < s.length() - 1; i++) {
            for (int tail = tail = s.length() - 1; tail > i; tail--) {
                if (s.charAt(i) == s.charAt(tail)) {
                    int tempHead = i;
                    for (int j = tail; j > tempHead; ) {
                        if (s.charAt(tempHead) != s.charAt(j)) {
                            tempHead = s.length();
                        } else {
                            j--;
                            tempHead++;
                        }
                    }
                    if (tempHead != s.length() && tail - i > array[2]) {
                        array[0] = i;
                        array[1] = tail;
                        array[2] = tail - i;
                    }
                }
            }
        }
        return s.substring(array[0], array[1] + 1);
    }

    public static int findContentChildren(int[] g, int[] s) {
        Set<Integer> taken = new HashSet<>();
        for (int k : g) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < s.length; j++) {
                if (!taken.contains(j) && s[j] >= k && s[j] < minValue) {
                    minValue = s[j];
                    minIndex = j;
                }
            }
            if (minIndex != -1) {
                taken.add(minIndex);
            }
        }
        return taken.size();
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                result[0] = mid;
                result[1] = mid;
                break;
            } else if(nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        while(true) {
            if(nums[result[0] - 1] == target) {
                result[0]--;
            } else if(nums[result[1] + 1] == target) {
                result[1]++;
            } else {
                break;
            }
        }
        return result;
    }

    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int[] array = new int[3];
        int right = 0;
        int left = 0;
        int maxLength = 0;
        for(; right < nums.length; right++) {
            while((Math.abs(nums[right] - nums[left]) > 1 && left < right)) {
                left++;
            }
            maxLength = Math.max(array[0], right - left + 1);
            if(maxLength > array[0] && nums[left] != nums[right]) {
                array[0] = maxLength;
                array[1] = left;
                array[2] = right;
            }
        }
        return nums[array[1]] == nums[array[2]] ? 0 : maxLength;
    }

    public static double findMaxAverage(int[] nums, int k) {
        double avg = Integer.MIN_VALUE;
        int left = 0;
        int sum = 0;
        for(int right = 0 ; right < nums.length; right++) {
            sum += nums[right];
            while(right - left >= k) {
                sum -= nums[left];
                left++;
            }

            if(right - left == k - 1) {
                avg = Math.max(avg, sum / (double) k);
            }
        }
        return avg;
    }

    static List<String> lst = new ArrayList<>();
    static Map<String, List<String>> ml = new HashMap<>();
    public static List<String> letterCombinations(String digits) {
        ml.put("2", List.of("a","b","c"));
        ml.put("3", List.of("d","e","f"));
        ml.put("4", List.of("g","h","i"));
        ml.put("5", List.of("j","k","l"));
        ml.put("6", List.of("m","n","o"));
        ml.put("7", List.of("p","q","r", "s"));
        ml.put("8", List.of("t","u","v"));
        ml.put("9", List.of("w","y","z", "h"));

        String[] nums = digits.split("");

        if(!digits.isEmpty()) loop("", digits);

        return lst;
    }

    public static void loop(String parent, String currentRun) {
        if(!currentRun.isEmpty()) {
            String curr = currentRun.substring(0,1);
            List<String> currentLoop = ml.get(curr);
            for(String s : currentLoop) {
                String currLoop = parent + s;
                loop(currLoop, currentRun.substring(1));
            }
        } else {
            lst.add(parent);
        }
    }

    static List<Integer> heap = new ArrayList<>();
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.add(val);
//            if(pq.size() > k) {
//                pq.poll();
//            }
        }
        return pq.peek();
    }


    public static int nthUglyNumber(int n) {
        int current = 1;
        int count = 1;
        while(count < n) {
            current++;
            if(isUgly(current)) {
                count++;
            }
            countRun++;
        }
        return current;
    }


    private static boolean isUgly(int remain) {
        if(remain == 1) {
            return true;
        } else if(remain % 5 != 0 && remain % 3 != 0 && remain % 2 != 0) {
            return false;
        } else {
            if(remain % 5 == 0) {
                return isUgly(remain / 5);
            } else if(remain % 3 == 0) {
                return isUgly(remain / 3);
            } else {
                return isUgly(remain / 2);
            }
        }
    }


    private static int nUglyNums(int n) {
        int index2 = 0, index3 = 0, index5 = 0;
        int current2 = 2, current3 = 3, current5 = 5;

        int[] dp = new int[n];

        dp[0] = 1;

        int nNums = 0;

        for(int i = 1; i < n; i++) {
            nNums = Math.min(current2, Math.min(current3, current5));
            dp[i] = nNums;
            if(nNums == current2) {
                index2++;
                current2 = dp[index2] * 2;
            }

            if(nNums == current3) {
                index3++;
                current3 = dp[index3] * 3;
            }

            if(nNums == current5) {
                index5++;
                current5 = dp[index5] * 5;
            }
        }
        return nNums;
    }


    public static void main(String[] args) {
//        System.out.println(generateV2(5));
//        System.out.println(isSubsequence("axc", "ahbgdc"));
//        merge(new int[]{4,0,0,0,0,0}, 1, new int[]{1,2,3,5,6}, 5);
//        merge(new int[]{4,5,6,0,0,0}, 3, new int[]{1,2,3}, 3);
//        System.out.println(new dev().summaryRanges(nums));
//        System.out.println(containsNearbyDuplicate(new int[] {1,0,1,1}, 1));
//        System.out.println(wordPattern("abba", "dog cat cat dog"));

//        System.out.println(findContentChildren(g, s));

//        String[] arr = "asdas".split("");
//        String.join("", arr);

//        System.out.println(searchRange(new int[]{5,7,7,8,8,10}, 8));
//        System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));
//        System.out.println(findLHS(new int[]{1,2,3,4}));
//        System.out.println(findLHS(new int[]{1,1,1,1}));
//        System.out.println(findLHS(new int[]{1,4,1,3,1,-14,1,-13}));

//        findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);

//        letterCombinations("234");

        System.out.println(nUglyNums(1352));

    }
}
