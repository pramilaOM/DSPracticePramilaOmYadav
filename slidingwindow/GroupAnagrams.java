import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> data = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            
            data.computeIfAbsent(key, k -> new ArrayList<>()).add(s);

        }

        return new ArrayList<>(data.values());

    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> output = groupAnagrams(strs); 
        for(List<String> s : output){
            System.out.print(s);
        }
        
    }

}