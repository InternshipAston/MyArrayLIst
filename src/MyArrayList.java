import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {

    private final int DEFAULT_ARRAY_CAPACITY = 10;
    private int size;
    private Object[] array;
    private int currentCapacity;

    public MyArrayList() {
        array = new Object[DEFAULT_ARRAY_CAPACITY];
        currentCapacity = DEFAULT_ARRAY_CAPACITY;
    }

    /**
     * @param capacity starting value of the array capacity
     */
    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            array = new Object[capacity];
            currentCapacity = capacity;
        } else {
            throw new IllegalArgumentException("Illegal array capacity value" + capacity);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size - 1; ++i) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[size - 1]).append("]");

        return new String(sb);
    }

    @Override
    public int size() {
        return size;
    }

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
     */
    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Incorrect index" + index);
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
     * @param index index of the element to get
     * @return required element
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index" + index);
        }
        return (T) array[index];
    }

    /**
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