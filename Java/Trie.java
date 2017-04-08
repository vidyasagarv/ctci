public class Trie{

	private static class TrieNode{

		private HashMap<Character, TrieNode> children;
		private boolean terminates = false;

		private char character;

		public TrieNode() {
			children = new HashMap<>();
		}

		public TrieNode(char character) {
			this();
			this.character = character;
		}

		public char getChar() {
			return character;
		}

		public void addWord(String word) {
			if (word == null || word.isEmpty()) {
				return;
			}

			char firstChar = word.charAt(0);

			TrieNode child = getChild(firstChar);
			if (child == null) {
				child = new TrieNode(firstChar);
				children.put(firstChar, child);
			}

			if (word.length() > 1) {
				child.addWord(word.substring(1));
			} else{
				child.setTerminates(true);
			}
		}

		public TrieNode getChild(char c) {
			return children.get(c);
		}

		public boolean terminates() {
			return terminates;
		}

		public void setTerminates(boolean t) {
			terminates = t;
		}
	}

	// Root of the trie
	private TrieNode root;

	public Trie(ArrayList<String> list) {
		root = new TrieNode();
		for (String word : list) {
			root.addWord(word);
		}
	}

	public Trie(String[] list) {
		root = new TrieNode();
		for (String word : list) {
			root.addWord(word);
		}
	}

	public boolean contains(String prefix, boolean exact) {
		TrieNode lastNode = root;
		int i = 0;
		for (i = 0; i < prefix.length(); ++i) {
			lastNode = lastNode.getChild(prefix.charAt(i));
			if (lastNode == null) {
				return false;
			}
		}
		return !exact || lastNode.terminates();
	}

	public boolean contains(String prefix){
		return contains(prefix, false);
	}

	public TrieNode getRoot() {
		return root;
	}
}