package Trie;

/**
 * Created by RuiY on 2017/6/13.
 */
public class LC211AddAndSearchWord {
    private TrieNode root;
    /**
     * Initialize your data structure here.
     **/
    public LC211AddAndSearchWord() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        TrieNode node = root;

        for(char c : word.toCharArray()){
            if(!node.containsKey(c)){
                node.put(c,new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return true;
        }else{
            TrieNode node = root;
            return dfs(word,root,0);
        }
    }

    public boolean dfs(String word,TrieNode node,int index){
        if(index > word.length()){
            return false;
        }
        if(index == word.length() && node.isEnd()){
            return true;
        }
        char c = word.charAt(index);
        if(c == '.'){
            for(TrieNode n : node.getNodes()){
                if(n != null){
                    dfs(word,n,index+1);
                }
            }
        }else if(node.containsKey(c)){
            dfs(word,node.get(c),index+1);
        }

        return false;
    }

}

/*class TrieNode{
    private TrieNode[] nodes;
    private final int N = 26;
    private boolean isEnd;

    TrieNode(){
        nodes = new TrieNode[N];
        isEnd = false;
    }

    public boolean isContains(char c){
        return nodes[c - 'a'] != null;
    }

    public TrieNode getNode(char c){
        if(nodes[c - 'a'] != null) {
            return nodes[c - 'a'];
        }else{
            return null;
        }
    }

    public void setIsEnd(){
        isEnd = true;
    }

    public boolean getIsEnd(){
        return isEnd;
    }




}*/

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */