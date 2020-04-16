package hashtable;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 时间复杂度O(N*K*logK)  其中n是数组的长度 k是字符串数组的最大的字符串长度
        // 空间复杂度是N
        Map<String, List> hash = new HashMap<String, List>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!hash.containsKey(key)) hash.put(key, new ArrayList());
            hash.get(key).add(strs[i]);
        }
        return new ArrayList(hash.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

