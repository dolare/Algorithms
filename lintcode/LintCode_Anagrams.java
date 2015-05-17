import java.util.ArrayList;
import java.util.HashMap;


public class LintCode_Anagrams {
	public static void main(String[] args){
		LintCode_Anagrams lint = new LintCode_Anagrams();
		String[] str = {"ab", "ba", "cd", "dc", "e"};
		System.out.print(lint.anagrams(str));
	}
	 private int getHash(int[] count) {
	        int hash = 0;
	        int a = 378551;
	        int b = 63689;
	        for (int num : count) {
	            hash = hash * a + num;
	            a = a * b;
	        }
	        return hash;
	    }
	    
	    public ArrayList<String> anagrams(String[] strs) {
	        ArrayList<String> result = new ArrayList<String>();
	        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

	        for (String str : strs) {
	            int[] count = new int[26];
	            for (int i = 0; i < str.length(); i++) {
	                count[str.charAt(i) - 'a']++;
	            }

	            int hash = getHash(count);
	            if (!map.containsKey(hash)) {
	                map.put(hash, new ArrayList<String>());
	            }

	            map.get(hash).add(str);
	        }

	        for (ArrayList<String> tmp : map.values()) {
	            if (tmp.size() > 1) {
	                result.addAll(tmp);
	            }
	        }

	        return result;
	    }
}
