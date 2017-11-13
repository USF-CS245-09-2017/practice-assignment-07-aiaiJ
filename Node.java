public class Node{

	// private String data;
	// private Node next;

	private String key;
    private String value;
 
    // Reference to next node
    private Node next;
 
    // Constructor
    public Node(String key, String value){
        this.key = key;
        this.value = value;
    }

	public String getValue() {
		
		return this.value;
	}

	public String getKey(){
		return this.key;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setValue(String value){
		this.value = value;
	}
	public void setKey(String key){
		this.key = key;
	}

}