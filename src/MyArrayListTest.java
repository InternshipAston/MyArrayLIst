import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    @Test
    public void createDefaultArrayList() {
        MyList<Integer> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void createSpecifiedCapacityArrayList() {
        MyList<Integer> list = new MyArrayList<>(25);
        assertTrue(list.isEmpty());
    }

    @Test
    public void createSpecifiedCapacityArrayListThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            MyList<Integer> list = new MyArrayList<>(-4);
        });
    }

    @Test
    public void addTest() {
        MyList<String> list = new MyArrayList<>();
        assertDoesNotThrow(() -> {
            list.add("some string");
        });
    }

    @Test
    public void addElementOnSpecifiedPositionDoesNotThrowsAny() {
        MyList<Long> list = new MyArrayList<>();
        list.add(71L);
        list.add(-811L);
        list.add(9981L);
        assertDoesNotThrow(() -> {
            list.add(2, 1000L);
        });
        assertEquals(1000L, list.get(2));
    }

    @Test
    public void addElementOnSpecifiedPositionThrowsException() {
        MyList<Long> list = new MyArrayList<>();
        list.add(71L);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(4, 0L);
        });
    }

    @Test
    public void addFirstTest() {
        MyList<Long> list = new MyArrayList<>();
        list.add(61L);
        list.addFirst(555L);
        assertEquals(555L, list.get(0));
    }

    @Test
    public void addLastTest() {
        MyList<Long> list = new MyArrayList<>();
        list.add(78L);
        list.add(-911L);
        list.addLast(10000L);
        assertEquals(10000L, list.get(list.size() - 1));
    }

    @Test
    public void setTestDoesNotThrowsAny() {
        MyList<Long> list = new MyArrayList<>();
        list.add(78L);
        list.add(-911L);
        list.addLast(10000L);
        assertDoesNotThrow(() -> {
            list.set(1, 888L);
        });
        assertEquals(list.get(1), 888L);
    }

    @Test
    public void setTestThrowsException() {
        MyList<String> list = new MyArrayList<>();
        list.add("Hello");
        assertThrows(IllegalArgumentException.class, () -> {
            list.set(4, "World");
        });
    }

    @Test
    public void getTestDoesNotThrowsAny() {
        MyList<String> list = new MyArrayList<>();
        list.add("Hello");
        assertDoesNotThrow(() -> {
            list.get(0);
        });
    }

    @Test
    public void getTestThrowsException() {
        MyList<String> list = new MyArrayList<>();
        list.add("Hello");
        assertThrows(IllegalArgumentException.class, () -> {
            list.get(2);
        });
    }

    @Test
    public void getFirstTest() {
        MyList<String> list = new MyArrayList<>();
        list.add("Hello");
        list.add("world");
        assertEquals("Hello", list.getFirst());
    }

    @Test
    public void getLastTest() {
        MyList<String> list = new MyArrayList<>();
        list.add("Hello");
        list.add("world");
        assertEquals("world", list.getLast());
    }

    @Test
    public void containsReturnsTrue() {
        MyList<Float> list = new MyArrayList<>();
        list.add(3.4F);
        list.add(-5.1F);
        list.add(0F);
        list.add(99.52F);
        assertTrue(list.contains(-5.1F));
    }

    @Test
    public void containsReturnsFalse() {
        MyList<Float> list = new MyArrayList<>();
        list.add(3.4F);
        list.add(0F);
        list.add(99.52F);
        assertFalse(list.contains(-5.1F));
    }

    @Test
    public void indexOfSuccess() {
        MyList<String> list = new MyArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        assertEquals(2, list.indexOf("three"));
    }

    @Test
    public void indexOfNotFount() {
        MyList<String> list = new MyArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        assertEquals(-1, list.indexOf("five"));
    }

    @Test
    public void increaseCapacityTest() {
        MyList<Integer> list = new MyArrayList<>(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    public void toStringTest() {
        MyList<String> list = new MyArrayList<>();
        list.add("Hello");
        list.add("World");
        assertDoesNotThrow(() -> {
            System.out.println(list);
        });
    }

    @Test
    public void getSize() {
        MyList<String> list = new MyArrayList<>();
        list.add("Hello");
        list.add("World");
        assertEquals(2, list.size());
    }

    @Test
    public void isEmptyReturnsTrue() {
        MyList<String> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void isEmptyReturnsFalse() {
        MyList<Double> list = new MyArrayList<>();
        list.add(58.41);
        assertFalse(list.isEmpty());
    }

    @Test
    public void quickSortTest() {
        MyList<Integer> list1 = new MyArrayList<>();
        list1.add(7);
        list1.add(-81);
        list1.add(0);
        list1.add(996);
        list1.add(64);
        list1.add(1104);
        list1.add(-739);
        int[] list2 = {7, -81, 0, 996, 64, 1104, -739};
        MyQuickSort.sort(list1, 0, list1.size() - 1);
        Arrays.sort(list2);
        for (int i = 0; i < list1.size(); ++i) {
            assertEquals(list1.get(i), list2[i]);
        }
    }
}
