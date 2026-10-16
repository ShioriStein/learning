package udemy.DSA;

import java.util.*;

public class dev3 {

    int[][] matrix;

    public int uniquePaths(int m, int n) {
        matrix = new int[m + 1][n + 1];
        return run(1, 1, m, n);
    }

    public int run(int m, int n, int x, int y) {
        if (m == x || n == y) {
            return 1;
        }

        if (matrix[m][n] == 0) {
            matrix[m][n] = run(m + 1, n, x, y) + run(m, n + 1, x, y);
        }

        return matrix[m][n];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] check = new boolean[s.length() + 1];
        check[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (check[j] && wordSet.contains(s.substring(j, i))) {
                    check[i] = true;
                    break;
                }
            }
        }

        return check[s.length()];
    }

    private boolean checkWord(String[][] arr, int[] count, String word) {
        for (int i = 0; i < count[word.length()]; i++) {
            if (arr[word.length()][i].equals(word)) {
                return true;
            }
        }
        return false;
    }

    public int minPathSum(int[][] grid) {
        int maxX, maxY = 0;
        maxX = grid.length;
        maxY = grid[0].length;
        int[][] min = new int[maxX][maxY];
        for (int i = 0; i < maxX; i++) {
            Arrays.fill(min[i], -1);
        }

        return run(0, 0, maxX, maxY, min, grid);
    }

    private int run(int x, int y, int mX, int mY, int[][] min, int[][] grid) {
        if (x == mX || y == mY) {
            return Integer.MAX_VALUE;
        }

        if (x == mX - 1 && y == mY - 1) {
            return grid[x][y];
        }

        if (min[x][y] == -1) {
            min[x][y] = grid[x][y] + Math.min(run(x + 1, y, mX, mY, min, grid), run(x, y + 1, mX, mY, min, grid));
        }

        return min[x][y];
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            // While stack is not empty AND top of stack is less than the current element
            while (!stack.isEmpty() && stack.peekLast() <= nums2[i]) {
                // Pop the top element from the stack
                stack.pollLast();
            }

            if (!stack.isEmpty()) {
                hm.put(nums2[i], stack.peekLast());
            } else {
                hm.put(nums2[i], -1);
            }

            // Push the current element into the stack
            stack.offerLast(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hm.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }

    public int maxSubArray(int[] nums) {
        int currSub = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSub = Math.max(currSub, 0) + nums[i];
            max = Math.max(max, currSub);
        }
        return max;
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int max = 0;
        int numOdd = 0;

        for (var entry : map.entrySet()) {
            max += entry.getValue();
            if (entry.getValue() % 2 != 0) {
                numOdd++;
            }
        }

        return max - (numOdd - 1);
    }

    public int arrayPairSum(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int g1 = Math.min(nums[i], nums[j]);
                int g2 = Math.min(nums[i + 1], nums[j + 1]);
                max = Math.max(max, g1 + g2);
            }
        }
        return max;
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean noNewValue = false;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        while (!noNewValue) {
            noNewValue = true;
            for (int i = 0; i < rooms.size(); i++) {
                if (set.contains(i)) {
                    if (set.addAll(rooms.get(i))) {
                        noNewValue = false;
                    }
                }
            }
        }

        return set.size() == rooms.size();
    }

    public String addStack(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (var s : s1.toCharArray()) {
            st1.push(s);
        }

        for (var s : s2.toCharArray()) {
            st2.push(s);
        }

        Character temp = '0';

        int sum = 0;
        int carry = 0;

        while (!st1.isEmpty() && !st2.isEmpty()) {
            int b1 = st1.pop() - '0';
            int b2 = st2.pop() - '0';
            sum = b1 + b2 + carry;

            int newBit = sum % 2;
            carry = sum / 2;

            sb.append(newBit);
        }

        if (!st2.isEmpty() || !st1.isEmpty()) {
            var finalStack = st1.isEmpty() ? st2 : st1;
            while (!finalStack.isEmpty()) {
                int b1 = finalStack.pop() - '0';
                sum = b1 + carry;

                int newBit = sum % 2;
                carry = sum / 2;

                sb.append(newBit);
            }
        }

        if (carry > 0) {
            sb.append(carry);
        }


        return sb.reverse().toString();

    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb1 = new StringBuilder();
        int i = 0;
        int count = 0;
        while (i < strs.length) {
            count = 0;
            Character currC = strs[0].charAt(i);
            for (String s : strs) {
                if (i >= s.length() || !currC.equals(s.charAt(i))) {
                    return sb1.toString();
                }
                ;
                count++;
            }
            sb1.append(currC);
            i++;
        }
        return sb1.toString();
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int currentChar = columnNumber % 26;
            if (currentChar == 0) {
                sb.append('Z');
                columnNumber = (columnNumber / 26) - 1;
            } else {
                sb.append((char) ((currentChar - 1) + 'A'));
                columnNumber /= 26;
            }
        }

        return sb.reverse().toString();
    }

    public boolean isUgly(int n) {
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }
        return n == 1;
    }

    boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = (int) (((long) left + (long) right) / 2);
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1)) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 1;
    }

    boolean run(int numStone, boolean myTurn) {
        System.out.println(numStone + "-" + myTurn);
        if (numStone <= 3) {
            return myTurn;
        }

        return run(numStone - 1, !myTurn) || run(numStone - 2, !myTurn) || run(numStone - 3, !myTurn);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (var i : nums1) {
            map.compute(i, (k, v) -> v == null ? 1 : ++v);
        }
        for (var i : nums2) {
            if (map.containsKey(i)) {
                result.add(i);
                map.compute(i, (k, v) -> v == 1 ? null : --v);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int s1 = num1.length() - 1, s2 = num2.length() - 1, carry = 0;

        while (s1 >= 0 && s2 >= 0) {
            int var = num1.charAt(s1) - '0';
            int var2 = num2.charAt(s2) - '0';
            int sum = var + var2 + carry;

            sb.append(sum % 10);
            carry = sum / 10;

            s1--;
            s2--;
        }

        while (s1 >= 0) {
            int sum = num1.charAt(s1--) - '0' + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        while (s2 >= 0) {
            int sum = num2.charAt(s2--) - '0' + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) sb.append(carry);

        return sb.reverse().toString();
    }

    private int haveAdj(int[][] grid, int x, int y) {
        int numAdj = 0;
        if (x != 0 && grid[y][x - 1] == 1) {
            numAdj += 1;
        }
        if (y != 0 && grid[y - 1][x] == 1) {
            numAdj += 1;
        }
        return numAdj;
    }

    public int islandPerimeter(int[][] grid) {
        int totalPerimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    totalPerimeter = (totalPerimeter + 4) - (haveAdj(grid, j, i) * 2);
                }
            }
        }
        return totalPerimeter;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = nums[0];
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                max = Math.max(max, (i - left) + 1);
            } else {
                left = i + 1;
            }
        }
        return max;
    }

    int min = Integer.MIN_VALUE;

    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(min - target)) {
                    min = sum;
                }

                if (sum < target) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return min;
    }

    public int run(int[] nums, int target, int a, int b, int c) {
        if (a >= nums.length || b >= nums.length || c >= nums.length) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;

        min = Math.abs((nums[a] + nums[b] + nums[c]) - target);
        System.out.println(min);

//        min = Math.min(min, run(nums, target, a + 1, b, c));
        min = Math.min(min, run(nums, target, a, b + 1, c));
        min = Math.min(min, run(nums, target, a, b, c + 1));

        if (min == 0) {
            System.out.println("WTF WHY IT HAVE ZERO" + a + "" + b + "" + c);
        }

        return min;
    }

    public final List<List<Integer>> listCombination = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        run(candidates, new ArrayList<>(), 0, target);
        return listCombination;
    }

    public void run(int[] candidates, List<Integer> combines, int index, int sum) {
        if (sum == 0) {
            listCombination.add(new ArrayList<>(combines));
            return;
        }
        if (index >= candidates.length || sum < candidates[index]) {
            return;
        }

        run(candidates, combines, index + 1, sum);
        combines.add(candidates[index]);
        run(candidates, combines, index, sum - candidates[index]);
        combines.remove(combines.size() - 1);
    }

//    public final List<List<Integer>> listCombination = new ArrayList<>();
    public final Set<String> exist = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        run2(candidates, new ArrayList<>(), 0, target);
        return listCombination;
    }


    public void run2(int[] candidates, List<Integer> combines, int index, int sum) {
        if (sum == 0) {
            listCombination.add(new ArrayList<>(combines));
            return;
        }
        if (index >= candidates.length || sum < candidates[index]) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combines.add(candidates[i]);
            run2(candidates, combines, i + 1, sum - candidates[i]);
            combines.remove(combines.size() - 1);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode returnList = null;
        ListNode currentNode = null;
        int carryNum = 0;
        while(l1 != null || l2 != null || carryNum != 0) {
            int tempNum = carryNum;
            int val1 = 0;
            int val2 = 0;
            ListNode tempNode = new ListNode(0);
            if(l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            tempNum = tempNum + val1 + val2;
            tempNode.val  = tempNum % 10;
            carryNum = (tempNum - tempNode.val) / 10;

            if(currentNode != null) {
                currentNode.next = tempNode;
                currentNode = currentNode.next;
            } else {
                returnList = tempNode;
                currentNode = tempNode;
            }
        }

        return returnList;
    }

    public String multiply(String num1, String num2) {
        if (num2.equals("0") || num1.equals("0")) {
            return "0";
        }
        String sum = "0";
        StringBuilder factor = new StringBuilder();
            int carry = 0;
            List<String> list = new ArrayList<>();
        for(int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            var s2 = num2.charAt(i) - '0';
            for(int j = num1.length() - 1; j >= 0; j--) {
                var s1 = num1.charAt(j) - '0';
                var mul =  (s1 * s2) + carry;
                if (mul == 0) {
                    break;
                }
                sb.append(mul % 10);
                carry = mul / 10;
            }
            if (carry > 0) {
                sb.append(carry);
                carry = 0;
            }
            list.add(sb.reverse().toString());
        }
        for (int i = 0; i < list.size(); i++) {
            sum = addStrings(sum, list.get(i) + factor);
            factor.append("0");
        }
        return sum;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<>();
        int y = matrix.length, x = matrix[0].length;

        int[] directions = {0, 1, 0, -1, 0};
        boolean[][] visited = new boolean[y][x];
        int currentRow = 0, currentColumn = 0;
        int directionIndex = 0;
        while (lst.size() < (y * x)) {
            lst.add(matrix[currentRow][currentColumn]);
            visited[currentRow][currentColumn] = true;

            int nextRow = currentRow + directions[directionIndex];
            int nextColumn = currentColumn + directions[directionIndex + 1];

            if(nextRow < 0 || nextRow >= y
                    || nextColumn < 0 || nextColumn >= x || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            currentRow = currentRow + directions[directionIndex];
            currentColumn = currentColumn + directions[directionIndex + 1];
        }
        return lst;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        var test = new dev3();
        int[] nums = new int[3];

        Arrays.sort(nums);
        int[] arr = Arrays.stream(nums).boxed().sorted(Comparator.comparingDouble(a -> (double) a / 10)).mapToInt(Integer::intValue).toArray();
        Map<String, Integer> map =new HashMap<>();
        map.entrySet().stream().filter((e) -> e.getValue() != 0).map(Map.Entry::getKey).toList();

        Set<String> set = new HashSet<>();
        set.stream().toList();
        set.add

        nums = Arrays.stream(nums).boxed().sorted(Comparator.comparingDouble(a -> sumOfDigits((Integer) a) / sumOfDigits((Integer) a)).th(Integer::intValue).toArray();

        Arrays.sort(nums, (a, b) -> Double.compare( (double) a / 10, (double) b / 10));

        Map<Character, Integer> map = new HashMap<>();
        "asd".toCharArray();
        for (var c : "asd".toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int[] arr1 = {1, 1, 0, 1};

        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };


        System.out.println(test.spiralOrder(arr));

    }
}
