package POD;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Integer> map = new HashMap<>();
        //count the frequency of each cahractr in string s
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        //iterate through string t
        for(char ch:t.toCharArray()){
            //character found in map then decrease the frequency of that chat in map
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                // if frequency of char is 0 in map then remove that character
                if(map.get(ch)==0){
                    map.remove(ch);
                }
            }
            //if character not found in map the return false
            else{
                return false;
            }
        }
        
        return true;
    }
}
