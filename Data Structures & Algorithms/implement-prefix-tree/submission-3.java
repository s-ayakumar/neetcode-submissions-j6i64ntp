public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}
class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray())
        {
            int i = c - 'a';
            if (curr.children[i] == null)
            {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        char[] charArr = word.toCharArray();
        for (int i = 0; i < charArr.length; i++)
        {   
            char c = charArr[i];
            int j = c - 'a';
            if (curr.children[j] == null) 
            {
                return false;
            }
            curr = curr.children[j];
        }

        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        char[] charArr = prefix.toCharArray();

        for (int i = 0; i < charArr.length; i++)
        {
            int j = charArr[i] - 'a';
            if (curr.children[j] == null)
            {
                return false;
            }   
            curr = curr.children[j];
        }

        return true;
    }
}
