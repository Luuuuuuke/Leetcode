import java.util.ArrayList;import java.util.HashMap;import java.util.List;public class WordSearch2 {	/**     * @param board: A list of lists of character     * @param words: A list of string     * @return: A list of string     */    private class TrieNode{        public String s;        public boolean isString;        public HashMap<Character, TrieNode> childs;                TrieNode(){            s = "";            isString = false;            childs = new HashMap<Character, TrieNode>();        }    }        private class TrieTree{        TrieNode root;                TrieTree(TrieNode root){            this.root = root;        }                public void insert(String s){            char[] chs = s.toCharArray();            TrieNode cur = this.root;            for(int i = 0; i < chs.length; i++){                if(!cur.childs.containsKey(chs[i])){                    cur.childs.put(chs[i], new TrieNode());                }                cur = cur.childs.get(chs[i]);            }            cur.s = s;            cur.isString = true;        }                public boolean find(String s){            char[] chs = s.toCharArray();            TrieNode cur = root;            for(int i = 0; i < chs.length; i++){                if(!cur.childs.containsKey(chs[i])) return false;                cur = cur.childs.get(chs[i]);            }            return cur.isString;        }    }        int[] dx = {0,-1,0,1};    int[] dy = {-1,0,1,0};    public void search(char[][] board, TrieNode root, int x, int y, List<String> res){        if(root != null && root.isString && !res.contains(root.s)) {            res.add(root.s);        }        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || root == null || board[x][y] == '0') return;        if(root.childs.containsKey(board[x][y])){            for(int d = 0; d < 4; d++){                char tmp = board[x][y];                board[x][y] = '0';                search(board, root.childs.get(tmp), x + dx[d], y + dy[d], res);                board[x][y] = tmp;            }        }    }        public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {        ArrayList<String> res = new ArrayList<String>();        TrieNode root = new TrieNode();        TrieTree tree = new TrieTree(root);        for(String word : words){            tree.insert(word);        }        for(int i = 0; i < board.length; i++){            for(int j = 0; j < board[0].length; j++){                search(board, tree.root, i, j, res);            }        }        return res;    }}