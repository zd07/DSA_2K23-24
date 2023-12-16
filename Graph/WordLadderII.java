package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
     String b;
    HashMap<String,Integer> map;
    List<List<String>> ans;
    private void dfs(String word,List<String> seq){
        if(word.equals(b)){
            List<String> dup=new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps=map.get(word);
        int sz=word.length();
        for(int i=0;i<sz;i++){
            for(char ch='a';ch<='z';ch++){
                    char[] charArray=word.toCharArray();
                    charArray[i]=ch;
                    String rWord=new String(charArray);
                    if(map.containsKey(rWord) == true && map.get(rWord) + 1 == steps){
                        seq.add(rWord);
                        dfs(rWord,seq);
                        seq.remove(seq.size()-1);
                    }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<String>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<String> q=new LinkedList<>();
        b=beginWord;
        q.add(beginWord);
        set.remove(beginWord);
        map=new HashMap<>();
        map.put(beginWord,1);
        int size=beginWord.length();
        while(!q.isEmpty()){
            String word=q.peek();
            int steps=map.get(word);
            q.remove();
            if(word.equals(endWord)) break;
            for(int i=0;i<size;i++){
                for(char ch='a';ch<='z';ch++){
                    char[] charArray=word.toCharArray();
                    charArray[i]=ch;
                    String rWord=new String(charArray);
                    if(set.contains(rWord)==true){
                        q.add(rWord);
                        set.remove(rWord);
                        map.put(rWord,steps+1);
                    }
                }
            }
        }
        ans=new ArrayList<>();
        if(map.containsKey(endWord)==true){
            List<String> seq=new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;


    }
}
