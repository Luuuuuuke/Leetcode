public class NextPermutation {	/**     * @param nums: an array of integers     * @return: return nothing (void), do not return anything, modify nums in-place instead     */    public int[] nextPermutation(int[] nums) {        // idea: 1. from the last index, find the first index i that break the ascending rule        // 2. swap nums[i] and with the appropriate nums[tmp] value, and then reverse from i + 1 to last        if(nums == null || nums.length == 0){            return new int[0];        }        int i = nums.length - 1;        // find index i, that break ascending rule        for(; i > 0; i--){            if(nums[i] > nums[i - 1]){                break;            }        }        if(i != 0){            int tmp = nums[i - 1];            int j = i;            // find the right place to put nums[i]            for(; j < nums.length; j++){                if(nums[j] <= tmp){                    j--;                    break;                }                else if(j == nums.length - 1){                    break;                }            }            // swap nums[i-1] and nums[j]            nums[i-1] = nums[j];            nums[j] = tmp;        }        // reverse from i to last        int left = i, right = nums.length - 1;        while(left < right){            int tmp = nums[left];            nums[left] = nums[right];            nums[right] = tmp;            left++;            right--;        }        return nums;    }}