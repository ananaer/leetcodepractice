package hashtable;

//����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
//
// ʾ��:
//
// ����: ["eat", "tea", "tan", "ate", "nat", "bat"]
//���:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// ˵����
//
//
// ���������ΪСд��ĸ��
// �����Ǵ������˳��
//
// Related Topics ��ϣ�� �ַ���


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // ʱ�临�Ӷ�O(N*K*logK)  ����n������ĳ��� k���ַ�������������ַ�������
        // �ռ临�Ӷ���N
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

