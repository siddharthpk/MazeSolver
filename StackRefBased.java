public class StackRefBased<T> implements Stack<T> {
	
	private StackNode<T> front;
	private int count;
	
	
    public StackRefBased() {
		front=null;
		count=0;
	}

    public int size() {
        return count;
    }


    public boolean isEmpty() {
        if(front==null){
			return true;
		}
		return false;
    }


    public void push(T data) {
        StackNode<T> n=new StackNode<T>(data);
		if(front==null){
		front=n;}
		else{
		n.next=front;
		front=n;
		}
		count++;
    }


    public T pop() throws StackEmptyException {
        if(front==null){
			throw new StackEmptyException();
		}
		
		T tmp=front.data;
		front=front.next;
		count--;
		return tmp;
		
    }


    public T peek() throws StackEmptyException {
        if(front==null){
			throw new StackEmptyException();
		}
		
		return front.data;
		
    }


    public void makeEmpty() {
		front=null;
		count=0;
    }


    public String toString() {
         
        String s="";
        StackNode p = front;
        if(front==null)
        {
        	s = s + "";
        }
        else
        {
        for(int i=0; i<count; i++)
        {
        	if(i<count-1)
        	{
        	s=s+p.data+" ";
        	}
        	else
        	{
        	s=s+p.data;
        	}
        	p = p.next;
        	}
        	
        }	
        return s;
    }
}