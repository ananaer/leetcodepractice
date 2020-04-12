package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
//
// ʾ�� 1:
//
// ����: s = "anagram", t = "nagaram"
//���: true
//
//
// ʾ�� 2:
//
// ����: s = "rat", t = "car"
//���: false
//
// ˵��:
//����Լ����ַ���ֻ����Сд��ĸ��
//
// ����:
//��������ַ������� unicode �ַ���ô�죿���ܷ������Ľⷨ��Ӧ�����������
// Related Topics ���� ��ϣ��
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        // 1.������ж������ַ����Ƿ���� ʱ�临�Ӷ�O(n*log(n))
        /*char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        Arrays.sort(s_chars);
        Arrays.sort(t_chars);
        if (new String(s_chars).equals(new String(t_chars))) {
            return true;
        } else {
            return false;
        } */

        // 2.ʹ��Hash���жϣ�ʱ�临�Ӷ�O(n)
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char s_key = s.charAt(i);
            char t_key = t.charAt(i);
            if (null == map.get(s_key)) {
                map.put(s_key, 1);
            } else {
                map.put(s_key, map.get(s_key) + 1);
            }
            if (null == map.get(t_key)) {
                map.put(t_key, -1);
            } else {
                map.put(t_key, map.get(t_key) - 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
