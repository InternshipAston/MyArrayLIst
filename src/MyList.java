public interface MyList<T> {
    int size();

    boolean isEmpty();

    void add(T element);

    void add(int index, T element);

    void addFirst(T e);

    void addLast(T e);

    T set(int index, T element);

    T get(int index);

    T getFirst();

    T getLast();

    boolean contains(T element);

    int indexOf(T element);
}
