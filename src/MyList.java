import java.util.NoSuchElementException;

/**
 * This interface describes how to manage and modify a collection of elements
 * @param <T> type of element in this array list
 */
public interface MyList<T> {

    /**
     * @return the current size of this array list
     */
    int size();

    /**
     * @return true if this array list is empty or false
     */
    boolean isEmpty();

    /**
     * add the element at the end of the collection
     * @param element element to add
     */
    void add(T element);

    /**
     * add the element at the specified position of the collection
     * @param element element to add
     * @param index   index in this arrayList where add the element
     * @exception IllegalArgumentException if the index is out of bounds of this array list
     */
    void add(int index, T element);

    /**
     * add the element at the start of the collection
     * @param element to add
     */
    void addFirst(T element);

    /**
     * add the element at the end of the collection
     * @param element to add
     */
    void addLast(T element);

    /**
     * @param index   the index of the element which must be setted
     * @param element the new element on index position
     * @exception IllegalArgumentException if the index is out of bounds of this array list
     * @return new element
     */
    T set(int index, T element);

    /**
     * @param index index of the element to get
     * @return element on specified index
     * @exception IllegalArgumentException if the index is out of bounds of this array list
     */
    T get(int index);

    /**
     * @exception NoSuchElementException if this array list is empty
     * @return the first element from this collection
     */
    T getFirst();

    /**
     * @exception NoSuchElementException if this array list is empty
     * @return the last element from this collection
     */
    T getLast();

    /**
     * @param element element to check for occurrence
     * @return true if the element is occurrence in this collection
     * or false if not
     */
    boolean contains(T element);

    /**
     * @param element to find index for
     * @return the first index of element occurrence in this collection
     */
    int indexOf(T element);
}
