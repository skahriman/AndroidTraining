
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Solution {
	
	class Node {
		String name;
		ArrayList<Node> child;
		
		public Node(String name) {
			this.name = name;
			child = new ArrayList<>();
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public ArrayList<Node> getChild() {
			return child;
		}
		public void setChild(ArrayList<Node> child) {
			this.child = child;
		}
	}
	
	////////////////////////////
	
	HashMap<String, Node> list;
	HashMap<String, Node> noRootList; //this list contains all elements without root.
	Node[] managers;
	String[] input;
	int size;
	int depth = 0;
	
	public Solution(String[] input){
		this.input = input;
		this.size = input.length;
		list = new HashMap<String, Node>();
		managers = new Node[size];
		noRootList = new HashMap<String, Node>();
	}
	
	public void addToList(Node node) {
		String key = node.getName();
		list.put(key, node);
	}
	
	public void prepare() {
		String[] splittedInput;
		for(int i = 0; i < size; i++) {
			splittedInput = input[i].split(", ");
			Node parent = new Node(splittedInput[0]);
			ArrayList<Node> child = new ArrayList<>();
			
			for(int j = 1; j < splittedInput.length; j++) {
				Node node = new Node(splittedInput[j]);
				addToList(node);
				noRootList.put(node.name, node);
				child.add(node);
			}
			
			parent.setChild(child);
			managers[i] = parent;
		}
		for(int i = 0; i < size; i++) {
			addToList(managers[i]);
		}
	}
	
	public Node getRoot() {
		Node root = null;
		for(int i = 0; i < size; i++) {
			String name = managers[i].getName();
			
			if(noRootList.get(name) == null)
				root = managers[i];
		}
		return root;
	}
	
	public void print(Node parent) {
		depth++;
		int size = parent.getChild().size();
		for(int i = 0; i < size; i++) {
			String name = parent.getChild().get(i).name;
			
			for(int j = 0; j < this.depth; j++){
                System.out.print("    ");
            }
			
			System.out.println(name);
			Node child = list.get(name);
			print(child);
		}
		depth--;
	}
	
	public static void main(String[] args) {
		
		String[] input = {
				"B2, E5, F6", 
				"A1, B2, C3, D4",
				"G7, H8",
				"D4, G7, I9"
		};
		
		Solution s = new Solution(input);
		s.prepare();
		Node root = s.getRoot();
		
		System.out.println(root.name);
		s.print(root);
	}
}







