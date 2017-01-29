import java.util.HashMap;public class ConnectingGraph3 {	HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();    int count;    public ConnectingGraph3(int n) {        this.count = n;        for(int i = 1; i <= n; i++){            parent.put(i, i);        }    }    public void connect(int a, int b) {        int p1 = find(a);        int p2 = find(b);        if(p1 != p2){            parent.put(p1, p2);            count--;        }    }            public int query() {        return count;    }        public int find(int a){        int father = parent.get(a);        while(father != parent.get(father)){            father = parent.get(father);        }        int next = parent.get(a);        while(next != father){            int tmp = parent.get(next);            parent.put(next, father);            next = tmp;        }        return father;    }}