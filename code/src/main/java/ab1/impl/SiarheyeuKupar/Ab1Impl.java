package ab1.impl.SiarheyeuKupar;

import ab1.Ab1;

/**
 * Created by Yahor Siarheyeu and Olga Kupar
 */



public class Ab1Impl implements Ab1 {

	/**
	 * Method checks if array is a heap
	 *
	 * @param i erster Parameter der Heap-Bedingung H(i, j)
	 *          first parameter of the heap condition H(i, j)
	 *
	 * @param j zweiter Parameter der Heap-Bedingung H(i, j)
	 *          second paramter of the heap condition H(i, j)
	 *
	 * @param data das betreffende Array
	 *             the array to check
	 *
	 * @return true if the array is a heap
	 */
	@Override
	public boolean isHeap(int i, int j, int[] data)
	{
		for(int k = i; k <= Math.ceil(i / 2); k++) {
			if(2 * k + 1 <= j && data[k] < data[2 * k + 1])
				return false;
			else if(2 * k <= j && data[k] < data[2 * k])
				return false;
		}

		return true;
	}

	/**
	 * Method swaps two elements in an array
	 * @param arr = current array
	 * @param a = first element to swap
	 * @param b = second element to swap
	 */
	public static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	/**
	 * @param data das Array, das in einen Max-Heap umgewandelt werden soll
	 */
	@Override
	public void toHeap(int[] data)
	{
		int startIdx = (data.length / 2) - 1; // Index of last non-leaf node
		for (int i = startIdx; i >= 0; i--) {
			heapify(data, data.length, i);
		}
	}

	/**
	 * Method that build a heap from the tree
	 * @param array
	 * @param size
	 * @param i
	 */
	private void heapify(int array[], int size, int i)
	{
		int largest = i;    // Initialize current node as largest
		int left = 2 * i + 1;   // position of left child in array = 2*i + 1
		int right = 2 * i + 2;   // position of right child in array = 2*i + 2

		if (left < size && array[left] > array[largest])  // If left child is larger than root
			largest = left;

		if (right < size && array[right] > array[largest]) // If right child is larger than largest so far
			largest = right;

		if (largest != i) {         // If largest is not root swap it
			swap(array, i, largest);
			heapify(array, size, largest); // Recursively heapify the sub-tree
		}
	}

	/**
	 * Method sorts a heap from the smallest element to the biggest
	 * @param data das zu sortierende Array
	 */
	@Override
	public void heapsort(int[] data)
	{
		int total = data.length ;
		for(int i = total/2 - 1; i>=0; i--){
			heapify(data, data.length, i);
		}
		for(int i= total - 1 ; i > 0; i--){
			swap(data, i, 0);

			heapify(data, i, 0);
		}
	}

	/**
	 * Method inserts a next element to the list
	 *
	 * @param head Pointer auf das erste Element einer sortierten Liste
	 *             pointer to the head element of a sorted list
	 *
	 * @param value der einzufügende Wert
	 *              the value to be inserted
	 *
	 * @return list or null if the given list is empty
	 */
	@Override
	public ListNode insert(ListNode head, int value)
	{
		ListNode newNode = new ListNode();
		newNode.value = value;
		if (head == null){
			return null;
		} else {
			ListNode temp = head;
			head = newNode;
			head.next = temp;
			return head;

		}

	}

	/**
	 * Searching element by it's value
	 *
	 * @param head die zu durchsuchende Liste
	 *             the list to be searched
	 *
	 * @param value der zu suchende Wert
	 *              the value to search for
	 *
	 * @return element with the given value
	 */

	@Override
	public ListNode search(ListNode head, int value)
	{
		while (head.next != null){
			if(head.value == value){
				return head;
			}
		}
		return null;

	}

	/**
	 * Method searches the min element in a list
	 *
	 * @param head die zu durchsuchende Liste
	 *             the list to be searched
	 *
	 * @return element with min value or null if list is empty
	 */

	@Override
	public ListNode minimum(ListNode head)
	{
		ListNode min = null;
		if(head == null){
			return null;
		} else {
			while(head != null){
				if(head.value > head.next.value){
					min = head.next;
					head.next = head;
				}
			}
			return min;
		}
	}

	@Override
	public void mergesort(int[] data) {
		mergesort(data, 0, data.length - 1);
	}

	private static void mergesort(int[] input, int start, int end) {

		// break problem into smaller structurally identical problems
		int mid = (start + end) / 2;
		if (start < end) {
			mergesort(input, start, mid);
			mergesort(input, mid + 1, end);
		}

		// merge solved pieces to get solution to original problem
		int i = 0, first = start, last = mid + 1;
		int[] tmp = new int[end - start + 1];

		while (first <= mid && last <= end) {
			tmp[i++] = input[first] < input[last] ? input[first++] : input[last++];
		}
		while (first <= mid) {
			tmp[i++] = input[first++];
		}
		while (last <= end) {
			tmp[i++] = input[last++];
		}
		i = 0;
		while (start <= end) {
			input[start++] = tmp[i++];
		}
	}
}
