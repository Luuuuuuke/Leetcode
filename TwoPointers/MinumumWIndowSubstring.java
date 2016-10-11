public class MinumumWIndowSubstring {	 public void initTargetHash(String target, int[] targetHash){	        char[] chs = target.toCharArray();	        for(char ch : chs){	            targetHash[ch]++;	        }	    }	    	    public boolean containsAll(int[] sourceHash, int[] targetHash){	        for(int i = 0; i < targetHash.length; i++){	            if(targetHash[i] > sourceHash[i]) return false;	        }	        return true;	    }	    /**	     * @param source: A string	     * @param target: A string	     * @return: A string denote the minimum window	     *          Return "" if there is no such a string	     */	    public String minWindow(String source, String target) {	        if(source.length() < target.length()) return "";	        int[] sourceHash = new int[256];	        int[] targetHash = new int[256];	        int left = 0, right = 0;	        int min = Integer.MAX_VALUE, minLeft = 0, minRight = 0;	        initTargetHash(target, targetHash);	        // create window bounded by left and right	        for(; right < source.length(); right++){	            sourceHash[source.charAt(right)]++;	            if(containsAll(sourceHash, targetHash)){	                if(right - left + 1 < min){	                    min = right - left + 1;	                    minLeft = left;	                    minRight = right;	                }	                sourceHash[source.charAt(left)]--;	                left++;	                while(left <= right){	                    if(containsAll(sourceHash, targetHash)){	                        if(right - left + 1 < min){	                            min = right - left + 1;	                            minLeft = left;	                            minRight = right;	                        } 	                    }	                    else break;	                    sourceHash[source.charAt(left)]--;	                    left++;	                }	            }	        }	        if(min == Integer.MAX_VALUE) return "";	        else return source.substring(minLeft, minRight+1);	    }}