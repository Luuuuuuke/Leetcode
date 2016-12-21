import java.util.*;public class FindTheMissingNumber2 {	/**     * @param n an integer     * @param str a string with number from 1-n     *            in random order and miss one number     * @return an integer     */    int sum;    int res;    public int findMissing2(int n, String str) {        if(str == null || str.length() == 0){            return -1;        }        int target = (1 + n) * n / 2;        sum = 0;        res = 0;        dfs(0, str, target, n, new HashSet<Integer>());        return target - res;    }        public void dfs(int cur, String str, int target, int n, HashSet<Integer> used){        if(res == 0 && cur == str.length()){            res = sum;            return;        }        for(int i = cur; i < str.length(); i++){            String tmp = str.substring(cur, i + 1);            int val = Integer.parseInt(tmp);            if(val < 1 || val > n || sum + val >= target){                break;            }            if(used.contains(val)) continue;            used.add(val);            sum += val;            dfs(i + 1, str, target, n, used);            sum -= val;            used.remove(val);        }    }}