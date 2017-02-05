import java.util.*;public class FindRadius {	public int findRadius(int[] houses, int[] heaters) {        if(houses == null || houses.length == 0 || heaters == null || heaters.length == 0){            return Integer.MAX_VALUE;        }        // Solution 1 : greedy, O(n^2) optimized, surprisingly faster than binary search        // Arrays.sort(houses);        // Arrays.sort(heaters);        // // idea: for each house, find the closest heater to that house and update the radius so that it can be reached        // int radius = 0;        // int curHeater = 0;        // for(int i = 0; i < houses.length; i++){        //     int minDis = Integer.MAX_VALUE;        //     for(int j = curHeater; j < heaters.length; j++){        //         if(minDis != Integer.MAX_VALUE && Math.abs(houses[i] - heaters[j]) > minDis){        //             break;        //         }        //         if(minDis > Math.abs(houses[i] - heaters[j])){        //             minDis = Math.abs(houses[i] - heaters[j]);        //             curHeater = j;        //         }        //     }        //     radius = Math.max(radius, minDis);        // }        // return radius;                // Solutions 2 : binary search, O(n logk + k logk)        // idea: for each house, find the its index on heaters line using binary search, so we get the closest heater from it        // update the radius, so it will satisfy each house         Arrays.sort(heaters);        int radius = 0;        for(int i = 0; i < houses.length; i++){            int index = findInsertIndex(houses[i], heaters);            int minDis = Integer.MAX_VALUE;            if(index == 0){                minDis = heaters[0] - houses[i];            } else if (index == heaters.length){                minDis = houses[i] - heaters[heaters.length - 1];            } else {                minDis = Math.min(houses[i] - heaters[index - 1], heaters[index] - houses[i]);            }            radius = Math.max(radius, minDis);        }        return radius;    }        private int findInsertIndex(int num, int[] array){        int left = 0, right = array.length - 1;        while(left + 1 < right){            int mid = left + (right - left) / 2;            if(num == array[mid]){                return mid + 1;            } else if(num > array[mid]){                left = mid;            } else {                right = mid;            }        }        if(num < array[left]){            return left;        } else if(num > array[right]){            return right + 1;        } else {            return right;        }    }}