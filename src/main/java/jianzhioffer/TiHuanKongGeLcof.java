//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//

package jianzhioffer;
  public class TiHuanKongGeLcof {
      public static void main(String[] args) {
           Solution solution = new TiHuanKongGeLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        char[] newChar = new char[s.length() * 3];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                newChar[index++] = '%';
                newChar[index++] = '2';
                newChar[index++] = '0';
            }else {
                newChar[index++] = s.charAt(i);
            }
        }
        return new String(newChar, 0, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }