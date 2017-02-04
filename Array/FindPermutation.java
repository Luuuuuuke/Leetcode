public class FindPermutation {	public int[] findPermutation(String s) {        if(s == null || s.length() == 0){            return new int[0];        }        int[] res = new int[s.length() + 1];        for(int i = 0; i < res.length; i++){            res[i] = i + 1;        }        for(int i = 0; i < s.length(); i++){            if(s.charAt(i) == 'D'){                int start = i;                while(i < s.length() && s.charAt(i) == 'D'){                    i++;                }                reverse(res, start, i);            }        }        return res;    }        private void reverse(int[] res, int i, int j){        int left = i, right = j;        while(left < right){            int tmp = res[left];            res[left] = res[right];            res[right] = tmp;            left++;            right--;        }    }}