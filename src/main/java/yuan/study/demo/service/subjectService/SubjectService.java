package yuan.study.demo.service.subjectService;


public interface SubjectService {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     *
     * 示例 2：
     *
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     *
     *
     * 示例 3：
     *
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     *
     *
     *
     * 提示：
     *
     *
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     *
     *
     * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
     * Related Topics 数组 哈希表
     * 👍 11871 👎 0
     */
    void subjectTest();

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     *  请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     *  你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     *
     *
     *  示例 1：
     *
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     *
     *
     *  示例 2：
     *
     *
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     *
     *
     *  示例 3：
     *
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *
     *
     *
     *
     *  提示：
     *
     *
     *  每个链表中的节点数在范围 [1, 100] 内
     *  0 <= Node.val <= 9
     *  题目数据保证列表表示的数字不含前导零
     *
     *  Related Topics 递归 链表 数学
     *  👍 6624 👎 0
     */
    void addTwoNumbers();

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *
     *
     *  示例 1:
     *
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     *
     *  示例 2:
     *
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     *
     *  示例 3:
     *
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     *
     *  示例 4:
     *
     *
     * 输入: s = ""
     * 输出: 0
     *
     *
     *
     *
     *  提示：
     *
     *
     *  0 <= s.length <= 5 * 104
     *  s 由英文字母、数字、符号和空格组成
     *
     *  Related Topics 哈希表 字符串 滑动窗口
     *  👍 5986 👎 0
     */
    void longestSubstringWithoutRepeatedCharacters();

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     *
     *
     *  示例 1：
     *
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     *
     *
     *  示例 2：
     *
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     *
     *
     *  示例 3：
     *
     *
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     *
     *
     *  示例 4：
     *
     *
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     *
     *
     *  示例 5：
     *
     *
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     *
     *
     *
     *
     *  提示：
     *
     *
     *  nums1.length == m
     *  nums2.length == n
     *  0 <= m <= 1000
     *  0 <= n <= 1000
     *  1 <= m + n <= 2000
     *  -106 <= nums1[i], nums2[i] <= 106
     *
     *
     *
     *
     *  进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     *  Related Topics 数组 二分查找 分治
     *  👍 4427 👎 0
     */
    void queryPositiveArrayMedian();

    /**
     * //给你一个字符串 s，找到 s 中最长的回文子串。
     * //
     * //
     * //
     *  示例 1：
     *
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     *
     *  示例 2：
     *
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     *
     *
     *  示例 3：
     *
     *
     * 输入：s = "a"
     * 输出："a"
     *
     *
     *  示例 4：
     *
     *
     * 输入：s = "ac"
     * 输出："a"
     *
     *
     *
     *
     *  提示：
     *
     *
     *  1 <= s.length <= 1000
     *  s 仅由数字和英文字母（大写和/或小写）组成
     *
     *  Related Topics 字符串 动态规划
     *  👍 4065 👎 0
     */
    void getTheLongestPalindromeString();

    /**
     * //将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * //
     * // 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * //
     * //
     * //P   A   H   N
     * //A P L S I I G
     * //Y   I   R
     * //
     * // 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * //
     * // 请你实现这个将字符串进行指定行数变换的函数：
     * //
     * //
     * //string convert(string s, int numRows);
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：s = "PAYPALISHIRING", numRows = 3
     * //输出："PAHNAPLSIIGYIR"
     * //
     * //示例 2：
     * //
     * //
     * //输入：s = "PAYPALISHIRING", numRows = 4
     * //输出："PINALSIGYAHRPI"
     * //解释：
     * //P     I    N
     * //A   L S  I G
     * //Y A   H R
     * //P     I
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：s = "A", numRows = 1
     * //输出："A"
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= s.length <= 1000
     * // s 由英文字母（小写和大写）、',' 和 '.' 组成
     * // 1 <= numRows <= 1000
     */
    void zigzagTransformation();

    /**
     * //给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * //
     * // 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
     * //假设环境不允许存储 64 位整数（有符号或无符号）。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：x = 123
     * //输出：321
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：x = -123
     * //输出：-321
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：x = 120
     * //输出：21
     * //
     * //
     * // 示例 4：
     * //
     * //
     * //输入：x = 0
     * //输出：0
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // -231 <= x <= 231 - 1
     */
    void integerInversion();

    /**
     * //请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     * //
     * // 函数 myAtoi(string s) 的算法如下：
     * //
     * //
     * // 读入字符串并丢弃无用的前导空格
     * // 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * // 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * // 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤
     * //2 开始）。
     * // 如果整数数超过 32 位有符号整数范围 [−231, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固
     * //定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
     * // 返回整数作为最终结果。
     * //
     * //
     * // 注意：
     * //
     * //
     * // 本题中的空白字符只包括空格字符 ' ' 。
     * // 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：s = "42"
     * //输出：42
     * //解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
     * //第 1 步："42"（当前没有读入字符，因为没有前导空格）
     * //         ^
     * //第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     * //         ^
     * //第 3 步："42"（读入 "42"）
     * //           ^
     * //解析得到整数 42 。
     * //由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
     * //
     * // 示例 2：
     * //
     * //
     * //输入：s = "   -42"
     * //输出：-42
     * //解释：
     * //第 1 步："   -42"（读入前导空格，但忽视掉）
     * //            ^
     * //第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
     * //             ^
     * //第 3 步："   -42"（读入 "42"）
     * //               ^
     * //解析得到整数 -42 。
     * //由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：s = "4193 with words"
     * //输出：4193
     * //解释：
     * //第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
     * //         ^
     * //第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     * //         ^
     * //第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
     * //             ^
     * //解析得到整数 4193 。
     * //由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 0 <= s.length <= 200
     * // s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
     */
    void convertStringNumber();

    /**
     * //给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * //
     * // 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * //
     * //
     * // 例如，121 是回文，而 123 不是。
     * //
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：x = 121
     * //输出：true
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：x = -121
     * //输出：false
     * //解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：x = 10
     * //输出：false
     * //解释：从右向左读, 为 01 。因此它不是一个回文数。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // -231 <= x <= 231 - 1
     */
    void palindromeNumber();

    /**
     * //给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * //
     * //
     * // '.' 匹配任意单个字符
     * // '*' 匹配零个或多个前面的那一个元素
     * //
     * //
     * // 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：s = "aa", p = "a"
     * //输出：false
     * //解释："a" 无法匹配 "aa" 整个字符串。
     * //
     * //
     * // 示例 2:
     * //
     * //
     * //输入：s = "aa", p = "a*"
     * //输出：true
     * //解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * //
     * //
     * // 示例 3：
     * //
     * //
     * //输入：s = "ab", p = ".*"
     * //输出：true
     * //解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= s.length <= 20
     * // 1 <= p.length <= 30
     * // s 只包含从 a-z 的小写字母。
     * // p 只包含从 a-z 的小写字母，以及字符 . 和 *。
     * // 保证每次出现字符 * 时，前面都匹配到有效的字符
     */
    void regularExpressionMatching();

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 说明：你不能倾斜容器。
     *
     * 
     * 
     * 
     */
    void holdMostWater();

    /**
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给你一个整数，将其转为罗马数字。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: num = 3
     * 输出: "III"
     * 示例 2:
     *
     * 输入: num = 4
     * 输出: "IV"
     * 示例 3:
     *
     * 输入: num = 9
     * 输出: "IX"
     * 示例 4:
     *
     * 输入: num = 58
     * 输出: "LVIII"
     * 解释: L = 50, V = 5, III = 3.
     * 示例 5:
     *
     * 输入: num = 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *  
     *
     * 提示：
     *
     * 1 <= num <= 3999
     */
    void intToRoman();

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: s = "III"
     * 输出: 3
     * 示例 2:
     *
     * 输入: s = "IV"
     * 输出: 4
     * 示例 3:
     *
     * 输入: s = "IX"
     * 输出: 9
     * 示例 4:
     *
     * 输入: s = "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例 5:
     *
     * 输入: s = "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 15
     * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
     * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
     * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
     * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
     * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
     */
    void romanToInt();

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *  
     *
     * 提示：
     *
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     */
    void longestCommonPrefix();

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 示例 1：
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     *
     * 示例 2：
     * 输入：nums = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：nums = [0]
     * 输出：[]
     *  
     * 提示：
     * 0 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */
    void threeSum();

    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     *
     * 返回这三个数的和。
     *
     * 假定每组输入只存在恰好一个解。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 示例 2：
     *
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     *  
     *
     * 提示：
     *
     * 3 <= nums.length <= 1000
     * -1000 <= nums[i] <= 1000
     * -104 <= target <= 104
     *
     */
    void threeSumClosest();

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     *
     * 示例 1：
     *
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     *
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     *
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     *  
     *
     * 提示：
     *
     * 0 <= digits.length <= 4
     * digits[i] 是范围 ['2', '9'] 的一个数字。
     */
    void letterCombinations();

    /**
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     *
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * 示例 2：
     *
     * 输入：nums = [2,2,2,2,2], target = 8
     * 输出：[[2,2,2,2]]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     */
    void fourSum();

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *  
     *
     * 提示：
     *
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     */
    void removeNthFromEnd();

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *  
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     *
     * 示例 2：
     * 输入：s = "()[]{}"
     * 输出：true
     *
     * 示例 3：
     * 输入：s = "(]"
     * 输出：false
     *
     * 示例 4：
     * 输入：s = "([)]"
     * 输出：false
     *
     * 示例 5：
     * 输入：s = "{[]}"
     * 输出：true
     *
     * 提示：
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     */
    void isValidBrackets();

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     *
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     *  
     *
     * 提示：
     *
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     */
    void mergeTwoLists();

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：["()"]
     *  
     *
     * 提示：
     *
     * 1 <= n <= 8
     */
    void generateParenthesis();

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     *
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     *  
     *
     * 提示：
     *
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     */
    void mergeKLists();

    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     *
     * 示例 1：
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     *
     * 示例 2：
     * 输入：head = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：head = [1]
     * 输出：[1]
     *  
     * 提示：
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
     */
    String swapPairs();

    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * 示例 1：
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     *
     * 示例 2：
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     *
     * 提示：
     * 链表中的节点数目为 n
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
     */
    String reverseKGroup();

    /**
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     *
     * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
     *
     * 将最终结果插入 nums 的前 k 个位置后返回 k 。
     *
     * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 判题标准:
     *
     * 系统会用下面的代码来测试你的题解:
     *
     * int[] nums = [...]; // 输入数组
     * int[] expectedNums = [...]; // 长度正确的期望答案
     *
     * int k = removeDuplicates(nums); // 调用
     *
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     *     assert nums[i] == expectedNums[i];
     * }
     * 如果所有断言都通过，那么您的题解将被 通过。
     *
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2：
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     *
     * 提示：
     * 1 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * nums 已按 升序 排列
     */
    String removeDuplicates();

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     *  
     *
     * 说明:
     *
     * 为什么返回数值是整数，但输出的答案是数组呢?
     *
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     * 示例 2：
     *
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3]
     * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
     *  
     *
     * 提示：
     *
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 50
     * 0 <= val <= 100
     */
    String removeElement();

    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0 。
     * 示例 2：
     *
     * 输入：haystack = "leetcode", needle = "leeto"
     * 输出：-1
     * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
     */
    String findStrIndex();

    /**
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     *
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     *
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     *
     *  
     *
     * 示例 1:
     *
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     * 示例 2:
     *
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     *  
     *
     * 提示：
     *
     * 被除数和除数均为 32 位有符号整数。
     * 除数不为 0。
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
     */
    String divide();

    /**
     *给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
     *
     *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
     *
     * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
     * 返回所有串联字串在 s 中的开始索引。你可以以 任意顺序 返回答案。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
     * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
     * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
     * 输出顺序无关紧要。返回 [9,0] 也是可以的。
     * 示例 2：
     *
     * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
     * 输出：[]
     * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
     * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
     * 所以我们返回一个空数组。
     * 示例 3：
     *
     * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
     * 输出：[6,9,12]
     * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
     * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
     * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
     * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * 1 <= words.length <= 5000
     * 1 <= words[i].length <= 30
     * words[i] 和 s 由小写英文字母组成
     */
    String findSubstring();

    /**
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     *
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     *
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     *
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * 示例 3：
     *
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     */
    String nextPermutation();

    /**
     *给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     * 示例 2：
     *
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     * 示例 3：
     *
     * 输入：s = ""
     * 输出：0
     *  
     *
     * 提示：
     *
     * 0 <= s.length <= 3 * 104
     * s[i] 为 '(' 或 ')'
     */
    String longestValidParentheses();

    /**
     *整数数组 nums 按升序排列，数组中的值 互不相同 。
     *
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     *
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     *
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：nums = [1], target = 0
     * 输出：-1
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * nums 中的每个值都 独一无二
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -104 <= target <= 104
     */
    String search();

    /**
     *给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     *
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *  
     *
     * 提示：
     *
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -109 <= target <= 109
     */
    String searchRange();

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * 示例 1：
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     *
     * 示例 2：
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *  
     *
     * 提示：
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     */
    String trap();

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * 有效 二叉搜索树定义如下：
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *  
     * 示例 1：
     * 输入：root = [2,1,3]
     * 输出：true
     *
     * 示例 2：
     * 输入：root = [5,1,4,null,null,3,6]
     * 输出：false
     * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
     *
     * 提示：
     * 树中节点数目范围在[1, 104] 内
     * -231 <= Node.val <= 231 - 1
     */
    String isValidBST();

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * 示例 1：
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     *
     * 示例 2：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * 提示：
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     */
    String maxProfit();

    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     *
     * 返回 你能获得的 最大 利润 。
     *
     * 示例 1：
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     *      总利润为 4 + 3 = 7 。
     *
     * 示例 2：
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      总利润为 4 。
     *
     * 示例 3：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
     *
     * 提示：
     * 1 <= prices.length <= 3 * 104
     * 0 <= prices[i] <= 104
     */
    String maxProfit2();

    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * 输出：6
     * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     *
     * 示例 2：
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     * 示例 3：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
     *
     * 示例 4：
     * 输入：prices = [1]
     * 输出：0
     *
     * 提示：
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 105
     */
    String maxProfit3();

    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     *
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     *
     * 示例 1：
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 示例 2：
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     *
     * 示例 3：
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     *
     * 提示：
     * 链表中节点的数目范围是 [0, 104]
     * -105 <= Node.val <= 105
     * pos 为 -1 或者链表中的一个 有效索引 。
     */
    String hasCycle();

    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 不允许修改 链表。
     *
     * 示例 1：
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 示例 2：
     * 输入：head = [1,2], pos = 0
     * 输出：返回索引为 0 的链表节点
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     *
     * 示例 3：
     * 输入：head = [1], pos = -1
     * 输出：返回 null
     * 解释：链表中没有环。
     *
     * 提示：
     * 链表中节点的数目范围在范围 [0, 104] 内
     * -105 <= Node.val <= 105
     * pos 的值为 -1 或者链表中的一个有效索引
     */
    String detectCycle();

    /**
     * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
     *
     * 实现 MyStack 类：
     * void push(int x) 将元素 x 压入栈顶。
     * int pop() 移除并返回栈顶元素。
     * int top() 返回栈顶元素。
     * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
     *
     * 注意：
     * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
     * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
     *  
     * 示例：
     *
     * 输入：
     * ["MyStack", "push", "push", "top", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     *
     * 输出：
     * [null, null, null, 2, 2, false]
     *
     * 解释：
     * MyStack myStack = new MyStack();
     * myStack.push(1);
     * myStack.push(2);
     * myStack.top(); // 返回 2
     * myStack.pop(); // 返回 2
     * myStack.empty(); // 返回 False
     *
     * 提示：
     * 1 <= x <= 9
     * 最多调用100 次 push、pop、top 和 empty
     * 每次调用 pop 和 top 都保证栈不为空
     */
    String myStack();

    /**
     * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
     *
     * 实现 MyQueue 类：
     * void push(int x) 将元素 x 推到队列的末尾
     * int pop() 从队列的开头移除并返回元素
     * int peek() 返回队列开头的元素
     * boolean empty() 如果队列为空，返回 true ；否则，返回 false
     *
     * 说明：
     * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
     * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
     *
     * 示例 1：
     * 输入：
     * ["MyQueue", "push", "push", "peek", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * 输出：
     * [null, null, null, 1, 1, false]
     *
     * 解释：
     * MyQueue myQueue = new MyQueue();
     * myQueue.push(1); // queue is: [1]
     * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
     * myQueue.peek(); // return 1
     * myQueue.pop(); // return 1, queue is [2]
     * myQueue.empty(); // return false
     *
     * 提示：
     * 1 <= x <= 9
     * 最多调用 100 次 push、pop、peek 和 empty
     * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
     *
     * 进阶：
     * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
     */
    String myQueue();

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     * 示例 1:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     *
     * 示例 2:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     *
     * 说明:
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉搜索树中。
     */
    String lowestCommonAncestor();

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 示例 1：
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出：3
     * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
     *
     * 示例 2：
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出：5
     * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
     *
     * 示例 3：
     * 输入：root = [1,2], p = 1, q = 2
     * 输出：1
     *
     * 提示：
     * 树中节点数目在范围 [2, 105] 内。
     * -109 <= Node.val <= 109
     * 所有 Node.val 互不相同 。
     * p != q
     * p 和 q 均存在于给定的二叉树中。
     */
    String lowestCommonAncestor2();

    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回 滑动窗口中的最大值 。
     *
     * 示例 1：
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     * 示例 2：
     * 输入：nums = [1], k = 1
     * 输出：[1]
     *
     * 提示：
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     */
    String maxSlidingWindow();

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     *
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * 提示:
     * 1 <= s.length, t.length <= 5 * 104
     * s 和 t 仅包含小写字母
     */
    String isAnagram();

    /**
     * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
     *
     * 请实现 KthLargest 类：
     *
     * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
     * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
     *
     * 示例：
     *
     * 输入：
     * ["KthLargest", "add", "add", "add", "add", "add"]
     * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
     *
     * 输出：
     * [null, 4, 5, 5, 8, 8]
     *
     * 解释：
     * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
     * kthLargest.add(3);   // return 4
     * kthLargest.add(5);   // return 5
     * kthLargest.add(10);  // return 5
     * kthLargest.add(9);   // return 8
     * kthLargest.add(4);   // return 8
     *
     * 提示：
     * 1 <= k <= 104
     * 0 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * -104 <= val <= 104
     * 最多调用 add 方法 104 次
     * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
     */
    String kthLargest();
}
