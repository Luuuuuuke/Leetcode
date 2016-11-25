import java.util.ArrayList;import java.util.List;import java.util.Set;public class WordBreak2 {	 /**     * @param s a string     * @param wordDict a set of words     */    public List<String> wordBreak(String s, Set<String> wordDict) {        List<String> res = new ArrayList<String>();        if(s == null || s.length() == 0){            return res;        }        boolean[][] isWord = new boolean[s.length()][s.length()];        for(int right = 0; right < s.length(); right++){            for(int left = 0; left <= right; left++){                if(wordDict.contains(s.substring(left, right + 1))){                    isWord[left][right] = true;                }            }        }        boolean[] possible = canBreak(s, isWord, wordDict);        dfs(res, new ArrayList<String>(), s, isWord, possible, 0);        return res;    }        public boolean[] canBreak(String s, boolean[][] isWord, Set<String> wordDict){        int maxLen = 0;        for(String str : wordDict){            maxLen = Math.max(str.length(), maxLen);        }        // dp[i] denotes whther first i can break into words        boolean[] dp = new boolean[s.length()+1];         dp[s.length()] = true;        for (int i = s.length() - 1; i >= 0; i--) {            for (int j = i; j < s.length(); j++) {                if (isWord[i][j] && dp[j + 1]) {                    dp[i] = true;                    break;                }            }        }                return dp;    }        public void dfs(List<String> res, List<String> sol, String s,                                boolean[][] isWord, boolean[] possible, int cur){        if(!possible[cur]){            return;        }        if(cur == s.length()){            StringBuilder sb = new StringBuilder();            int count = 0;            for(String word : sol){                sb.append(word);                count++;                if(count < sol.size()){                    sb.append(" ");                }            }            res.add(sb.toString());            return;        }        for(int i = cur; i < s.length(); i++){            if(!isWord[cur][i]){                continue;            }            sol.add(s.substring(cur, i + 1));            dfs(res, sol, s, isWord, possible, i + 1);            sol.remove(sol.size() - 1);        }    }}