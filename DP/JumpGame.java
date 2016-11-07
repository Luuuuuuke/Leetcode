public class JumpGame {	/**     * @param A: A list of integers     * @return: The boolean answer     */    public boolean canJump(int[] A) {        if(A == null || A.length <= 1){            return true;        }        // DP solution, O(n^2) time, O(n) space        // dp[i] stands for whether can reach index i        // boolean[] dp = new boolean[A.length];        // dp[0] = true;        // for(int i = 1; i < A.length; i++){        //     for(int j = 0; j < i; j++){        //         if(dp[j] && j + A[j] >= i){        //             dp[i] = true;        //             break;        //         }        //     }        //     if(dp[i] == false){        //         return false;        //     }        // }        // return dp[A.length - 1];                // O(n) solution here        boolean flag = true;        int idx = -1;        for(int i = A.length - 2; i >= 0; i--){            if(flag == false){                if(i + A[i] > idx){                    flag = true;                }            }            else if(A[i] == 0){                flag = false;                idx = i;            }        }        return flag;    }}