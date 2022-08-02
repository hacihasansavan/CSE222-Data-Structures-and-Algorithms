package hmw1;

import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;


public class LDLinkedList <E> extends AbstractList<E> implements List<E>{

	private static class Node<E>{
		E data;
		Node<E> next;		
		Node(E nData){
			this.data = nData;
			this.next = null;

		}
		private Node(E dataItem , Node<E> nodeRef ){
			data = dataItem;
			next = nodeRef;
		}
		
	}
	private int size=0;
	private int delSize=0;
	private Node<E> head = null;
	private Node<E> deletedHead=null;
	public LDLinkedList(){
		
	}

    /**
     * Theta(N)
     * */
	@Override
	public E get(int index) {
		checkPositionIndex(index);
    	return getNode(head,index).data;
	}
    /**
     * Theta(1)
     * */
	public int delSize() {
		return delSize;
	}
    /**
     * Theta(1)
     * */
	@Override
	public int size() {
		return size;
	}
    /**
     * Theta(1)
     * */
	@Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }
    /**
     * Theta(N)
     * */
	public void add(int index, E newData) {
		checkPositionIndex(index);				 //if index is not proper then throws error
		Node<E> node=null;
		if(head==null) { 						//linked list is empty
			addFirst(newData);
			//System.out.println("head: "+ head.data);
		}
		else{
			Node<E> prevNode=null;
			node = checkAllNodes(newData);
			if(node!=null) {
				prevNode = getNode(head,index-1);
				addAfter(prevNode, node);
				size++;
				
			}
			else {
				node = getNode(head,index-1);
				addAfter(node,newData);	
			}
			
		}
	}
	
    /**
     * O(N)
     * */
	//checks if the given data was in the deleted nodes
	private Node<E> checkAllNodes(E newData){
		Node<E> iter = deletedHead;
		while(deletedHead!=null && iter.next!=null) {
			
			if(iter.data == newData)
				return iter;
			
			iter=iter.next;
		}
		return null;
	}
    /**
     * Theta(1)
     * */
	private void addFirst(E item) {
		 head = new Node<E>(item, head);
		 size++;
	 }
    /**
     * Theta(1)
     * */
	private void addAfter(Node<E> node, E item) {
		 node.next = new Node<E>(item, node.next);
		 size++;
	 }
    /**
     * Theta(1)
     * */
	private void addAfter(Node<E> node, Node<E> nNode) {
		
		if(node == null) { //tek eleman var 
			//node = new Node<E>(nNode.data);
			nNode.next = null;
			node = nNode;
		}
		else {
			nNode.next = node.next;
			node.next = nNode;
		}
		
	 }
    /**
     * Theta(1)
     * */
    private void checkPositionIndex(int index) {
    	if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("heyyo");
    }
    /**
     * Theta(1)
     * */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }
    /**
     * O(N)
     * */
    @Override
    public E set(int index, E element) {
    	checkPositionIndex(index);	
    	if(head == null) {
    		head = new Node<E>(element);
    		head.next = null;
    	}
    	else {
    		Node<E> node = getNode(head,index);
    		node.data = element;
    	}
        
        return null;
    }
    
    /**
     * O(N)
     * */
    public E remove(int index) {
    	checkPositionIndex(index); //if index is not proper then throws error
    	E rValue=null;
    	if(index==0) {
    		rValue = head.data;
    		Node<E> temp = head;
    		
    		if(head.next!=null)
    			head = head.next;
    		else head = null;
    		
    		addAfter(deletedHead, temp);	
    		delSize++;
    	}
    	else {
    		Node<E> preNode = getNode(head,index-1);
    		Node<E> node = getNode(head,index);
    		preNode.next = node;
    		rValue = node.data;
    		addAfter(deletedHead, node);
    		delSize++;
    	}
    	size--;
    	//delSize++;
    	return rValue;
    }

    /**
     * Theta(N)
     * */
    private Node<E> getNode(Node<E> startNode,int index) {
    	Node<E> node = startNode;
    	for (int i=0; i<index && node != null; i++)
    		node = node.next;
    	return node;
    }
    
}
