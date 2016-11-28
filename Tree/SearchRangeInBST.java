import java.util.ArrayDeque;import java.util.ArrayList;import java.util.Deque;public class SearchRangeInBST {	public class TreeNode {		      public int val;		      public TreeNode left, right;		      public TreeNode(int val) {		          this.val = val;		          this.left = this.right = null;		     }		  }	/**     * @param root: The root of the binary search tree.     * @param k1 and k2: range k1 to k2.     * @return: Return all keys that k1<=key<=k2 in ascending order.     */    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {        // inorder traversal        ArrayList<Integer> res = new ArrayList<Integer>();        if(root == null) return res;        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();        TreeNode cur = root;        while(!stack.isEmpty() || cur != null){            while(cur != null){                stack.push(cur);                cur = cur.left;            }            cur = stack.pop();            if(cur.val > k2) break;            if(cur.val >= k1 && cur.val <= k2){                res.add(cur.val);            }            cur = cur.right;        }                return res;    }}