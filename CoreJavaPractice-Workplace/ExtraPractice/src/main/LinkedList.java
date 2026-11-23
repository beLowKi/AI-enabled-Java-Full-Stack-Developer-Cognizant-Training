package main;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


// Utility for LinkedList;
// contains value and reference to successor node.
class Node<E> {
	private E value;
	private Node<E> next;
	
	
	Node() {}
	
	
	Node(E value) {
		this.value = value;
		this.next = null;
	}
	
	
	Node(E value, E nextValue) {
		this(value);
		this.linkTo(nextValue);
	}
	
	
	Node(E value, Node<E> nextNode) {
		this(value);
		this.linkTo(nextNode);
	}
	
	
	// Creates a new successor Node which contains the given value.
	public void linkTo(E nextValue) {
		this.next = new Node<E>(nextValue);
	}
	
	
	// Links this Node to the given successor Node.
	public void linkTo(Node<E> nextNode) {
		this.next = nextNode;
	}
	
	
	// Unlinks this Node from its successor.
	// This method does nothing if the Node has no successor.
	public void removeNext() {
		this.next = null;
	}
	
	
	// Returns the value stored in this Node.
	public E getValue() {
		return this.value;
	}
	
	
	// Sets the value of this Node.
	public void setValue(E value) {
		this.value = value;
	}
	
	
	// Returns this Node's successor or null if it doesn't have one.
	public Node<E> getNext() {
		return this.next;
	}
}


// Base, abstract class for LinkedList iterators that utilize Node pointers
abstract class LinkedIterator<E, T> implements Iterator<T> {
	
	// Reference to list is kept to detect root changes
	protected LinkedList<E> list;
	
	// Iteration state variables
	protected Node<E> node;
	protected Node<E> prevNode;
	
	// Tracks whether current Node has been seen during iteration
	protected boolean checkedCurrent;
	
	
	public LinkedIterator(LinkedList<E> list, Node<E> root) throws NullPointerException {
		this.list = list;
		this.rebase(root);
	}
	
	
	@Override
	public boolean hasNext() {
//		System.out.println("Here cC=" + this.checkedCurrent + " gN=" + this.node.getNext());
		return this.node != null && ( !this.checkedCurrent || this.node.getNext() != null );
	}

	
	@Override
	public void remove() {
		
		// Link previous to next and rebase
		if ( this.prevNode != null ) {
			this.prevNode.linkTo(this.node.getNext());
			this.rebase(prevNode);
			return;
		}
		
		// 'next' always results in a defined prevNode or checkCurrent=true
		if (!this.checkedCurrent) {
			throw new IllegalStateException("it.next() has not been called");
		}
		
		// Rebasing to new root node, which any state that's 
		// reached this code should be at
		assert(this.list.isRoot(this.node));
		
//		System.out.println(this.node + "=" + this.node.getValue());
		
		this.rebase(this.node.getNext());
		this.list.remove(0);
	}
	
	
	// Resets iterator to the given node.
	// Used to update state post-remove
	public void rebase(Node<E> node) {
		this.node = node;
		this.prevNode = null;
		this.checkedCurrent = false;
	}
}


//Utility for LinkedList;
//supports internal iteration of Nodes' values
class NodeValueIterator<E> extends LinkedIterator<E, E> {
	
	public NodeValueIterator(LinkedList<E> list, Node<E> root) {
		super(list, root);
	}
	
	@Override
	public E next() {
		if ( !this.hasNext() ) {
			throw new NoSuchElementException();
		}
		
		if ( !this.checkedCurrent ) {
			this.checkedCurrent = true;
		} else {
			this.prevNode = this.node;
			this.node = this.node.getNext();
		}
		
//		System.out.println("It returning " + this.node.getValue());
		
		return this.node.getValue();		
	}
	
}


//Utility for LinkedList;
//supports internal iteration of Nodes
class NodeIterator<E> extends LinkedIterator<E, Node<E>> {

	public NodeIterator(LinkedList<E> list, Node<E> root) throws NullPointerException {
		super(list, root);
	}
	
	@Override
	public Node<E> next() {
		if ( !this.hasNext() ) {
			throw new NoSuchElementException();
		}
		
		if ( !this.checkedCurrent ) {
			this.checkedCurrent = true;
		} else {
			this.prevNode = this.node;
			this.node = this.node.getNext();
		}
		
		return this.node;
	}
}


/**
 * <h2>
 * Implementation of linked list data structure.
 * Methods are based on {@link ArrayList} documentation.
 * </h2>
 */
public class LinkedList<E extends Object> extends AbstractList<E> implements List<E> {
	
	// First Node of the list.
	private Node<E> root;
	
	
	// Default constructor
	public LinkedList() {}
	
	
	// Initialises LinkedList with the given values
	public LinkedList(Collection<? extends E> values) throws NullPointerException {
		this();
		
		if (values == null) {
			throw new NullPointerException();
		}
		
		this.addAll(values);
	}

	
	@Override
	public Iterator<E> iterator() {
		return new NodeValueIterator<E>(this, this.root);
	}
	
	
	// Returns an iterator for link Nodes.
	private NodeIterator<E> nodesIt() {
		return new NodeIterator<E>(this, this.root);
	}
	
	
	@Override
	public boolean equals(Object o) {
		return Arrays.asList(this.toArray()).equals(o);
	}
	
	
	/**
	 * Adds a value to the end of the list.
	 * 
	 * @param value New Value
	 * @return true if successful; otherwise false
	 */
	@Override
	public boolean add(E value) {
		
		// Creating root
		if (this.isEmpty()) {
			this.root = new Node<E>(value);
			return true;
		}
		
//		System.out.println(this.root + " -> " + this.root.getValue() + " & " + this.root.getNext());
		
		// Travelling to the end of the list 
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); ) {
			Node<E> node = it.next();
//			System.out.println(node + " -> " + node.getValue());
			
			// Appending and breaking
			if ( node.getNext() == null ) {
//				System.out.println("Linking " + value);
				node.linkTo(value);
				return true;
			}
			
		}
		
		return false;
	}
	
	
	/**
	 * Adds a value to the specified index (negatives not supported).
	 * Any existing value is shifted to the right.
	 * 
	 * @param index Target index
	 * @param value New Value
	 * @throws IndexOutOfBoundsException If provided index is greater than size of list
	 */
	public void add(int index, E value) throws IndexOutOfBoundsException {
		
		// Catching negative indexes
		if ( index < 0 ) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		
		// Catching empty lists
		if ( this.isEmpty() && index > 0 ) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		
		// Node to be inserted
		final Node<E> newNode;
		
		// Catching index 0 (new root)
		if ( index == 0 ) {
			this.root = new Node<E>(value, this.root);
			return;
		}
		
		// Stores Node from previous iteration for the post-insert shuffling
		Node<E> prevNode = null;
		int count = 0;
		
		// Traversing nodes
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); ) {
			final Node<E> node = it.next();
			
			if ( count == index ) {
				
				// prevNode should only ever be null for index = 0
				// which is caught before the loop
				assert(prevNode != null);
				
				// Inserting and "shuffling" pre-existing
				// Node so its predecessor points to this new one instead
				newNode = new Node<E>(value, node);
				prevNode.linkTo(newNode);
				
				return;
			}
			
			prevNode = node;
			count++;
		}
		
		// If index is size + 1, then it's treated as normal add
		if ( index == count ) {
			prevNode.linkTo(value);
			return;
		}
		
		throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
	}
	
	
	/**
	 * Alias of {@link #add(int, Object)}.
	 * 
	 * @param index Target index
	 * @param value New Value
	 * @throws IndexOutOfBoundsException If provided index is greater than size of list
	 */
	public void insert(int index, E value) {
		this.add(index, value);
	}
	
	
	/**
	 * Adds all of the given values to the end of the list.
	 * 
	 * @param c Collection of values
	 * @return true if success; otherwise false
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		
		Node<E> lastNode = null;
		
		// Empty list creates root Node.
		// The shuffling is to prevent needing to pop a value
		// from c (which could be any Object that implements Collection)
		if ( this.isEmpty() ) {
			final Node<E> tmp = new Node<>();
			this.root = tmp;
			
			LinkedList.addAll(tmp, c);
			this.root = tmp.getNext();
			
			return true;
			
		}
		
		// Travelling to last node for bulk add
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); ) {
			lastNode = it.next();
		}
		
		// Adding new nodes
		LinkedList.addAll(lastNode, c);
		
		return true;
	}
	
	
	// Creates and attaches new Nodes for the given collection to a base node
	private static <E> void addAll(
			Node<E> baseNode, 
			Collection<? extends E> c
	) throws NullPointerException {
		
		if ( baseNode == null ) {
			throw new NullPointerException();
		}
		
		// Adding new nodes
		Node<E> currNode = baseNode;
		Node<E> tailNode = baseNode.getNext();
		
		final List<Node<E>> newNodes = c.stream()
				.map(e -> new Node<E>(e))
				.toList();
		
		for ( int i = 0; i < newNodes.size(); i++ ) {
			final Node<E> node = newNodes.get(i);
			
			if ( currNode != null ) {
				currNode.linkTo(node);
			}
			
			currNode = node;
		}
		
		// Adds tails--continuing the link when inserting
		currNode.linkTo(tailNode);
	}
	
	
	/**
	 * Adds all of the given values to the list at the given index.
	 * Any pre-existing values are shifted to the right.
	 * 
	 * @param index Target index
	 * @param c Collection of values
	 * @return true if success; otherwise false
	 * @throws IndexOutOfBoundsException If provided index is greater than size of list
	 */
	public boolean addAll(int index, Collection<? extends E> c) throws IndexOutOfBoundsException {
		
		// Catching negative indexes
		if ( index < 0 ) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		
		// Catching 0 index inserts
		if ( index == 0 ) {
			// No root to prepend to, this is a regular addAll
			if ( this.isEmpty() ) return this.addAll(c);
			
			// Temp node is prepended so the static addAll can be reused.
			// Creating a non-empty base node would require popping a value from
			// the collection (so no duplicate) which there's no easy universal way to do.
			// It's much easier to just use a dummy Node.
			final Node<E> tmp = new Node<E>();
			tmp.linkTo(this.root);
			LinkedList.addAll(tmp, c);
			this.root = tmp.getNext();
			
			return true;
		}
		
		final Node<E> baseNode = this.nodeAt(index - 1);
		if ( baseNode == null ) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		
		LinkedList.addAll(baseNode, c);
		
		return true;
	}
	
	
	/**
	 * Sets the value at the given index.
	 * 
	 * @param index Target index
	 * @param value New Value
	 * @return The added value
	 * @throws IndexOutOfBoundsException If provided index is greater than size of list
	 */
	@Override
	public E set(int index, E value) throws IndexOutOfBoundsException {
		final Node<E> node = nodeAt(index);
		if (node == null) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		
		node.setValue(value);
		return node.getValue();
	}
	
	
	/**
	 * Returns the value at the given index.
	 * 
	 * @param index Target Index
	 * @return Value at the index
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		final Node<E> node = nodeAt(index);
		if (node == null) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		
		return node.getValue();
	}
	
	
	/**
	 * Returns the first index where the given value is found
	 * in the list or -1 if it's not present.
	 * 
	 * @param value Value to search for
	 * @return First index whose value matches input or -1
	 */
	@Override
	public int indexOf(Object o) {
		
		// Catching empty list
		if ( this.isEmpty() ) {
			return -1;
		}
		
		int index = 0;
		
		// Traversing nodes
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); index++ ) {
			
			final Node<E> node = it.next();
			
			if ( Objects.equals(o, node.getValue()) ) {
				return index;
			}
			
		}
		
		return -1;
	}
	
	
	/**
	 * Returns the first index whose respective Node's
	 * value satisfies the given {@link Predicate}.
	 * 
	 * @param pred Search criteria
	 * @return First index whose value matches input or -1
	 */
	public int find(Predicate<? super E> pred) {
		
		// Catching empty list
		if ( this.isEmpty() ) {
			return -1;
		}
		
		int index = 0;
		
		// Traversing nodes
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); index++ ) {
			final Node<E> node = it.next();
			if ( pred.test(node.getValue()) ) {
				return index;
			};
		}
		
		return -1;
	}
	
	
	/**
	 * Returns the last index whose respective Node's
	 * value satisfies the given {@link Predicate}.
	 * 
	 * @param pred Search criteria
	 * @return First index whose value matches input or -1
	 */
	public int findLast(Predicate<? super E> pred) {
		// Catching empty list
		if ( this.isEmpty() ) {
			return -1;
		}
		
		int lastMatch = -1;
		int index = 0;
		
		// Traversing nodes
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); index++ ) {
			final Node<E> node = it.next();
			if ( pred.test(node.getValue()) ) {
				lastMatch = index;
			};
		}
		
		return lastMatch;
	}
	
	
	/**
	 * Returns the last index where the given value is found
	 * in the list or -1 if it's not present.
	 * 
	 * @param value Value to search for
	 * @return Last index whose value matches input or -1
	 */
	@Override
	public int lastIndexOf(Object o) {
		
		// Catching empty list
		if ( this.isEmpty() ) {
			return -1;
		}
		
		int index = 0;
		int lastMatch = -1;
		
		// Traversing nodes
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); index++ ) {
			final Node<E> node = it.next();
			if ( Objects.equals(o, node.getValue()) ) {
				lastMatch = index;
			};
		}
		
		return lastMatch;
	}
	
	
	/**
	 * Returns if the list contains 0 values
	 */
	@Override
	public boolean isEmpty() {
		return this.root == null;
	}
	
	
	/**
	 * Deletes all values from the list.
	 * Note that object values whose references are stored elsewhere
	 * will not be deleted.
	 */
	@Override
	public void clear() {
		this.root = null;
	}
	
	
	/**
	 * Deletes the value at the given index.
	 * 
	 * @param index Target index
	 * @return Deleted value
	 * @throws IndexOutOfBoundsException If provided index is greater than size of list
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		
		// Catching negative indexes and empty lists
		if ( index < 0 || this.isEmpty() ) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		
		// Value of removed Node
		final E removedValue;
		
		// Catching index 0
		// NOTE works even if root doesn't have successor because it will be null
		if ( index == 0 ) {
			if (this.root == null) {
				throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
			}
			
			removedValue = this.root.getValue();
			this.root = this.root.getNext();
			return removedValue;
		}
		
		// Stores Node from previous iteration for shuffling
		Node<E> prevNode = null;
		int count = 0;
		
		// Traversing nodes
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); ) {
			final Node<E> node = it.next();
			
			// Linking previous to this node's successor; effictively deleting it
			if ( count == index ) {
				removedValue = node.getValue();
				this.unlinkNode(prevNode, node);
				return removedValue;
			}
			
			prevNode = node;
			count++;
		}
		
		throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
	}
	
	
	/**
	 * Deletes the first occurrence of the given value from the list.
	 * This method does nothing if no occurrence is found.
	 * 
	 * @param value Target value
	 * @return true if delete happened; otherwise false
	 */
	@Override
	public boolean remove(Object o) {
		
		// Catching when list is empty
		if ( this.root == null ) {
			return false;
		}
		
		Node<E> prevNode = null;
		
		// Traversing nodes
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); ) {
			final Node<E> node = it.next();
			
			if ( Objects.equals(o, node.getValue()) ) {
				
				this.unlinkNode(prevNode, node);
				
				return true;
			}
			
			prevNode = node;
		}
		
		return false;
	}
	
	
	/**
	 * Deletes values from the list that satisfy the given {@link Predicate}.
	 * 
	 * @param filter Predicate that returns true for values that should be deleted
	 * @return true if delete happened; otherwise false
	 */
	public boolean removeIf(Predicate<? super E> filter) {
		
		// Catching empty lists
		if ( this.isEmpty() ) {
			return false;
		}
		
		Node<E> prevNode = null;
		boolean removedOnce = false;
		
		// Traversing nodes
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); ) {
			final Node<E> node = it.next();
			
			// No match; go next
			if ( !filter.test(node.getValue()) ) {
				prevNode = node;
				continue;
			}
			
			removedOnce = true;
			this.unlinkNode(it, prevNode, node);
		}
		
		return removedOnce;
	}
	
	
	/**
	 * Replaces all list values with the result of applying the given
	 * operator to them.
	 */
	@Override
	public void replaceAll(UnaryOperator<E> operator) {
		
		// Catching empty list
		if ( this.isEmpty() ) {
			return;
		}
		
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); ) {
			final Node<E> node = it.next();
			node.setValue(operator.apply(node.getValue()));
		}
	}
	
	
	/**
	 * Expands list to have at least as many nodes as the given number.
	 * This method does nothing if the list's size is already at or above the input.
	 * 
	 * @param minCapacity Target size
	 */
	public void ensureCapacity(int minCapacity) throws IllegalArgumentException {
		this.ensureCapacity(minCapacity, null);
	}
	
	
	/**
	 * Expands list to have at least as many nodes as the given number.
	 * This method does nothing if the list's size is already at or above the input.
	 * 
	 * @param minCapacity Target size
	 * @param filler Value given to added Nodes
	 */
	public void ensureCapacity(int minCapacity, E filler) {
		// Catches negative capacity
		if ( minCapacity < 0 ) {
			throw new IllegalArgumentException("Capacity must be non-negative number");
		}
		
		// Catches 0 capacity
		if ( minCapacity == 0 ) {
			this.root = null;
			return;
		}
		
		// Initializes empty list
		if ( this.isEmpty() ) {
			this.root = new Node<E>(filler);
		}
		
		// Appending Nodes until at capacity;
		// starts at 1 for the root Node.
		int size = 1;
		
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); size++ ) {
			final Node<E> node = it.next();
			if ( size < minCapacity && !it.hasNext() ) {
				node.linkTo(new Node<E>(filler));
			}
		}
	}
	
	
	/**
	 * Deletes nodes with null value.
	 */
	public void trimToSize() {
		this.removeIf(v -> Objects.equals(v, null));
	}
	
	
	/**
	 * Performs the given action for each value in the list or
	 * until an exception is thrown.
	 */
	public void forEach(Consumer<? super E> action) {
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); ) {
			action.accept(it.next().getValue());
		}
	}
	
	
	/**
	 * Returns the number of values in the list.
	 */
	@Override
	public int size() {
		
		// Catching empty list
		if ( this.isEmpty() ) {
			return 0;
		}
		
		int count = 0;
				
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); count++ ) {
			it.next();
		}
		
		return count;
	}
	
	
	// Returns if the given Node is this list's root.
	// Mostly used internally.
	public boolean isRoot(Node<E> node) {
		return node == this.root;
	}
	
	
	/**
	 * Returns the Node at the given index or null if index is out of bounds.
	 * Negative indexes are not supported and will always return null.
	 */
	private Node<E> nodeAt(int index) {
		
		// Catching negatives and empty lists
		if (index < 0 || this.isEmpty()) return null;
				
		// Traversing nodes
		int count = 0;
		
		for ( final NodeIterator<E> it = this.nodesIt(); it.hasNext(); count++ ) {
			final Node<E> node = it.next();
			if ( count == index ) return node;
		}
		
		return null;
	}

	
	// Removes a Node from the link
	private Node<E> unlinkNode(Node<E> prevNode, Node<E> node) {
		final Node<E> next = node.getNext();
		
		// Updating root
		if ( node == this.root ) {
			this.root = next;
			prevNode = next;
			
		// Deleting middle/end node
		} else {
			assert(prevNode != null);
			
//			System.out.println("\nRemoving " + node + " -> " + next);
//			System.out.println("Connecting predecessor " + prevNode + " to " + next);
			
			// NOTE doesn't update prevNode because of the rebase
			prevNode.linkTo(next);
			
//			System.out.println("New predecessor (" + prevNode.getValue() + ") -> " + prevNode.getNext());
		}
		
		return prevNode;
	}
	
	
	// Removes a Node from the link while updating its respective iterator
	private Node<E> unlinkNode( NodeIterator<E> it, Node<E> prevNode, Node<E> node ) {
		it.rebase(this.unlinkNode(prevNode, node));
		
		return prevNode;
	}
}	
