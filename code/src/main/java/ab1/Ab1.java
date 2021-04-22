package ab1;

public interface Ab1 {
	/**
	 * Überprüft im übergebenen Array die Heap-Bedingung H(i, j).
	 * Checks the heap condition H(i, j) for the given array.
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
	 * @return true, wenn die Heap-Bedingung H(i, j) gilt, sonst false
	 *         true if the heap condition H(i, j) holds, otherwise false
	 */
	public boolean isHeap(int i, int j, int[] data);

	/**
	 * Konstruiert aus dem übergebenen Array einen Max-Heap, d.h. nach dem
	 * Aufruf gilt die Heap-Bedingung H(1, length).
	 *
	 * Constructs a max heap from an array, i.e. ensures that after
	 * execution, the heap condition H(1, length) holds on the given array.
	 *
	 * @param data das Array, das in einen Max-Heap umgewandelt werden soll
	 *             the array to be transformed into a max heap
	 */
	public void toHeap(int[] data);

	/**
	 * Sortiert das übergebene Array mithilfe des Heapsort-Algorithmus.
	 * Sorts the given array using the heapsort algorithm.
	 *
	 * @param data das zu sortierende Array
	 *             the array to be sorted
	 */
	public void heapsort(int[] data);

	/**
	 * Eine Klasse um eine einfach-verkettete Liste zu repräsentieren.
	 * A class to represent a singly-linked list.
	 */
	public class ListNode {
		public ListNode next; /** Pointer to next element */
		public int value; /** The value of the current element */
	}

	/**
	 * Fügt ein neues Element in die übergebene Liste ein und erhält die
	 * Sortierung.
	 * Inserts a new element into the given list and keeps the list sorted.
	 *
	 * Nehmen Sie an, dass die Liste aufsteigend sortiert ist.
	 * You can assume that the list is sorted ascendingly.
	 *
	 * @param head Pointer auf das erste Element einer sortierten Liste
	 *             pointer to the head element of a sorted list
	 *
	 * @param value der einzufügende Wert
	 *              the value to be inserted
	 *
	 * @return das erste Listenelement der neuen Liste nach dem Einfügen
	 *         the first list element of the new list after insertion
	 */
	public ListNode insert(ListNode head, int value);

	/**
	 * Durchsucht die Liste nach dem ersten Element mit dem gesuchten Wert.
	 * Searches the list for the first element with the given value.
	 *
	 * Nehmen Sie an, dass die Liste aufsteigend sortiert ist.
	 * You can assume that the list is sorted ascendingly.
	 *
	 * @param head die zu durchsuchende Liste
	 *             the list to be searched
	 *
	 * @param value der zu suchende Wert
	 *              the value to search for
	 *
	 * @return das erste Element in der Liste mit dem gesuchten Wert
	 *         the first element in the list with the given value
	 */
	public ListNode search(ListNode head, int value);

	/**
	 * Gibt das kleinste Element in der Liste zurück.
	 * Returns the element with the smallest value in the list.
	 *
	 * Nehmen Sie an, dass die Liste aufsteigend sortiert ist.
	 * You can assume that the list is sorted ascendingly.
	 *
	 * @param head die zu durchsuchende Liste
	 *             the list to be searched
	 *
	 * @return das Listenelement mit dem kleinsten Wert
	 */
	public ListNode minimum(ListNode head);

	/**
	 * Sortiert das gegebene Array mittels Mergesort.
	 * Sorts the given array via the mergesort algorithm.
	 *
	 * @param array das zu sortierende Array
	 *              the array to be sorted
	 */
	public void mergesort(int[] array);
}
