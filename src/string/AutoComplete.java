package string;


public class AutoComplete {
    static class Node{
        public Node(char c) {
            this.c = c;
        }
        char c;
        Node left;
        Node mid;
        Node right;
        boolean isEnd;        
    }
    
    static class WordTrie{
        Node root;
        void insert(String s) {
            if (s == null || s.length() < 1) {
                return;
            }
            root = insert(root, s, 0);
        }
        
        Node insert(Node n, String s, int pos) {
            if (n == null) {
                n = new Node(s.charAt(pos));
                if (pos + 1 == s.length()) {
                    n.isEnd = true;
                    return n;
                } 
            }
            
            if (pos == s.length()) {
                n.isEnd = true;
                return n;
            }
            
            char c = s.charAt(pos);
            if (c < n.c) {
                n.left = insert(n.left, s, pos);
            } else if(c > n.c) {
                n.right = insert(n.right, s, pos);
            } else {
                n.mid = insert(n.mid, s, pos+1);
            }
            return n;
        }
        
        boolean isIn(String str, int pos, Node n) {
            if (pos == str.length()) return true;
            if (n == null) return false;
            char c = str.charAt(pos);
            if (c == n.c) {
                return isIn(str, pos + 1, n.mid);
            } else if (c < n.c) {
                return isIn(str, pos, n.left);
            } else {
                return isIn(str, pos, n.right);
            }
        }
    }

    public static void main(String[] args) {
        WordTrie t = new WordTrie();
        t.insert("abc");
        t.insert("acb");
        System.out.println(t.isIn("abc", 0, t.root));
    }

}
