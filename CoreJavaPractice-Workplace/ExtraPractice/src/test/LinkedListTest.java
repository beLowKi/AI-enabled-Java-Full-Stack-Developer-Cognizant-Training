/**
 * AI-assisted code using GitHub Copilot.
 * 
 * 
 * Prompts used:
 * 
 * Generate test cases for all implemented methods of LinkedList. Each method's tests must include:
 * 
 * 1. Tests for expected input for each parameters; i.e., a positive, in-range int for index parameters
 * 2. Tests for invalid/unexpected inputs for each parameter; i.e., negative or out-of-range int for index parameters
 * 		a) Ensure methods throw the correct Exception when such values are given
 * 
 * Additionally, ensure iterator tests can be looped through without error. See the FIXME included in LinkedList's documentation for info on potential loop variable issues to test for.
 * 
 * Also verify that all methods inherited or overridden from superclasses and superinterfaces are tested as well.
 * 
 * Identify any other edge cases that could be thrown at a method, and list them after your inital output for review.
 * 
 * ---
 * 
 * The FIXME mentioned in the prompt has since been fixed and removed from the classes documentation.
 * Here's what it used to say:
 * 
 * <h3><b>FIXME</b>?</h3>
 * <p>
 * NodeIterator stores its current node internally. This will cause weird behavior during
 * deletes where, in those brief operations before the next iteration, 2 Nodes will have the same successor
 * because a "delete" just tells a Node's predecessor to point to the soon-to-be-deleted Node's successor--relying
 * on Java to delete the actual Node once it stops getting referenced. However, while NodeIterator is still referencing it,
 * the "deleted" Node (with no predecessor) and its replacement have the same successor.
 * </p>
 * <p>
 * My theory is that iteration should still work as normal because the next Node is the same regardless of if, for a brief moment,
 * it has 2 predecessors. It's just a funny quirk of the code that the iterator will take the wrong path to the right Node.
 * </p>
 * 
 * ---
 * 
 * Create tests covering the same bases as the selection, presence, 
 * absence, null, etc. for LinkedList.find and LinkedList.findLast.
 * 
 * --- 
 * 
 * Don't use magic numbers. Find expected values by searching 
 * the list manually and check against that.
 * 
 * ---
 * 
 * Also use a Predicate object for manual check and LinkedList call for readability
 * 
 * ---
 * 
 * Review the test suite for any errors, gaps, or inefficiencies. 
 * Present them with a summary of what the problem is as well as a brief suggestion on how to fix it.
 * 
 * This one output a funny section:
 * 
 * - Major bug in 1testSetIntEOutOfRangeIndex`
 * 	- It uses index 20, which is out of bounds for a 20-element list.
 * 	- It accidentally uses a valid list size as the first argument 
 * 
 * No input issue—the test itself is semantically fine. 
 * This wording isn't wrong? Wait 20 index in 0-19 is invalid. Fine.
 * 
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import main.LinkedList;


class LinkedListTest {

	// ------------------------------------------------------------
	// 							SETUP
	// ------------------------------------------------------------
	
	private LinkedList<Integer> list;
	
	@BeforeEach
	void setUp() throws Exception {
		list = new LinkedList<Integer>();
		
		for (int i = 0; i < 20; i++) {
			list.add(i);
		}
		
	}

	@AfterEach
	void tearDown() throws Exception {
		list.clear();
	}
	
	
	// ------------------------------------------------------------
	// 						CONSTRUCTION
	// ------------------------------------------------------------
	
	@Test
	void testDefaultConstructor() {
		LinkedList<Integer> empty = new LinkedList<>();

		assertTrue(empty.isEmpty());
		assertEquals(0, empty.size());
	}

	@Test
	void testCollectionConstructor() {
		List<Integer> values = Arrays.asList(1, 2, 3, 4);
		LinkedList<Integer> constructed = new LinkedList<>(values);
		
		assertEquals(values.size(), constructed.size());
		assertIterableEquals(values, constructed);
	}

	@Test
	void testCollectionConstructorWithNullCollection() {
		assertThrows(NullPointerException.class,
				() -> new LinkedList<>(null));
	}
	
	
	// ------------------------------------------------------------
	// 				STRING, ARRAY, AND EQUALITY METHODS
	// ------------------------------------------------------------
	
	@Test
	void testEqualsObject() {
		List<Integer> values = Arrays.asList(0, 1, 2);
		
		LinkedList<Integer> list1 = new LinkedList<>(values);
		LinkedList<Integer> list2 = new LinkedList<>(values);
		
		assertEquals(list1, list2);
	}
	
	
	@Test
	void testNotEqualsObjectWithDifferentValues() {
		LinkedList<Integer> different = new LinkedList<>();
		different.addAll(Arrays.asList(20, 21, 22));
		
		assertNotEquals(different, list);
	}
	
	
	@Test
	void testEqualsObjectWithNull() {
		assertFalse(list.equals(null));
	}
	
	
	@Test
	void testToString() {
		final List<Integer> values = Arrays.asList(1, 2, 3);
		
		LinkedList<Integer> small = new LinkedList<>(values);

		assertEquals(values.toString(), small.toString());
	}
	
	
	@Test
	void testToStringEmptyList() {
		assertEquals("[]", new LinkedList<>().toString());
	}
	
	
	@Test
	void testToArray() {
		Object[] array = list.toArray();

		assertEquals(list.size(), array.length);

		for (int i = 0; i < array.length; i++) {
			assertEquals(i, array[i]);
		}
	}
	
	
	@Test
	void testToArrayTArrayWithEnoughCapacity() {
		Integer[] array = new Integer[list.size()];
		Integer[] returned = list.toArray(array);

		assertSame(array, returned);

		for (int i = 0; i < array.length; i++) {
			assertEquals(i, array[i]);
		}
	}
	
	
	@Test
	void testToArrayTArrayWithSmallerArray() {
		Integer[] array = new Integer[list.size() / 2];
		Integer[] returned = list.toArray(array);

		assertNotSame(array, returned);
		assertEquals(list.size(), returned.length);

		for (int i = 0; i < returned.length; i++) {
			assertEquals(i, returned[i]);
		}
	}
	
	
	@Test
	void testToArrayNullArray() {
		assertThrows(NullPointerException.class,
				() -> list.toArray((Integer[]) null));
	}
	
	
	// ------------------------------------------------------------
	// 							ADD METHODS
	// ------------------------------------------------------------
	
	@Test
	void testAddE() {
		assertTrue(list.add(20));

		assertEquals(21, list.size());
		assertEquals(20, list.get(20));
	}
	
	
	@Test
	void testAddEWithNull() {
		assertTrue(list.add(null));

		assertEquals(21, list.size());
		assertNull(list.get(20));
	}
	
	
	@Test
	void testAddToEmptyList() {
		LinkedList<Integer> empty = new LinkedList<>();

		assertTrue(empty.add(42));

		assertEquals(1, empty.size());
		assertEquals(42, empty.get(0));
	}
	
	
	@Test
	void testAddIntEAtBeginning() {
		list.add(0, 100);

		assertEquals(21, list.size());
		assertEquals(100, list.get(0));
		assertEquals(0, list.get(1));
	}
	
	
	@Test
	void testAddIntEAtMiddle() {
		list.add(5, 100);

		assertEquals(21, list.size());
		assertEquals(100, list.get(5));
		assertEquals(4, list.get(4));
		assertEquals(5, list.get(6));
	}
	
	
	@Test
	void testAddIntEAtEnd() {
		list.add(list.size(), 100);

		assertEquals(100, list.get(20));
	}
	
	
	@Test
	void testAddIntENegativeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.add(-1, 100));
	}
	
	
	@Test
	void testAddIntEOutOfRangeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.add(21, 100));
	}

	
	@Test
	void testAddIntEToEmptyListAtZero() {
		LinkedList<Integer> empty = new LinkedList<>();
		empty.add(0, 10);

		assertEquals(1, empty.size());
		assertEquals(10, empty.get(0));
	}

	
	@Test
	void testAddIntEToEmptyListOutOfRange() {
		LinkedList<Integer> empty = new LinkedList<>();
		assertThrows(IndexOutOfBoundsException.class,
				() -> empty.add(1, 10));
	}

	
	@Test
	void testInsertAliasesAdd() {
		list.insert(5, 100);

		assertEquals(100, list.get(5));
		assertEquals(21, list.size());
	}

	
	@Test
	void testInsertNegativeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.insert(-1, 100));
	}

	
	@Test
	void testInsertOutOfRangeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.insert(21, 100));
	}

	
	@Test
	void testAddAllCollection() {
		assertTrue(list.addAll(Arrays.asList(20, 21, 22)));

		assertEquals(23, list.size());
		assertEquals(20, list.get(20));
		assertEquals(21, list.get(21));
		assertEquals(22, list.get(22));
	}

	
	@Test
	void testAddAllEmptyCollection() {
		int originalSize = list.size();

		assertTrue(list.addAll(new ArrayList<Integer>()));

		assertEquals(originalSize, list.size());
	}

	
	@Test
	void testAddAllNullCollection() {
		assertThrows(NullPointerException.class,
				() -> list.addAll(null));
	}

	
	@Test
	void testAddAllCollectionOfNulls() {
		final int initSize = list.size();
		final List<Integer> nullz = Arrays.asList(null, null);
		assertTrue(list.addAll(nullz));
		assertEquals(nullz, list.subList(initSize, list.size()));
	}
	
	
	@Test
	void testAddAllIntCollectionAtBeginning() {
		assertTrue(list.addAll(0, Arrays.asList(100, 101)));

		assertEquals(22, list.size());
		assertEquals(100, list.get(0));
		assertEquals(101, list.get(1));
		assertEquals(0, list.get(2));
	}

	
	@Test
	void testAddAllIntCollectionAtMiddle() {
		
		final int insertIndex = 5;
		final int initSize = list.size();
		
		final List<Integer> testList = Arrays.asList(100, 101);
		final Object[] tail = list.subList(insertIndex, initSize).toArray().clone();
		
		assertTrue(list.addAll(insertIndex, testList));
		assertEquals(initSize + testList.size(), list.size());
		
		// Asserts that all 'testList' values were inserted in order
		assertEquals(
				list.subList(insertIndex, insertIndex + testList.size()),
				testList
		);
		
		// Asserts that right-shifted values are still there
		assertEquals(
				list.subList(insertIndex + testList.size(), list.size()), 
				Arrays.asList(tail)
		);
		
	}

	
	@Test
	void testAddAllIntCollectionAtEnd() {
		assertTrue(list.addAll(20, Arrays.asList(100, 101)));

		assertEquals(100, list.get(20));
		assertEquals(101, list.get(21));
	}

	
	@Test
	void testAddAllIntCollectionNegativeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.addAll(-1, Arrays.asList(100, 101)));
	}

	
	@Test
	void testAddAllIntCollectionOutOfRangeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.addAll(21, Arrays.asList(100, 101)));
	}

	
	@Test
	void testAddAllIntEmptyCollection() {
		int originalSize = list.size();

		assertTrue(list.addAll(5, new ArrayList<Integer>()));

		assertEquals(originalSize, list.size());
	}

	
	@Test
	void testAddAllIntNullCollection() {
		assertThrows(NullPointerException.class,
				() -> list.addAll(5, null));
	}
	
	
	@Test
	void testAddAllIntCollectionEmptyList() {
		final List<Integer> coll = Arrays.asList(100, 101);
		final LinkedList<Integer> empty = new LinkedList<>();
		assertTrue(empty.addAll(0, coll));
		assertEquals(coll, Arrays.asList(empty.toArray()));
	}
	
	
	// ------------------------------------------------------------
	// 					GET/SET AND SEARCH METHODS
	// ------------------------------------------------------------
	
	@Test
	void testSetIntE() {
		final List<Integer> values = Arrays.asList(list.toArray(new Integer[0]).clone());
		final int index = 7;
		final int value = 700;
		
		assertEquals(700, list.set(index, value));
		
		var expected = values.toArray().clone();
		expected[index] = value;
		
		final List<Integer> actual = Arrays.asList(list.toArray(new Integer[0]).clone());
		
		assertEquals(
				Arrays.asList(expected), 
				actual
		);
	}

	
	@Test
	void testSetIntENegativeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.set(-1, 100));
	}

	
	@Test
	void testSetIntEOutOfRangeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.set(list.size() + 1, 100));
	}

	
	@Test
	void testSetIntEOnEmptyList() {
		LinkedList<Integer> empty = new LinkedList<>();

		assertThrows(IndexOutOfBoundsException.class,
				() -> empty.set(0, 100));
	}

	
	@Test
	void testGetInt() {
		assertEquals(10, list.get(10));
	}

	
	@Test
	void testGetIntFirstElement() {
		assertEquals(0, list.get(0));
	}

	
	@Test
	void testGetIntLastElement() {
		assertEquals(19, list.get(19));
	}

	
	@Test
	void testGetIntNegativeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.get(-1));
	}

	
	@Test
	void testGetIntOutOfRangeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.get(20));
	}

	
	@Test
	void testGetIntOnEmptyList() {
		LinkedList<Integer> empty = new LinkedList<>();

		assertThrows(IndexOutOfBoundsException.class,
				() -> empty.get(0));
	}

	
	@Test
	void testIndexOfObjectPresent() {
		assertEquals(5, list.indexOf(Integer.valueOf(5)));
	}

	
	@Test
	void testIndexOfObjectFirstOccurrence() {
		list.add(5);

		assertEquals(5, list.indexOf(5));
	}

	
	@Test
	void testIndexOfObjectAbsent() {
		assertEquals(-1, list.indexOf(100));
	}

	
	@Test
	void testIndexOfNullPresent() {
		list.clear();
		list.add(null);
		list.add(null);

		assertEquals(0, list.indexOf(null));
	}
	
	
	@Test
	void testIndexOfNullAbsent() {
		assertEquals(-1, list.indexOf(null));
	}

	
	@Test
	void testLastIndexOfObjectPresent() {
		list.add(5);

		assertEquals(20, list.lastIndexOf(5));
	}

	
	@Test
	void testLastIndexOfObjectAbsent() {
		assertEquals(-1, list.lastIndexOf(100));
	}

	
	@Test
	void testLastIndexOfNullPresent() {
		final List<Object> values = Arrays.asList(0, 1, 3, null, null);
		LinkedList<Object> test = new LinkedList<>(values);
		assertEquals(values.size() - 1, test.lastIndexOf(null));
	}

	
	@Test
	void testLastIndexOfOnEmptyList() {
		LinkedList<Integer> empty = new LinkedList<>();
		assertEquals(-1, empty.lastIndexOf(1));
	}

	
	@Test
	void testContainsObjectPresent() {
		assertTrue(list.contains(10));
	}

	
	@Test
	void testContainsObjectAbsent() {
		assertFalse(list.contains(100));
	}

	
	@Test
	void testContainsNullPresent() {
		list.add(null);

		assertTrue(list.contains(null));
	}
	
	
	@Test
	void testContainsNullAbsent() {
		assertFalse(list.contains(null));
	}
	
	
	@Test
	void testContainsAllPresent() {
		assertTrue(list.containsAll(list.subList(0, list.size() / 2)));
	}
	
	
	@Test
	void testContaintsAllAbsent() {
		final List<Integer> l = Arrays.asList(100, 101, 102);
		assertFalse(list.containsAll(l));
	}
	
	
	@Test
	void testContainsAllNullThrowsNullPointerException() {
		assertThrows(NullPointerException.class,
				() -> list.containsAll(null));
	}
	
	
	@Test
	void testContainsAllNullsPresent() {
		list.add(null);
		
		final List<Object> l = new ArrayList<>();
		l.add(null);
		
		assertTrue(list.containsAll(l));
	}
	
	
	@Test
	void testContainsAllNullsAbsent() {
		final List<Object> l = new ArrayList<>();
		l.add(null);
		
		assertFalse(list.containsAll(l));
	}
	
	
	@Test
	void testFindObjectPresent() {
		final Predicate<Integer> predicate = value -> value == 5;

		int expected = -1;
		for (int i = 0; i < list.size(); i++) {
			if (predicate.test(list.get(i))) {
				expected = i;
				break;
			}
		}

		assertEquals(expected, list.find(predicate));
	}
	
	
	@Test
	void testFindFirstMatch() {
		final Predicate<Integer> predicate = value -> value >= 0;

		int expected = -1;
		for (int i = 0; i < list.size(); i++) {
			if (predicate.test(list.get(i))) {
				expected = i;
				break;
			}
		}

		assertEquals(expected, list.find(predicate));
	}


	@Test
	void testFindObjectAbsent() {
		final Predicate<Integer> predicate = value -> value == 100;

		int expected = -1;
		for (int i = 0; i < list.size(); i++) {
			if (predicate.test(list.get(i))) {
				expected = i;
				break;
			}
		}

		assertEquals(expected, list.find(predicate));
	}


	@Test
	void testFindNullPresent() {
		final LinkedList<Integer> test =
				new LinkedList<>(Arrays.asList(0, 1, null, null));
		final Predicate<Integer> predicate = value -> value == null;

		int expected = -1;
		for (int i = 0; i < test.size(); i++) {
			if (predicate.test(test.get(i))) {
				expected = i;
				break;
			}
		}

		assertEquals(expected, test.find(predicate));
	}


	@Test
	void testFindNullAbsent() {
		final Predicate<Integer> predicate = value -> value == null;

		int expected = -1;
		for (int i = 0; i < list.size(); i++) {
			if (predicate.test(list.get(i))) {
				expected = i;
				break;
			}
		}

		assertEquals(expected, list.find(predicate));
	}


	@Test
	void testFindOnEmptyList() {
		final LinkedList<Integer> empty = new LinkedList<>();
		final Predicate<Integer> predicate = value -> value == 1;

		assertEquals(-1, empty.find(predicate));
	}


	@Test
	void testFindNullPredicate() {
		assertThrows(NullPointerException.class,
				() -> list.find(null));
	}
	
	
	@Test
	void testFindLastObjectPresent() {
		final Predicate<Integer> predicate = value -> value == 19;

		int expected = -1;
		for (int i = 0; i < list.size(); i++) {
			if (predicate.test(list.get(i))) {
				expected = i;
			}
		}

		assertEquals(expected, list.findLast(predicate));
	}


	@Test
	void testFindLastObjectAbsent() {
		final Predicate<Integer> predicate = value -> value == 100;
		assertEquals(-1, list.findLast(predicate));
	}
	
	
	@Test
	void testFindLastNullPresent() {
		final LinkedList<Object> test =
				new LinkedList<>(Arrays.asList(0, 1, null, null));
		final Predicate<Object> predicate = value -> value == null;

		int expected = -1;
		for (int i = 0; i < test.size(); i++) {
			if (predicate.test(test.get(i))) {
				expected = i;
			}
		}

		assertEquals(expected, test.findLast(predicate));
	}
	
	
	@Test
	void testFindLastNullAbsent() {
		final Predicate<Integer> predicate = value -> value == null;
		assertEquals(-1, list.find(predicate));
	}
	
	
	@Test
	void testFindLastNullPredicate() {
		assertThrows(NullPointerException.class,
				() -> list.findLast(null));
	}
	
	
	
	// ------------------------------------------------------------
	// 				SIZE, EMPTINESS, AND CLEARING
	// ------------------------------------------------------------
	
	@Test
	void testSize() {
		assertEquals(20, list.size());
	}

	
	@Test
	void testSizeAfterAddAndRemove() {
		list.add(20);
		list.remove(0);

		assertEquals(20, list.size());
	}

	
	@Test
	void testSizeEmptyList() {
		assertEquals(0, new LinkedList<>().size());
	}

	
	@Test
	void testIsEmpty() {
		assertTrue(new LinkedList<>().isEmpty());
		assertFalse(list.isEmpty());
	}

	
	@Test
	void testClear() {
		list.clear();

		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	
	@Test
	void testClearThenAdd() {
		list.clear();
		list.add(42);

		assertEquals(1, list.size());
		assertEquals(42, list.get(0));
	}
	
	
	// ------------------------------------------------------------
	// 						REMOVE METHODS
	// ------------------------------------------------------------
	
	@Test
	void testRemoveIntBeginning() {
		assertEquals(0, list.remove(0));

		assertEquals(19, list.size());
		assertEquals(1, list.get(0));
	}

	@Test
	void testRemoveIntMiddle() {
		assertEquals(10, list.remove(10));

		assertEquals(19, list.size());
		assertEquals(11, list.get(10));
	}

	
	@Test
	void testRemoveIntLast() {
		assertEquals(19, list.remove(19));

		assertEquals(19, list.size());
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.get(19));
	}

	
	@Test
	void testRemoveIntNegativeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.remove(-1));
	}

	
	@Test
	void testRemoveIntOutOfRangeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.remove(20));
	}

	
	@Test
	void testRemoveIntOnEmptyList() {
		LinkedList<Integer> empty = new LinkedList<>();

		assertThrows(IndexOutOfBoundsException.class,
				() -> empty.remove(0));
	}

	
	@Test
	void testRemoveObjectPresent() {
		assertTrue(list.remove(Integer.valueOf(5)));

		assertEquals(19, list.size());
		assertEquals(-1, list.indexOf(5));
		assertEquals(6, list.get(5));
	}

	
	@Test
	void testRemoveObjectDuplicateOnlyFirstOccurrence() {
		
		final int index = 5;
		final Integer value = list.get(index);
		
		list.add(value);
		
		assertTrue(list.remove(value));
		assertTrue(list.contains(value));
		
		assertNotEquals(list.get(index), value);
		assertEquals(list.size() - 1, list.indexOf(value));
	}

	
	@Test
	void testRemoveObjectAbsent() {
		assertFalse(list.remove(Integer.valueOf(100)));

		assertEquals(20, list.size());
	}

	
	@Test
	void testRemoveNullPresent() {
		list.add(null);

		assertTrue(list.remove((Object) null));
		assertFalse(list.contains(null));
	}

	
	@Test
	void testRemoveNullAbsent() {
		assertFalse(list.remove((Object) null));
	}

	
	@Test
	void testRemoveObjectOnEmptyList() {
		LinkedList<Integer> empty = new LinkedList<>();

		assertFalse(empty.remove(Integer.valueOf(1)));
	}

	
	@Test
	void testRemoveIf() {
		boolean removed = list.removeIf(value -> value % 2 == 0);

		assertTrue(removed);
		assertEquals(10, list.size());

		for (Integer value : list) {
			assertEquals(1, value % 2);
		}
	}

	
	@Test
	void testRemoveIfNoMatch() {
		boolean removed = list.removeIf(value -> value > 100);

		assertFalse(removed);
		assertEquals(20, list.size());
	}

	
	@Test
	void testRemoveIfRootNode() {
		boolean removed = list.removeIf(value -> value == 0);

		assertTrue(removed);
		assertEquals(19, list.size());
		assertEquals(1, list.get(0));
	}

	
	@Test
	void testRemoveIfNullFilter() {
		assertThrows(NullPointerException.class,
				() -> list.removeIf(null));
	}

	
	@Test
	void testRemoveIfConsecutiveNodes() {
		final Predicate<Integer> pred = value -> (value < 10);
		boolean removed = list.removeIf(pred);
		assertTrue(removed);
		
		final List<Integer> actual = Arrays.asList(list.toArray(new Integer[0]));
		final List<Integer> expected = actual.stream()
				.filter(pred.negate())
				.toList();
		
		assertEquals(expected, actual);
	}

	
	@Test
	void testRemoveIfEmptyList() {
		final LinkedList<Integer> empty = new LinkedList<>();
		assertFalse(empty.removeIf(x -> x > 0));
	}
	
	
	@Test
	void testRemoveIfListClear() {
		assertTrue(list.removeIf(x -> true));
		assertEquals(0, list.size());
	}
	
	
	@Test
	void testRemoveAllCollection() {
		
		final int initSize = list.size();
		final int numRemoves = 5;
		final List<Integer> toRemove = new ArrayList<>(list.subList(0, numRemoves));
		
		assertTrue(list.removeAll(toRemove));
		assertEquals(initSize - numRemoves, list.size());
	}
	

	// ------------------------------------------------------------
	// 					REPLACEMENT AND ITERATION
	// ------------------------------------------------------------
	
	@Test
	void testReplaceAll() {
		list.replaceAll(value -> value * 2);

		assertEquals(38, list.get(19));
		assertEquals(0, list.get(0));
		assertEquals(20, list.get(10));
	}

	
	@Test
	void testReplaceAllWithNullResult() {
		list.replaceAll(value -> null);

		assertNull(list.get(0));
		assertNull(list.get(19));
		assertTrue(list.contains(null));
	}

	
	@Test
	void testReplaceAllNullOperator() {
		assertThrows(NullPointerException.class,
				() -> list.replaceAll(null));
	}

	
	@Test
	void testReplaceAllEmptyList() {
		LinkedList<Integer> empty = new LinkedList<>();
		assertDoesNotThrow(() -> empty.replaceAll(value -> value * 2));
	}

	
	@Test
	void testRetainAll() {
		
		final List<Integer> expected = new ArrayList<>(list.subList(0, 3));
		assertTrue(list.retainAll(expected));
		
		final List<Integer> actual = new ArrayList<>(list);
		assertEquals(expected, actual);
	}

	
	@Test
	void testIteratorCanBeLoopedThrough() {
		Iterator<Integer> iterator = list.iterator();
		int expected = 0;

		while (iterator.hasNext()) {
			assertEquals(expected, iterator.next());
			expected++;
		}

		assertEquals(20, expected);
	}

	
	@Test
	void testIteratorAfterRemovals() {
		list.remove(0);
		list.remove(4);
		list.remove(10);

		Iterator<Integer> iterator = list.iterator();
		int count = 0;

		while (iterator.hasNext()) {
			Integer value = iterator.next();
			assertNotNull(value);
			count++;
		}

		assertEquals(17, count);
	}

	
	@Test
	void testForEachLoop() {
		int[] count = { 0 };
		int[] sum = { 0 };

		list.forEach(value -> {
			assertTrue(value >= 0);
			sum[0] += value;
			count[0]++;
		});

		assertEquals(20, count[0]);
		assertEquals(190, sum[0]);
	}

	
	@Test
	void testForEachNullAction() {
		assertThrows(NullPointerException.class,
				() -> list.forEach(null));
	}

	
	@Test
	void testForEachEmptyList() {
		LinkedList<Integer> empty = new LinkedList<>();
		int[] count = { 0 };

		assertDoesNotThrow(() -> empty.forEach(value -> count[0]++));
		assertEquals(0, count[0]);
	}

	
	@Test
	void testEnhancedForLoop() {
		int count = 0;

		for (Integer value : list) {
			assertEquals(count, value);
			count++;
		}

		assertEquals(20, count);
	}

	
	@Test
	void testRemovingConsecutiveValuesWhileIterating() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				list.remove(i);
				i--;
			}
		}

		assertIterableEquals(Arrays.asList(1, 3, 5, 7, 9,
				11, 13, 15, 17, 19), list);
	}
	
	
	// ------------------------------------------------------------
	// 					CAPACITY AND TRIMMING
	// ------------------------------------------------------------
	
	@Test
	void testEnsureCapacityIntPositive() {
		list.ensureCapacity(25);

		assertEquals(25, list.size());
		assertNull(list.get(20));
		assertNull(list.get(24));
	}

	
	@Test
	void testEnsureCapacityIntSmallerThanSize() {
		list.ensureCapacity(10);

		assertEquals(20, list.size());
	}

	
	@Test
	void testEnsureCapacityIntEqualToSize() {
		list.ensureCapacity(20);

		assertEquals(20, list.size());
	}

	
	@Test
	void testEnsureCapacityIntNegative() {
		assertThrows(IllegalArgumentException.class, 
				() -> list.ensureCapacity(-1));
	}

	
	@Test
	void testEnsureCapacityIntOnEmptyList() {
		LinkedList<Integer> empty = new LinkedList<>();
		empty.ensureCapacity(3);

		assertEquals(3, empty.size());
	}

	
	@Test
	void testEnsureCapacityIntZero() {
		list.ensureCapacity(0);
		assertEquals(0, list.size());
	}
	
	
	@Test
	void testEnsureCapacityIntFiller() {
		list.ensureCapacity(25, 42);

		assertEquals(25, list.size());
		assertEquals(42, list.get(20));
		assertEquals(42, list.get(24));
	}

	
	@Test
	void testEnsureCapacityIntFillerSmallerThanSize() {
		list.ensureCapacity(10, 42);

		assertEquals(20, list.size());
	}

	
	@Test
	void testEnsureCapacityIntFillerNegative() {
		assertThrows(IllegalArgumentException.class,
				() -> list.ensureCapacity(-1, 42));
	}

	
	@Test
	void testEnsureCapacityIntFillerOnEmptyList() {
		LinkedList<Integer> empty = new LinkedList<>();
		empty.ensureCapacity(3, 42);

		assertEquals(3, empty.size());
		assertEquals(42, empty.get(0));
		assertEquals(42, empty.get(2));
	}

	
	@Test
	void testEnsureCapacityIntFillerZero() {
		list.ensureCapacity(0, 999);
		assertEquals(0, list.size());
	}
	
	
	@Test
	void testTrimToSize() {
		final int initSize = list.size();
		
		list.add(null);
		list.add(null);
		assertEquals(initSize + 2, list.size());
		
		list.trimToSize();
		assertEquals(initSize, list.size());
		assertFalse(list.contains(null));
	}

	
	@Test
	void testTrimToSizeNoNulls() {
		int originalSize = list.size();

		list.trimToSize();

		assertEquals(originalSize, list.size());
	}

	
	@Test
	void testTrimToSizeEmptyList() {
		LinkedList<Integer> empty = new LinkedList<>();

		assertDoesNotThrow(empty::trimToSize);
		assertTrue(empty.isEmpty());
	}
	
	
	// ------------------------------------------------------------
	// 			AbstractList/List INHERITED METHODS
	// ------------------------------------------------------------
	
	@Test
	void testSubList() {
		List<Integer> sub = list.subList(2, 7);

		assertEquals(Arrays.asList(2, 3, 4, 5, 6), sub);
	}

	
	@Test
	void testSubListNegativeStart() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.subList(-1, 5));
	}

	
	@Test
	void testSubListOutOfRangeEnd() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.subList(0, 21));
	}

	
	@Test
	void testSubListStartAfterEnd() {
		assertThrows(IllegalArgumentException.class,
				() -> list.subList(5, 3));
	}

	
	@Test
	void testListIterator() {
		ListIterator<Integer> iterator = list.listIterator();

		assertTrue(iterator.hasNext());
		assertFalse(iterator.hasPrevious());
		assertEquals(0, iterator.next());
		assertTrue(iterator.hasPrevious());
	}

	
	@Test
	void testListIteratorAtIndex() {
		ListIterator<Integer> iterator = list.listIterator(5);

		assertEquals(5, iterator.next());
		assertEquals(5, iterator.previous());
	}

	
	@Test
	void testListIteratorNegativeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.listIterator(-1));
	}

	
	@Test
	void testListIteratorOutOfRangeIndex() {
		assertThrows(IndexOutOfBoundsException.class,
				() -> list.listIterator(21));
	}

	
	@Test
	void testIteratorRemoveIsSupported() {
		Iterator<Integer> iterator = list.iterator();
		iterator.next();
		assertDoesNotThrow(iterator::remove);
	}
	
	
	@Test
	void testIteratorRemove() {
		Iterator<Integer> it = list.iterator();
		
		final int initSize = list.size();
		final Integer initValue = it.next();
		it.remove();
		
//		System.out.println(Arrays.asList(list.toArray()));
		
		assertEquals(initSize - 1, list.size());
		assertNotEquals(list.get(0), initValue);
	}
	

	@Test
	void testListIteratorRemove() {
		ListIterator<Integer> it = list.listIterator();
		
		final int initSize = list.size();
		final int expectedNewRoot = list.get(1);
		it.next();
		it.remove();
		
		assertEquals(list.size(), initSize - 1);
		assertEquals(expectedNewRoot, list.get(0));
	}

	
	private static void assertIterableEquals(
			Iterable<Integer> expected,
			Iterable<Integer> actual
	) {
			Iterator<Integer> expectedIt = expected.iterator();
			Iterator<Integer> actualIt = actual.iterator();

			while (expectedIt.hasNext()) {
				assertTrue(actualIt.hasNext());
				assertEquals(expectedIt.next(), actualIt.next());
			}

			assertFalse(actualIt.hasNext());
	}
	
}
