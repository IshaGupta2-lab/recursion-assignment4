// 2. 2. Word Break II (LeetCode 140) 
// Link: https://leetcode.com/problems/word-break-ii/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q2 {
    public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return backtrack(s, 0, wordSet, memo);
    }

    private List<String> backtrack(String s, int start, Set<String> wordSet, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> results = new ArrayList<>();
        if (start == s.length()) {
            results.add("");
            return results;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordSet.contains(prefix)) {
                List<String> subSentences = backtrack(s, end, wordSet, memo);
                for (String sub : subSentences) {
                    if (sub.isEmpty()) {
                        results.add(prefix);
                    } else {
                        results.add(prefix + " " + sub);
                    }
                }
            }
        }

        memo.put(start, results);
        return results;
    }
}

}
