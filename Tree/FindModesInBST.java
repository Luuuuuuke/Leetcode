import java.util.*;public class FindModesInBST {	public class TreeNode {		      int val;		      TreeNode left;		      TreeNode right;		      TreeNode(int x) { val = x; }		  }	int max, count;    Integer val;    public int[] findMode(TreeNode root) {        if(root == null){            return new int[0];        }        ArrayList<Integer> res = new ArrayList<Integer>();        // do in-order traversal        traverse(root, res);        if(count == max){            res.add(val);        } else if(count > max){            res.clear();            res.add(val);        }        int[] result = new int[res.size()];        for(int i = 0; i < res.size(); i++){            result[i] = res.get(i);        }                return result;    }        private void traverse(TreeNode root, ArrayList<Integer> res){        if(root == null) return;        if(root.left != null){            traverse(root.left, res);        }        if(val == null || val == root.val) {            val = root.val;            count++;        } else if (count == max){            res.add(val);            val = root.val;            count = 1;        } else if (count > max){            res.clear();            res.add(val);            max = count;            val = root.val;            count = 1;        } else if (count < max){            val = root.val;            count = 1;        }        if(root.right != null){            traverse(root.right, res);        }    }}