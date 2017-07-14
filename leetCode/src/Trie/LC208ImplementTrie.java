package Trie;

import Tree.TreeNode;

/**
 * Created by RuiY on 2017/6/6.
 */
//prefix tree
public class LC208ImplementTrie {
    //Implement a trie with insert, search, and startsWith methods.
    private TrieNode root;

    public LC208ImplementTrie(){
        root = new TrieNode();
    }

    //insert a word into the trie O(m) m==word.length()
    public void insert(String word){
        TrieNode node = root;
        for(int i = 0;i < word.length();i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar,new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i = 0;i < word.length();i++){
            char currentChar = word.charAt(i);
            if(node.containsKey(currentChar)){
                node = node.get(currentChar);
            }else{
                return null;
            }
        }
        return node;
    }

    //search method ; return if the word is in the trie
    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String word){
        TrieNode node = searchPrefix(word);
        return node != null;
    }


}

class TrieNode{
    private TrieNode[] nodes;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode(){
        nodes = new TrieNode[R];
    }

    public boolean containsKey(char c){
        return nodes[c - 'a'] != null;
    }

    public TrieNode get(char c){
        return nodes[c - 'a'];
    }

    public void put(char c,TrieNode node){
        nodes[c - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }

    public TrieNode[] getNodes(){
        return nodes;
    }
}
