package ab1;

import ab1.impl.SiarheyeuKupar.Ab1Impl;
import ab1.Ab1.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Ab1Test {

	private Random rand = new Random(System.currentTimeMillis());

	private static Ab1 ab1Impl = new Ab1Impl();

	private static int NUM_TESTS = 50;
	private static int NUM_TESTS_LARGE = 500000;
	private static int ARRAY_SIZE_SMALL = 7500;
	private static int ARRAY_SIZE_LARGE = 500000;
	private static int ARRAY_SIZE_HUGE = 25_000_000;

	@Test
	public void testIsHeapSmall()
	{
		for(int i = 0; i < NUM_TESTS; ++i)
		{
			int[] test = getRandomArray(ARRAY_SIZE_SMALL);
			assertTrue(!ab1Impl.isHeap(1, test.length, test));

			test = getRandomHeap(ARRAY_SIZE_SMALL);
			assertTrue(ab1Impl.isHeap(1, test.length, test));
		}
	}

	@Test
	public void testIsHeapLarge()
	{
		for(int i = 0; i < NUM_TESTS; ++i)
		{
			int[] test = getRandomArray(ARRAY_SIZE_LARGE);
			assertTrue(!ab1Impl.isHeap(1, test.length, test));

			test = getRandomHeap(ARRAY_SIZE_LARGE);
			assertTrue(ab1Impl.isHeap(1, test.length, test));
		}
	}

	@Test
	public void testToHeapSmall()
	{
		for(int i = 0; i < NUM_TESTS; ++i)
		{
			int[] test = getRandomArray(ARRAY_SIZE_SMALL);
			ab1Impl.toHeap(test);
			assertTrue(ab1Impl.isHeap(1, test.length, test));
		}
	}

	@Test
	public void testToHeapLarge()
	{
		for(int i = 0; i < NUM_TESTS; ++i)
		{
			int[] test = getRandomArray(ARRAY_SIZE_LARGE);
			ab1Impl.toHeap(test);
			assertTrue(ab1Impl.isHeap(1, test.length, test));
		}
	}

	@Test
	public void testToHeapSorted()
	{
		for(int i = 0; i < NUM_TESTS; ++i)
		{
			int[] test = getRandomArray(ARRAY_SIZE_SMALL);
			Arrays.sort(test);
			ab1Impl.toHeap(test);
			assertTrue(ab1Impl.isHeap(1, test.length, test));
		}
	}

	@Test
	public void testHeapCornerCases()
	{
		// empty array
		int[] test = new int[0];
		ab1Impl.toHeap(test);

		// array of size 1
		test = getRandomArray(1);
		ab1Impl.toHeap(test);
		assertTrue(ab1Impl.isHeap(1, test.length, test));

		// array with all elements zero
		test = new int[ARRAY_SIZE_SMALL];
		ab1Impl.toHeap(test);
		assertTrue(ab1Impl.isHeap(1, test.length, test));

		// array with all elements zero, except the last one
		test = new int[ARRAY_SIZE_SMALL];
		test[test.length - 1] = 1;
		ab1Impl.toHeap(test);
		assertTrue(ab1Impl.isHeap(1, test.length, test));
	}

	@Test
	public void testHeapSortSmall()
	{
		for(int i = 0; i < NUM_TESTS; ++i)
		{
			int[] test = getRandomArray(ARRAY_SIZE_SMALL);
			int[] copy = Arrays.copyOf(test, test.length);
			ab1Impl.heapsort(test);
			Arrays.sort(copy);
			assertArrayEquals(copy, test);
		}
	}

	@Test
	public void testHeapSortLarge()
	{
		for(int i = 0; i < NUM_TESTS; ++i)
		{
			int[] test = getRandomArray(ARRAY_SIZE_LARGE);
			int[] copy = Arrays.copyOf(test, test.length);
			ab1Impl.heapsort(test);
			Arrays.sort(copy);
			assertArrayEquals(copy, test);
		}
	}

	@Test
	public void testListInsert()
	{
		for(int i = 0; i < NUM_TESTS; ++i)
		{
			int[] test = getRandomArray(ARRAY_SIZE_SMALL);
			ListNode head = null;
			for(int j = 0; j < test.length; ++j)
			{
				head = ab1Impl.insert(head, test[j]);
				assertNotNull(head);
			}
			Arrays.sort(test);
			for(int j = 0; j < test.length; ++j)
			{
				assertEquals(test[j], head.value);
				head = head.next;
			}
		}
	}

	@Test
	public void testListSearch()
	{
		for(int i = 0; i < NUM_TESTS; ++i)
		{
			int[] test = getRandomArray(ARRAY_SIZE_SMALL);
			ListNode head = null;
			for(int j = 1; j < test.length; ++j)
			{
				head = ab1Impl.insert(head, test[j]);
				assertNotNull(head);
			}
			ListNode found = ab1Impl.search(head, test[0]);
			for(int j = 0; j < test.length; ++j)
			{
				if(found == head) break;
				head = head.next;
			}
			assertNotNull(head); // check that we found the node
		}
	}

	@Test
	public void testListMinimum()
	{
		for(int i = 0; i < NUM_TESTS; ++i)
		{
			int[] test = getRandomArray(ARRAY_SIZE_SMALL);
			int min = Integer.MAX_VALUE;
			ListNode head = null;
			for(int j = 1; j < test.length; ++j)
			{
				head = ab1Impl.insert(head, test[j]);
				assertNotNull(head);
				if(min > test[j]) min = test[j];
			}
			ListNode foundMin = ab1Impl.minimum(head);
			assertEquals(min, foundMin.value);
		}
	}

	@Test
	public void testMergeSortSmall()
	{
		for(int i = 0; i < NUM_TESTS; ++i)
		{
			int[] test = getRandomArray(ARRAY_SIZE_SMALL);
			int[] copy = Arrays.copyOf(test, test.length);
			ab1Impl.mergesort(test);
			Arrays.sort(copy);
			assertArrayEquals(copy, test);
		}
	}

	@Test
	public void testMergeSortLarge()
	{
		for(int i = 0; i < NUM_TESTS; ++i)
		{
			int[] test = getRandomArray(ARRAY_SIZE_LARGE);
			int[] copy = Arrays.copyOf(test, test.length);
			ab1Impl.mergesort(test);
			Arrays.sort(copy);
			assertArrayEquals(copy, test);
		}
	}

	private int[] getRandomArray(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; ++i)
			arr[i] = Math.abs(rand.nextInt(2 * size));
		return arr;
	}

	private int[] getRandomHeap(int size) {
		int[] arr = new int[size];
		arr[0] = Integer.MAX_VALUE - Math.abs(rand.nextInt(10));

		int pos = 0;
		while(true)
		{
			int l = 2*pos + 1;
			int r = 2*pos + 2;

			if(l >= arr.length) break;
			arr[l] = arr[pos] - Math.abs(rand.nextInt(9) + 1);

			if(r >= arr.length) break;
			arr[r] = arr[pos] - Math.abs(rand.nextInt(9) + 1);

			++pos;
		}

		return arr;
	}
}
