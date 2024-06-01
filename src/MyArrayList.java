import java.util.NoSuchElementException;

/**
 * This class represents the implementation of the MiList interface.
 * In it, a collection of elements is presented as a dynamic array.
 * The user is presented with method get() for accessing elements by index,
 * methods getFirst(), getLast() for getting the first or last element,
 * methods add(), addFirst(), addLast() for inserting elements
 * at the beginning, middle, or end of an array,
 * method indexOf() for getting element index by its value,
 * set() method to change an element at a special position
 *
 * @param <T>
 * @author Egor Fursevich
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class MyArrayList<T extends Comparable<T>> implements MyList<T> {

    private final int DEFAULT_ARRAY_CAPACITY = 10;
    private int size;
    private Object[] array;
    private int currentCapacity;

    /**
     * Constructs an empty array list with default capacity
     */
    public MyArrayList() {
        array = new Object[DEFAULT_ARRAY_CAPACITY];
        currentCapacity = DEFAULT_ARRAY_CAPACITY;
    }

    /**
     * @param capacity starting value of this array list capacity
     * @exception IllegalArgumentException if the capacity is below zero
     */
    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            array = new Object[capacity];
            currentCapacity = capacity;
        } else {
            throw new IllegalArgumentException("Illegal array capacity value " + capacity);
        }
    }

    /**
     * @return the string representation of this array list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; ++i) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[size - 1]).append("]");

        return new String(sb);
    }

    /**
     * @return the current size of this array list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return true if this array list is empty or false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param element element to add
     */
    @Override
    public void add(T element) {
        if (size >= currentCapacity) {
            increaseCapacity();
        }
        array[size++] = element;
    }

    /**
     * @param element element to add
     * @param index   index in this arrayList where add the element
     * @exception IllegalArgumentException if the index is out of bounds of this array list
     */
    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Incorrect index " + index);
        }
        if (index == size) {
            add(element);
        } else {
            if (size >= currentCapacity) {
                increaseCapacity();
            }
            addInTheMiddle(element, index);
        }
    }

    /**
     * @param element to add
     */
    @Override
    public void addFirst(T element) {
        add(0, element);
    }

    /**
     * @param element to add
     */
    @Override
    public void addLast(T element) {
        add(element);
    }

    /**
     * @param index   the index of the element which must be setted
     * @param element the new element on index position
     * @exception IllegalArgumentException if the index is out of bounds of this array list
     * @return new element
     */
    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index " + index);
        }

        array[index] = element;

        return (T) array[index];
    }

    /**
     * @param index index of the element to get
     * @return element on specified index
     * @exception IllegalArgumentException if the index is out of bounds of this array list
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index " + index);
        }
        return (T) array[index];
    }

    /**
     * @exception NoSuchElementException if this array list is empty
     * @return the first element from this collection
     */
    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("This arrayList is empty");
        }
        return (T) array[0];
    }

    /**
     * @exception NoSuchElementException if this array list is empty
     * @return the last element from this collection
     */
    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("This arrayList is empty");
        }
        return (T) array[size - 1];
    }


    /**
     * @param element element to check for occurrence
     * @return true if the element is occurrence in this collection
     * or false if not
     */
    @Override
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    /**
     * @param element to find index for
     * @return the first index of element occurrence in this collection
     */
    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; ++i) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private void increaseCapacity() {
        currentCapacity = (currentCapacity * 3) / 2 + 1;
        var newData = new Object[currentCapacity];
        System.arraycopy(array, 0, newData, 0, size);
        array = newData;
    }

    private void addInTheMiddle(T element, int index) {
        T last = (T) array[size - 1];
        var toMove = array[index];
        array[index] = element;
        for (int i = index + 1; i < size; ++i) {
            var temp = array[i];
            array[i] = toMove;
            toMove = temp;
        }
        add(last);
    }
}
