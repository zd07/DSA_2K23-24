package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
class Pair{
    String word;
    int steps;
    Pair(String word ,int steps){
        this.word=word;
        this.steps=steps;
    }
}
public class WordLadderI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<Pair>();
        Set<String> set =new HashSet<String>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().word;
            int steps=q.peek().steps;
            q.remove();
            if(word.equals(endWord)==true) return steps;
            for(int i=0;i<word.length();i++){
                for(char ch='a' ; ch<='z' ; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch ;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord) == true){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps + 1));
                    }
                }
            }
        }
        return 0;

    }
}
