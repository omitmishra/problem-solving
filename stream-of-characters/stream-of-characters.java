class StreamChecker {

   class TreeNode {
        public boolean end = false;
        public TreeNode[] letters;
        public TreeNode () {
            this.letters = new TreeNode[26];
        }
    }
    
    private TreeNode root;    
    private StringBuilder sb;
    
    public StreamChecker(String[] words) {
        root = new TreeNode();
        sb = new StringBuilder();
        
        for (var word : words) {
            insert(word);
        }
    }
    
    public void insert(String word) {
        TreeNode currNode = root;
        word = new StringBuilder(word).reverse().toString(); //insert from the back
        
        for (char c : word.toCharArray()) {
            if (currNode.letters[c - 'a'] == null) {
                currNode.letters[c - 'a'] = new TreeNode();
            }
            currNode = currNode.letters[c - 'a'];
        }
        currNode.end = true;
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TreeNode currNode = root;
        
        for (int i = sb.length()-1; i >= 0; i--) {
            if (currNode == null)
                break;
            
            char c = sb.charAt(i);
            currNode = currNode.letters[c - 'a'];
            
            if (currNode != null && currNode.end)
                return true;
        }   
        return false;
    }

}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */