package yuan.study.demo.service.subjectService.impl;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import yuan.study.demo.entity.ListNode;
import yuan.study.demo.service.subjectService.SubjectService;

import java.util.*;


@Slf4j
@Service
public class SubjectServiceImpl implements SubjectService {

    @Override
    public void subjectTest(){
        twoSum(new int[]{3,2,4}, 6);
    }
    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    @Override
    public void addTwoNumbers(){
        ListNode l12 = new ListNode(1, null);
        ListNode l11 = new ListNode(9, l12);
        ListNode l1 = new ListNode(9, l11);

        ListNode l22 = new ListNode(5, null);
        ListNode l21 = new ListNode(6, l22);
        ListNode l2 = new ListNode(1, l21);

        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.print("[");
        for(;;){
            System.out.print(l3.val);
            if(l3.next == null){
                break;
            }
            l3 = l3.next;
            System.out.print(",");
        }
        System.out.print("]");
    }
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addListNode(l1, l2, 0);
    }
    private ListNode addListNode(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null){
            return carry > 0 ? new ListNode(carry, null) : null;
        }else if(l1 == null){
            return new ListNode((l2.val + carry) % 10, (l2.val + carry) / 10 == 0 ? l2.next : addListNode(null, l2.next, (l2.val + carry) / 10));
        }else if(l2 == null){
            return new ListNode((l1.val + carry) % 10, (l1.val + carry) / 10 == 0 ? l1.next : addListNode(l1.next, null, (l1.val + carry) / 10));
        }else{
            return new ListNode((l1.val + l2.val + carry) % 10, addListNode(l1.next, l2.next, (l1.val + l2.val + carry) / 10));
        }
    }

    @Override
    public void longestSubstringWithoutRepeatedCharacters(){
        lengthOfLongestSubstring("dvdf");
    }
    /**
     * 滑动窗口的解析思路
     */
    private int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128] ;
        for (int j = 0, i = 0; j < n; j++) {
            //当前字符上次出现的位置, 或者为i, 如果没有重复过则固定为0
            i = index[s.charAt(j)] > i ? index[s.charAt(j)] : i;
            //取最长的长度覆盖至ans值中, 要么是j的值, 要么是ans的值, 加一是用于保证为空时也能取到值1
            ans = ans > j - i + 1 ? ans : j - i + 1;
            //赋值 index[当前ascell码值] = 第X个元素(从1开始, 用于保证为空时也能取到值1)
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    @Override
    public void queryPositiveArrayMedian(){
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(findMedianSortedArrays1(new int[]{1,2}, new int[]{3,4}));
    }
    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[]nums3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums3, 0, nums1.length);
        System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
        Arrays.sort(nums3);
        return nums3.length % 2 == 0 ? (double)(nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2 : nums3[nums3.length / 2];
    }
    /**
     * 高级算法
     */
    private double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            //保证nums1是较长的数组
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int min = 0, max = m, halfLen = (m + n + 1) / 2;
        int i, j, maxLeft, minRight;
        while (min <= max) {
            i = (min + max) / 2;
            j = halfLen - i;
            if (i < max && nums2[j - 1] > nums1[i]){
                min = i + 1; // i is too small
            } else if (i > min && nums1[i - 1] > nums2[j]) {
                max = i - 1; // i is too big
            } else { // i is perfect
                if (i == 0) {
                    // nums1最小的比nums2最大的值还大
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    // nums1最大的比nums2最小的值还小
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ( (m + n) % 2 == 1 ) {
                    return maxLeft;
                }
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    @Override
    public void getTheLongestPalindromeString(){
        System.out.println(longestPalindrome("addc"));
        System.out.println(longestPalindrome1("babad"));
    }

    private String longestPalindrome(String s) {
        int left = 0, right = 0, left1, right1;
        String str = addBoundaries(s, '#');
        for(int i = 0; i < str.length(); i++){
            left1 = i % 2 == 1 ? i - 1 : i;
            right1 = i % 2 == 1 ? i + 1 : i;
            while(left1 - 1 >= 0 && right1 + 1 < str.length() && str.charAt(left1 - 1) == str.charAt(right1 + 1)){
                left1--;
                right1++;
            }
            if(right1 != i && right1 - left1 > right - left){
                left = left1;
                right = right1;
            }
        }
        return right - left == 0 ? s.substring(0, 1) : s.substring(left / 2, right / 2);
    }

    /**
     * 创建预处理字符串
     * @param s      原始字符串
     * @param divide 分隔字符
     * @return 使用分隔字符处理以后得到的字符串
     */
    private String addBoundaries(String s, char divide) {
        //可以在此判断下是否包含divide, 包含则放弃
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(divide);
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append(divide);
        return stringBuilder.toString();
    }

    /**
     * Manacher算法实现
     */
    public String longestPalindrome1(String s) {
        // 特判
        if (s.length() < 2) {
            return s;
        }

        // 得到预处理字符串
        String str = addBoundaries(s, '#');
        // 新字符串的长度
        int sLen = 2 * s.length() + 1;

        // 数组 p 记录了扫描过的回文子串的信息
        int[] p = new int[str.length()];

        // 双指针，它们是一一对应的，须同时更新
        int maxRight = 0;
        int center = 0;

        // 当前遍历的中心最大扩散步数，其值等于原始字符串的最长回文子串的长度
        int maxLen = 1;
        // 原始字符串的最长回文子串的起始位置，与 maxLen 必须同时更新
        int start = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i < maxRight) {
                int mirror = 2 * center - i;
                // 这一行代码是 Manacher 算法的关键所在，要结合图形来理解
                // 由回文串的定义可知，一个回文串反过来还是一个回文串，所以以i为中心的回文串的长度至少和以mirror为中心的回文串一样
                p[i] = Math.min(maxRight - i, p[mirror]);
            }

            // 下一次尝试扩散的左右起点，能扩散的步数直接加到 p[i] 中
            int left = i - (1 + p[i]);
            int right = i + (1 + p[i]);

            // left >= 0 && right < sLen 保证不越界
            // str.charAt(left) == str.charAt(right) 表示可以扩散 1 次
            while (left >= 0 && right < sLen && str.charAt(left) == str.charAt(right)) {
                p[i]++;
                left--;
                right++;

            }
            // 根据 maxRight 的定义，它是遍历过的 i 的 i + p[i] 的最大者
            // 如果 maxRight 的值越大，进入上面 i < maxRight 的判断的可能性就越大，这样就可以重复利用之前判断过的回文信息了
            if (i + p[i] > maxRight) {
                // maxRight 和 center 需要同时更新
                maxRight = i + p[i];
                center = i;
            }
            if (p[i] > maxLen) {
                // 记录最长回文子串的长度和相应它在原始字符串中的起点
                maxLen = p[i];
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    @Override
    public void zigzagTransformation(){
        convert("PAYPALISHIRING", 4);
    }

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int charIndex = 0;
        char[] chars = new char[s.length()];
        for(int i = 0; i < numRows; i++){
            for(int j = i; j < s.length();){
                chars[charIndex++] = s.charAt(j);
                j = j + ((i == numRows - 1) ? 2 * numRows - 2 : (i == 0 || j / (numRows - 1) % 2 == 0 ? 2 * numRows - 2 - 2 * i : 2 * i));
            }
        }
        return new String(chars);
    }

    @Override
    public void integerInversion(){
        System.out.println(reverse(1534236469));
    }

    public int reverse(int x) {
        long result = 0;
        while (x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }

    @Override
    public void convertStringNumber(){
        System.out.println(myAtoi("words and 987"));
    }

    public int myAtoi(String s) {
        char[] charArr = new char[s.length()];
        int j = 0;
        char a;
        for(int i = 0; i < s.length(); i++){
            a = s.charAt(i);
            if((a >= '0' && a <= '9') || a == '-'){
                charArr[j++] = a;
            }
        }
        return Integer.valueOf(String.valueOf(Arrays.copyOf(charArr, j)));
    }

    @Override
    public void palindromeNumber(){
        System.out.println(isPalindrome(12322));
        System.out.println(isPalindrome1(12322));
    }

    /**
     * 将数字反序排序, 如果是回文一定和原值相同
     */
    public boolean isPalindrome1(int x) {
        if(x < 0)
            return false;
        int y = 0;
        int quo = x;
        while(quo != 0){
            y = y * 10 + quo % 10;
            quo = quo / 10;
        }
        return y == x;
    }

    /**
     * 头尾对比
     */
    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        int mid = (xStr.length() + 1) / 2;
        for(int i = 0; i < mid; i++){
            if(xStr.charAt(i) != xStr.charAt(xStr.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void regularExpressionMatching(){
        System.out.println(isMatch("aaa", "baa"));//.*
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] booleanArr = new boolean[m + 1][n + 1];
        booleanArr[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    booleanArr[i][j] = booleanArr[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        booleanArr[i][j] = booleanArr[i][j] || booleanArr[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        booleanArr[i][j] = booleanArr[i - 1][j - 1];
                    }
                }
            }
        }
        return booleanArr[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    @Override
    public void holdMostWater(){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int maxValue = 0;
        int left = 0, right = height.length - 1, area;
        // 当两个指针没有重合时
        while (left < right) {
            area = (height[left] < height[right] ? height[left] : height[right]) * (right - left);
            if(maxValue < area){
                maxValue = area;
            }
            // 那个值小就挪动那个指针
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxValue;
    }

    @Override
    public void intToRoman(){
        System.out.println(intToRoman(1998));
    }

    public String intToRoman(int num) {
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String reps[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 13; i++){
            while(num >= values[i]){
                num -= values[i];
                res.append(reps[i]);
            }
        }
        return res.toString();
    }

    @Override
    public void romanToInt(){
        System.out.println(romanToInt("IX"));
    }

    public int romanToInt(String s) {
        char reps[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int values[] = {1000, 500, 100,  50, 10,   5,   1};
        int value = 0;
        for(int i = 0; i < s.length(); i++){
           for(int j = 0; j < reps.length; j++){
               if(s.charAt(i) == reps[j]){
                   if((i + 1 < s.length() && j >= 1 && s.charAt(i + 1) == reps[j - 1])
                           || (i + 1 < s.length() && j >= 2 && s.charAt(i + 1) == reps[j - 2])){
                       //如果下一个值 > 当前值 || 下两个的值 > 当前值
                       value = value - values[j];
                       break;
                   }else{
                       value = value + values[j];
                       break;
                   }
               }
           }
        }
        return value;
    }

    @Override
    public void longestCommonPrefix(){
        System.out.println(longestCommonPrefix(new String[]{"a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        //公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length() == 0){
                    return "";
                }
                //公共前缀不匹配就让它变短！
                s = s.substring(0, s.length()-1);
            }
        }
        return s;
    }

    @Override
    public void threeSum(){
        System.out.println(threeSum(new int[]{-2,0,0,2,2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int left, right, sum;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            left = i + 1;
            right = nums.length - 1;
            while (right > left) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    @Override
    public void threeSumClosest(){
        System.out.println(threeSumClosest(new int[]{0,2,1,-3}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, sum, diff = Integer.MAX_VALUE, j, k;
        for(int i = 0; i < nums.length - 2; ++i){
            j = i + 1;
            k = nums.length - 1;
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    return sum;
                }
                if(Math.abs(sum - target) < diff){
                    diff = Math.abs(sum - target);
                    res = sum;
                }
                if(sum < target)
                    j++;
                else if(sum > target)
                    k--;
            }
        }
        return res;
    }

    @Override
    public void letterCombinations(){
        System.out.println(letterCombinations("259"));
    }

    //设置全局列表存储最后的结果
    private List<String> list = new ArrayList<>();

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    private StringBuilder temp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        backTracking(digits, numString, 0);
        return list;

    }

    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    public void backTracking(String digits, String[] numString, int num) {
        //遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        //str 表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //递归
            backTracking(digits, numString, num + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    @Override
    public void fourSum(){
        fourSum(new int[]{1,0,-1,0,-2,2}, 0);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if(nums == null || nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);
        int frontPtr, postPtr;
        List<Integer> subList = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                frontPtr = j + 1;
                postPtr = nums.length - 1;
                long tempTarget = (long)target - nums[i] - nums[j];
                while(frontPtr < postPtr) {
                    if((long)nums[frontPtr] + nums[postPtr] == tempTarget) {
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[frontPtr]);
                        subList.add(nums[postPtr]);
                        ans.add(subList);
                        subList.clear();
                        while(frontPtr < postPtr && (nums[frontPtr] == nums[frontPtr + 1])) {
                            frontPtr++;
                        }
                        while(frontPtr < postPtr && (nums[postPtr] == nums[postPtr - 1])) {
                            postPtr--;
                        }
                        frontPtr++;
                        postPtr--;
                    } else if((long)nums[frontPtr] + nums[postPtr] < tempTarget) {
                        frontPtr++;
                    } else {
                        postPtr--;
                    }
                }
            }
        }
        return ans;
    }

    @Override
    public void removeNthFromEnd(){
        ListNode head = getListNode();
        ListNode headCopy = head;
        head = removeNthFromEnd1(head, 2);
        for(;;){
            System.out.println(head.val + ",");
            head = head.next;
            if(head == null){
                break;
            }
        }

        head = removeNthFromEnd2(headCopy, 2);
        for(;;){
            System.out.println(head.val + ",");
            head = head.next;
            if(head == null){
                break;
            }
        }
    }

    int i = 0;

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head.next != null){
            removeNthFromEnd1(head.next, n);
            i ++;
        }
        if(i == n){
            head.next = head.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode head1 = head, head2 = head;
        int i = 0;
        do {
            head = head.next;
            i++;
        } while (head != null);
        if(i == 1){
            return null;
        }
        n = n >= i ? n - i : n;
        if(n == 0){
            return head2.next;
        }
        for(int j = 0; j < i; j++){
            if(j + n + 1 == i){
                head1.next = head1.next.next;
                return head2;
            }
            head1 = head1.next;
        }
        return head2;
    }

    @Override
    public void isValidBrackets(){
        System.out.println(isValid("[(])]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            } else if(c == '['){
                stack.push(']');
            } else if(c == '{'){
                stack.push('}');
            } else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    @Override
    public void mergeTwoLists(){
        ListNode head = new ListNode();
        head.val = 1;
        ListNode head1 = new ListNode();
        head1.val = 2;
        head.next = head1;
        ListNode head2 = new ListNode();
        head2.val = 3;
        head1.next = head2;
        ListNode head3 = new ListNode();
        head3.val = 4;
        head2.next = head3;
        ListNode head4 = new ListNode();
        head4.val = 5;
        head3.next = head4;
        ListNode headCopy = head;

        head = new ListNode();
        head.val = 1;
        head1 = new ListNode();
        head1.val = 3;
        head.next = head1;
        head2 = new ListNode();
        head2.val = 5;
        head1.next = head2;
        ListNode headCopy1 = head;
        ListNode listNode = mergeTwoLists(headCopy, headCopy1);
        while(listNode.next != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode headNode = head;
        while(list1 != null || list2 != null) {

            if (list1 == null) {
                while(list2 != null) {
                    head.next = list2;
                    list2 = list2.next;
                    head = head.next;
                }
                return headNode.next;
            } else if (list2 == null) {
                while(list1 != null) {
                    head.next = list1;
                    list1 = list1.next;
                    head = head.next;
                }
                return headNode.next;
            }
            if (list1.val > list2.val) {
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            } else {
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            }
        }
        return headNode.next;
    }

    @Override
    public void generateParenthesis(){
        System.out.println(generateParenthesis(3));
    }

    private List<String> parenthesisList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtracking(n, n, new StringBuffer());
        return parenthesisList;
    }

    private void backtracking(int left, int right, StringBuffer path) {
        if (left == 0 && right == 0) {
            parenthesisList.add(path.toString());
            return;
        }
        if (left > 0) {
            path.append("(");
            backtracking(left - 1, right, path);
            path.deleteCharAt(path.length() - 1);
        }
        if (left < right) {
            path.append(")");
            backtracking(left, right - 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    @Override
    public void mergeKLists(){
        ListNode head = new ListNode();
        head.val = 1;
        ListNode head1 = new ListNode();
        head1.val = 2;
        head.next = head1;
        ListNode head2 = new ListNode();
        head2.val = 3;
        head1.next = head2;
        ListNode head3 = new ListNode();
        head3.val = 4;
        head2.next = head3;
        ListNode head4 = new ListNode();
        head4.val = 5;
        head3.next = head4;
        ListNode headCopy = head;

        head = new ListNode();
        head.val = 1;
        head1 = new ListNode();
        head1.val = 3;
        head.next = head1;
        head2 = new ListNode();
        head2.val = 5;
        head1.next = head2;
        ListNode headCopy1 = head;
        //使用归并排序进行合并
        ListNode listNode = mergeKLists(new ListNode[]{headCopy, headCopy1});
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        //使用优先队列进行合并
        listNode = mergeKLists1(new ListNode[]{headCopy, headCopy1});
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeTowLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeTowLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int middle = start + (end - start) / 2;
        ListNode left = mergeTowLists(lists, start, middle);
        ListNode right = mergeTowLists(lists, middle + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                pre.next = new ListNode(left.val);
                left = left.next;
            } else {
                pre.next = new ListNode(right.val);
                right = right.next;
            }
            pre = pre.next;
        }
        while (left != null) {
            pre.next = new ListNode(left.val);
            left = left.next;
            pre = pre.next;
        }
        while (right != null) {
            pre.next = new ListNode(right.val);
            right = right.next;
            pre = pre.next;
        }
        return dummyHead.next;
    }

    /**
     * 使用优先队列进行合并
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }

    @Override
    public String swapPairs(){
        ListNode head = getListNode();
        ListNode listNode = swapPairs(head);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        return "success";
    }

    private ListNode getListNode(){
        ListNode head = new ListNode();
        head.val = 1;
        ListNode head1 = new ListNode();
        head1.val = 2;
        head.next = head1;
        ListNode head2 = new ListNode();
        head2.val = 3;
        head1.next = head2;
        ListNode head3 = new ListNode();
        head3.val = 4;
        head2.next = head3;
        ListNode head4 = new ListNode();
        head4.val = 5;
        head3.next = head4;
        ListNode head5 = new ListNode();
        head5.val = 6;
        head4.next = head5;
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    @Override
    public String reverseKGroup(){
        ListNode head = getListNode();
        ListNode listNode = reverseKGroup(head, 3);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        return "success";
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), prev = dummy, curr = head, next;
        dummy.next = head;
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        for(int i = 0; i < length / k; i++) {
            for(int j = 1; j < k; j++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
            curr = prev.next;
        }
        return dummy.next;
    }

    @Override
    public String removeDuplicates(){
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        return "success";
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return nums.length;
        }
        // 使用双指针
        int i = 0, j =1;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    @Override
    public String removeElement() {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        return "success";
    }

    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for(; j < nums.length; j++){
            if(nums[j] != val){
                if(i != j){
                    nums[i] = nums[j];
                }
                i++;
            }
        }
        return i;
    }

    @Override
    public String findStrIndex(){
        System.out.println(strStr("sadbutsad", "sad"));
        return "success";
    }

    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0) && i + needle.length() <= haystack.length() && haystack.substring(i, i + needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String divide(){
        System.out.println(divide(100, 3));
        return "success";
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //用异或来计算是否符号相异
        boolean negative = (dividend ^ divisor) < 0;
        long t = Math.abs((long) dividend), d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            //找出足够大的数2^n * divisor
            if ((t >> i) >= d) {
                //将结果加上2^n
                result += 1 << i;
                //将被除数减去2^n*divisor
                t -= d << i;
            }
        }
        return negative ? -result : result;
    }

    @Override
    public String findSubstring(){
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        return "success";
    }

    public List<Integer> findSubstring(String s, String[] words) {
        //返回答案列表
        List<Integer> list = new ArrayList<>();
        //记录words字符串数组中每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        int m = words.length;
        //题目条件每个单词等长
        int oneNum = words[0].length();
        //所有单词的总长度
        int allNum = m * oneNum;
        //特殊条件判断
        if (allNum > n) {
            return list;
        }
        //记录频次
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //每次移动的步长为单个单词的长度
        //假设单词长度为3，那么我们只要把开头定为索引的0,1,2即可覆盖所有情况
        //因为以3开头是由0开头移动一个步长而来，所有只用记录前面的情况
        for (int i = 0; i < oneNum; i++) {
            //左窗口边界
            int left = i;
            //右窗口边界
            int right = i;
            //记录匹配的单词数
            int cnt = 0;
            //临时记录子串
            Map<String, Integer> tempMap = new HashMap<>();
            while (right + oneNum <= n) {
                //先截取一个单词长度的子串
                String w = s.substring(right, right + oneNum);
                //右窗口移动
                right += oneNum;
                //如果原本记录频次的哈希表中没有这个子串
                if (!map.containsKey(w)) {
                    //左窗口移动
                    left = right;
                    //匹配的单词数清零
                    cnt = 0;
                    //临时记录子串的哈希表清空
                    tempMap.clear();
                } else {
                    //如果原本记录频次的哈希表中有这个子串(单词)
                    //临时记录子串的哈希表也记录该单词的个数
                    tempMap.put(w, tempMap.getOrDefault(w, 0) + 1);
                    //匹配的单词数加一
                    cnt++;
                    //当临时哈希表中的该单词数量多余原本的哈希表的该单词数量
                    while (tempMap.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        //从左边开始截取子串
                        String head = s.substring(left, left + oneNum);
                        //对应临时哈希表中的单词数减一
                        tempMap.put(head, tempMap.getOrDefault(head, 0) - 1);
                        //匹配的单词数减一
                        cnt--;
                        //左窗口移动
                        left += oneNum;
                    }
                    //如果匹配的单词数等于字符串列表中的单词数
                    if (cnt == m) {
                        //说明找到一种符合题意的情况，加入起始位置，即左窗口
                        list.add(left);
                        //那么我们开始下次匹配的情况
                        //需先将左边的从第一个单词先舍弃
                        //因为题目中words中的单词是可以随意组合，没有顺序，但只能用一次
                        String head = s.substring(left, left + oneNum);
                        //对应临时哈希表中该单词的的次数减一
                        tempMap.put(head, tempMap.get(head) - 1);
                        //匹配的单词数减一
                        cnt--;
                        //左窗口移动
                        left += oneNum;
                    }
                }
            }
        }
        return list;
    }

    @Override
    public String nextPermutation(){
        int[] nums = new int[]{5,4,7,5,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        return "success";
    }

    public void nextPermutation(int[] nums) {
        boolean flag = true;
        int aid = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                aid = i - 1;
                flag = false;
                break;
            }
        }
        if (flag) {
            //flag为true的话，说明数组是降序排列，直接反转数组即可
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i > aid; i--) {
            if (nums[i] > nums[aid]) {
                //将遍历过的部分那个比i-1大的最小值和i-1位置交换
                int temp = nums[i];
                nums[i] = nums[aid];
                nums[aid] = temp;
                break;
            }
        }
        reverse(nums, aid + 1, nums.length - 1);//将位置aid+1到最后进行一个倒序即可
    }

    /**
     * 反转数组
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    @Override
    public String longestValidParentheses(){
        System.out.println(longestValidParentheses("(()(()())"));
        return "success";
    }

    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        return Math.max(calc(chars, 0, 1, chars.length, '('), calc(chars, chars.length -1, -1, -1, ')'));
    }

    private static int calc(char[] chars , int i,  int flag, int end, char cTem){
        int max = 0, sum = 0, currLen = 0, validLen = 0;
        for (;i != end; i += flag) {
            sum += (chars[i] == cTem ? 1 : -1);
            currLen ++;
            if(sum < 0){
                max = max > validLen ? max : validLen;
                sum = 0;
                currLen = 0;
                validLen = 0;
            }else if(sum == 0){
                validLen = currLen;
            }
        }
        return max > validLen ? max : validLen;
    }

    @Override
    public String search(){
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        return "success";
    }

    /**
     * 最坏的情况还是O(n)故不行
     */
    public int search1(int[] nums, int target) {
        if(target >= nums[0]){
            for(int i = 0; i < nums.length; i++){
                if(target == nums[i]){
                    return i;
                }
            }
        }else{
            for(int i = nums.length - 1; i >= 0; i--){
                if(target == nums[i]){
                    return i;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int len = nums.length, left = 0, right = len - 1, mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else{
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    @Override
    public String searchRange(){
        System.out.println(JSON.toJSONString(searchRange(new int[]{2,2,2}, 2)));
        return "success";
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }

    public int binarySearch(int[] nums, int target, boolean leftOrRight) {
        int res = -1;
        int left = 0, right = nums.length - 1, mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(target < nums[mid])
                right = mid - 1;
            else if(target > nums[mid])
                left = mid + 1;
            else {
                res = mid;
                //处理target == nums[mid]
                if(leftOrRight)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return res;
    }

    @Override
    public String isValidSudoku(){
        System.out.println(JSON.toJSONString(isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}})));
        return "success";
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String solveSudoku(){
        char[][] arr = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(arr);
        System.out.println(JSON.toJSONString(arr));
        return "success";
    }

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board){
        // 一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，一行一列确定下来之后，递归遍历这个位置放9个数字的可能性
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    continue;
                }
                for (char k = '1'; k <= '9'; k++){
                    if (isValidSudoku(i, j, k, board)){
                        board[i][j] = k;
                        if (solveSudokuHelper(board)){
                            // 如果找到合适一组立刻返回
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     * 同行是否重复
     * 同列是否重复
     * 9宫格里是否重复
     */
    private boolean isValidSudoku(int row, int col, char val, char[][] board){
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String trap(){
        System.out.println(JSON.toJSONString(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})));
        return "success";
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxL = height[left], maxR = height[right];
        int res = 0;
        while (left < right) {
            maxL = Math.max(maxL, height[left]);
            maxR = Math.max(maxR, height[right]);
            res += maxR > maxL ? maxL - height[left++] : maxR - height[right--];
        }
        return res;
    }

    @Override
    public String solveNQueens(){
        System.out.println(JSON.toJSONString(solveNQueens(6)));
        return "success";
    }

    private List<List<String>> solveNQueenList = new ArrayList<>();

    // boolean数组中的每个元素代表一条直(斜)线
    private boolean[] usedCol, usedDiag45, usedDiag135;

    public List<List<String>> solveNQueens(int n) {
        // 列方向的直线条数为 n
        usedCol = new boolean[n];
        // 45°方向的斜线条数为 2 * n - 1
        usedDiag45 = new boolean[2 * n - 1];
        // 135°方向的斜线条数为 2 * n - 1
        usedDiag135 = new boolean[2 * n - 1];
        //用于收集结果, 元素的index表示棋盘的row，元素的value代表棋盘的column
        int[] board = new int[n];
        backTracking(board, n, 0);
        return solveNQueenList;
    }

    private void backTracking(int[] board, int n, int row) {
        if (row == n) {
            //收集结果
            List<String> temp = new ArrayList<>();
            for (int i : board) {
                char[] str = new char[n];
                Arrays.fill(str, '.');
                str[i] = 'Q';
                temp.add(new String(str));
            }
            solveNQueenList.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (usedCol[col] | usedDiag45[row + col] | usedDiag135[row - col + n - 1]) {
                continue;
            }
            board[row] = col;
            // 标记该列出现过
            usedCol[col] = true;
            // 同一45°斜线上元素的row + col为定值, 且各不相同
            usedDiag45[row + col] = true;
            // 同一135°斜线上元素row - col为定值, 且各不相同
            // row - col 值有正有负, 加 n - 1 是为了对齐零点
            usedDiag135[row - col + n - 1] = true;
            // 递归
            backTracking(board, n, row + 1);
            usedCol[col] = false;
            usedDiag45[row + col] = false;
            usedDiag135[row - col + n - 1] = false;
        }
    }

    @Override
    public String totalNQueens(){
        System.out.println(JSON.toJSONString(totalNQueens(4)));
        return "success";
    }

    private int totalNQueensCount = 0;

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }
        dfs( 0, 0, 0, 0, n);
        return totalNQueensCount;
    }

    private void dfs(int row, int col, int pie, int na, int n) {
        if (row >= n) {
            totalNQueensCount++;
            return;
        }
        // 获取当前空位 标识为1  &  去掉所有高位
        int bit = (~(col | pie | na)) & ((1 << n) - 1);
        //遍历所有空位
        while (bit > 0){
            //获取最后的空位 1(用二进制表示实际上此行皇后的位点)
            int p = bit & -bit;
            //col | p 表示 p 位被占用(用二进制表示所有行皇后列的位点)
            //(pie | p ) << 1 ,表示pie往斜左方移一位 被占用
            //(na | p) >> 1,表示na往斜右方移一位 被占用
            dfs(row + 1, col | p, (pie | p ) << 1, (na | p) >> 1, n);
            // 打掉最后的1
            bit &= (bit - 1);
        }
    }

    @AllArgsConstructor
    @Data
    class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Override
    public String isValidBST(){
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);
        System.out.println(JSON.toJSONString(isValidBST(treeNode)));
        return "success";
    }

    public boolean isValidBST(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }

    @Override
    public String minDepth(){
        TreeNode treeNode = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(5);
        treeNode.right.right.right.right = new TreeNode(6);
        System.out.println(JSON.toJSONString(minDepth(treeNode)));
        return "success";
    }

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }else if(root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }else if(root.left != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }else {
            return 1;
        }
    }

    @Override
    public String maxProfit(){
        System.out.println(JSON.toJSONString(maxProfit(new int[]{7,1,5,3,6,4})));
        return "success";
    }

    public int maxProfit(int[] prices) {
        int min = prices[0], result = 0;
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            result = Math.max(prices[i] - min, result);
        }
        return result;
    }

    @Override
    public String maxProfit2(){
        System.out.println(JSON.toJSONString(maxProfit2(new int[]{7,1,5,3,6,4})));
        return "success";
    }

    public int maxProfit2(int[] prices) {
        int sum = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i + 1] > prices[i]){
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }

    @Override
    public String maxProfit3(){
        System.out.println(JSON.toJSONString(maxProfit3(new int[]{1,2,4,2,5,7,2,4,9,0})));
        return "success";
    }

    public int maxProfit3(int[] prices) {
        /**
         * 对于任意一天考虑四个变量:
         * fstBuy: 在该天第一次买入股票可获得的最大收益
         * fstSell: 在该天第一次卖出股票可获得的最大收益
         * secBuy: 在该天第二次买入股票可获得的最大收益
         * secSell: 在该天第二次卖出股票可获得的最大收益
         * 分别对四个变量进行相应的更新, 最后secSell就是最大
         * 收益值(secSell >= fstSell)
         */
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for(int price : prices) {
            fstBuy = Math.max(fstBuy, -price);
            fstSell = Math.max(fstSell, fstBuy + price);
            secBuy = Math.max(secBuy, fstSell - price);
            secSell = Math.max(secSell, secBuy + price);
        }
        return secSell;
    }

    @Override
    public String hasCycle(){
        ListNode node1 = new ListNode(-4, null);
        ListNode node2 = new ListNode(0, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(3, node3);
        node1.next = node3;
        System.out.println(JSON.toJSONString(hasCycle(node4)));
        return "success";
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 空链表、单节点链表一定不会有环
        while (fast != null && fast.next != null) {
            // 快指针，一次移动两步
            fast = fast.next.next;
            // 慢指针，一次移动一步
            slow = slow.next;
            // 快慢指针相遇，表明有环
            if (fast == slow) {
                return true;
            }
        }
        // 正常走到链表末尾，表明没有环
        return false;
    }

    @Override
    public String detectCycle(){
        ListNode node1 = new ListNode(-4, null);
        ListNode node2 = new ListNode(0, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(3, node3);
        ListNode node5 = new ListNode(4, node4);
        node1.next = node3;
        System.out.println(JSON.toJSONString(detectCycle(node5)));
        return "success";
    }

    /**
     * 假设非环形部分为x, 环长度为y, 快慢指针在y的第b个元素重叠, 此时慢指针走过a1圈, 快指针走过a2圈
     * 故有以下等式
     * x + a1 * y + b = n
     * x + a2 * y + b = 2n
     *
     * 如果把等式1 * 2 - 等式2即获得以下结果
     * x + (2a1 - a2) * y + b = 0  =>  x + b = (a2 - 2a1) * y
     * 即b位置, 走过x个元素后, 为y的整数圈
     * 故在有环情况下, 从b出发和从开始出发 经过x个元素后到达y的第一个元素并产生交集
     */
    public ListNode detectCycle(ListNode head) {
        // 步骤一：使用快慢指针判断链表是否有环
        ListNode node1 = head, node2 = head;
        boolean hasCycle = false;
        while (node2 != null && node2.next != null && node2.next.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1 == node2) {
                hasCycle = true;
                break;
            }
        }

        // 步骤二：若有环，找到入环开始的节点
        if (hasCycle) {
            ListNode listNode = head;
            while (node1 != listNode) {
                node1 = node1.next;
                listNode = listNode.next;
            }
            return listNode;
        } else{
            return null;
        }
    }

    @Override
    public String myStack(){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println("top: " +  myStack.top());
        System.out.println("pop: " +  myStack.pop());
        System.out.println("empty: " +  myStack.empty());
        return "success";
    }

    class MyStack {

        //输入队列
        private Queue<Integer> queue1;

        //输出队列
        private Queue<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue1.offer(x);
            // 将queue2队列中元素全部转给queue1队列
            while(!queue2.isEmpty()){
                queue1.offer(queue2.poll());
            }
            // 交换queue1和queue2,使得queue1队列没有在push()的时候始终为空队列
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        public int pop() {
            return queue2.poll();
        }

        public int top() {
            return queue2.peek();
        }

        public boolean empty() {
            return queue2.isEmpty();
        }
    }

    @Override
    public String myQueue(){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println("peek: " +  myQueue.peek());
        System.out.println("pop: " +  myQueue.pop());
        System.out.println("empty: " +  myQueue.empty());
        return "success";
    }

    class MyQueue {

        //输入栈
        private Stack<Integer> stack1;

        //输出栈
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack2.isEmpty() && stack1.isEmpty();
        }
    }

    @Override
    public String lowestCommonAncestor(){
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.right.left = new TreeNode(3);
        treeNode.left.right.right = new TreeNode(5);
        treeNode.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(9);
        System.out.println(JSON.toJSONString(lowestCommonAncestor(treeNode, treeNode.left, treeNode.right)));
        return "success";
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    @Override
    public String lowestCommonAncestor2(){
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(7);
        treeNode.left.right.right = new TreeNode(4);
        treeNode.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);
        System.out.println(JSON.toJSONString(lowestCommonAncestor2(treeNode, treeNode.left, treeNode.right.right)));
        return "success";
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

    @Override
    public String maxSlidingWindow(){
        System.out.println(JSON.toJSONString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        return "success";
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 采用单向队列的方式，让队列中始终保持top处的值是最大的
        Deque<Integer> deque = new ArrayDeque<>();

        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.offer(nums[i]);
        }
        //把第一个窗口中的最大值存进去，下标递增
        res[index++] = deque.peek();


        // 接下来开始循环后面的数：策略就是进一个出一个
        for (int i = 0; i < nums.length - k; i++) {
            // 先弹出数据，如果要删的数，不是头部的数据，那就不执行。首先要保证我的头部是存在的，也就是队列不为空
            if (!deque.isEmpty() && deque.peek() == nums[i]) {
                deque.pop();
            }

            // 接下来加入数据，加入的数一个一个的和队列里面的数比大小，小的数弹出去，从后往头部比较
            while(!deque.isEmpty() && nums[i + k] > deque.peekLast()) {
                deque.removeLast();
            }

            // 把队列中比要添加的数都要小的数都去掉之后，将新的数添加进来
            deque.offer(nums[i + k]);

            // 存了一个数，也弹出了一个数，等于移动了一个窗长，这个时候，可以取窗长下的最大值，也就是头部的值
            res[index++] = deque.peek();
        }
        return res;
    }

    @Override
    public String isAnagram(){
        System.out.println(JSON.toJSONString(isAnagram("rat", "car")));
        return "success";
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] sArr = new int[26];
        for(int i = 0; i < s.length(); i++){
            sArr[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            sArr[t.charAt(i) - 'a']--;
        }
        for(int arr : sArr){
            if(arr != 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public String maxCoins(){
        System.out.println(JSON.toJSONString(maxCoins(new int[]{3,1,5,8,6})));
        return "success";
    }

    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        arr[arr.length - 1] = 1;
        for(int i = 1; i < arr.length - 1; i++){
            arr[i] = nums[i - 1];
        }
        int[][] map = new int[arr.length][arr.length];
        for(int i = 1; i < map.length - 1; i++){
            map[i][i] = arr[i - 1] * arr[i] * arr[i + 1];
        }
        for(int start = map.length - 2; start > 0; start--){
            for(int end = start + 1; end < map.length - 1; end++){
                int ans = 0;
                int p;
                for(int i = start; i <= end; i++){
                    //最后打爆i位置，则打爆i位置加上start到i - 1位置的得分 加上i + 1到end的得分就是得分
                    p = arr[start - 1] * arr[i] * arr[end + 1] + map[start][i - 1] + map[i + 1][end];
                    ans = Math.max(ans, p);
                }
                map[start][end] = ans;
            }
        }
        return map[1][map.length - 2];
    }

    @Override
    public String kthLargest(){
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println("add: " + kthLargest.add(3));
        System.out.println("add: " + kthLargest.add(5));
        System.out.println("add: " + kthLargest.add(10));
        System.out.println("add: " + kthLargest.add(9));
        System.out.println("add: " + kthLargest.add(4));
        return "success";
    }

    class KthLargest {
        PriorityQueue<Integer> priorityQueue;

        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            priorityQueue = new PriorityQueue<>(k);
            for(int i: nums) {
                add(i);
            }
        }

        public int add(int val) {
            if(priorityQueue.size() < k) {
                priorityQueue.offer(val);
            } else if(priorityQueue.peek() < val) {
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
            return priorityQueue.peek();
        }
    }
}