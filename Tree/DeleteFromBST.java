public class DeleteFromBST {	class TreeNode{		TreeNode left, right;		int val;		TreeNode(int val){			this.val = val;		}	}	public TreeNode deleteNode(TreeNode root, int key) {        if(root == null) return null;        // find its parent node		if(root.val == key){			if(root.left == null && root.right == null){				return null;			} else if(root.right == null){				return root.left;			} else {				TreeNode del_left = root.left;				TreeNode del_right = root.right;				TreeNode cur = del_right;				while(cur.left != null){					cur = cur.left;				}				cur.left = del_left;				return del_right;			}		} else {			TreeNode parent = findParent(root, key);			if(parent == null) return root;			TreeNode del;			boolean isLeft;			if(key > parent.val){				del = parent.right;				isLeft = false;			} else {				del = parent.left;				isLeft = true;			}			// 3 situation: 1. no left child and right child; 2. no right child; 3 no left child or have both			if(del.left == null && del.right == null){				if(isLeft){					parent.left = null;				} else {					parent.right = null;				}			} else if(del.right == null){				if(isLeft){					parent.left = del.left;				} else {					parent.right = del.left;				}			} else {				TreeNode del_left = del.left;				TreeNode del_right = del.right;				TreeNode cur = del_right;				while(cur.left != null){					cur = cur.left;				}				cur.left = del_left;				if(isLeft){					parent.left = del_right;				} else {					parent.right = del_right;				}			}			return root;		}    }        public TreeNode findParent(TreeNode root, int target){		if(root == null) return null;		if(root.left != null && root.left.val == target) return root;		if(root.right != null && root.right.val == target) return root;		if(root.val < target){			return findParent(root.right, target);		}		else{			return findParent(root.left, target);		}	}}