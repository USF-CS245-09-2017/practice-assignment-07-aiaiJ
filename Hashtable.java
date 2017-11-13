import java.util.ArrayList;
public class Hashtable{

	private ArrayList<Node> bucketArray;
 
    private int numBuckets;
 
    private int size;
 
    public Hashtable()
    {
        bucketArray = new ArrayList<>();
        numBuckets = 314528;
        size = 0;
 
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }
 
    public int size() 
    { 
    	return size; 

    }
    public boolean isEmpty() 
    { 
    	return size() == 0; 

    }
 
    private int getBucketIndex(String key)
    {
        int hashCode = key.hashCode();
        hashCode = Math.abs(hashCode);
        int index = hashCode % numBuckets;
        return index;
    }
 
    public String remove(String key)
    {
        int bucketIndex = getBucketIndex(key);
 
        Node head = bucketArray.get(bucketIndex);
 
        Node prev = null;
        
        while (head != null)
        {
            if (head.getKey().equals(key))
                break;
             prev = head;
            head = head.getNext();
        }
 
        if (head == null)
            return null;
 
        size--;
 
        if (prev != null)
            prev.setNext(head.getNext());
        else
            bucketArray.set(bucketIndex, head.getNext());
 
        return head.getValue();
    }
 
    public String get(String key)
    {
        int bucketIndex = getBucketIndex(key);
        Node head = bucketArray.get(bucketIndex);
 
        while (head != null)
        {
            if (head.getKey().equals(key))
                return head.getValue();
            head = head.getNext();
        }
 
        return null;
    }
   	public boolean contains(String key)
   	{
   		if(get(key) != null){
   			return true;
   		}
   		return false;
   	}

   	public boolean containsKey(String key)
   	{
   		return contains(key);
   	}
 
    public void put(String key, String value)
    {
        int bucketIndex = getBucketIndex(key);
        Node head = bucketArray.get(bucketIndex);
 
        while (head != null)
        {
            if (head.getKey().equals(key))
            {
                head.setValue(value);
                return;
            }
            head = head.getNext();
        }
 
        size++;
        head = bucketArray.get(bucketIndex);
        Node newNode = new Node(key, value);
        newNode.setNext(head);
        bucketArray.set(bucketIndex, newNode);

    }
}