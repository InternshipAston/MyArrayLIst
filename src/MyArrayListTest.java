import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    @Test
    public void createDefaultArrayList() {
        // given
        MyList<Integer> list = new MyArrayList<>();

        // then
        assertTrue(list.isEmpty());
    }

    @Test
    public void createSpecifiedCapacityArrayList() {
        // given
        MyList<Integer> list = new MyArrayList<>(25);

        // then
        assertTrue(list.isEmpty());
    }

    @Test
    public void createSpecifiedCapacityArrayListThrowsException() {
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            MyList<Integer> list = new MyArrayList<>(-4);
        });
    }

    @Test
    public void addTest() {
        // given
        MyList<String> list = new MyArrayList<>();

        // then
        assertDoesNotThrow(() -> {
            list.add("some string");
        });
    }

    @Test
    public void addElementOnSpecifiedPositionDoesNotThrowsAny() {
        // given
        MyList<Long> list = new MyArrayList<>();

        // when
        list.add(71L);
        list.add(-811L);
        list.add(9981L);

        // then
        assertDoesNotThrow(() -> {
            list.add(2, 1000L);
        });
        assertEquals(1000L, list.get(2));
    }

    @Test
    public void addElementOnSpecifiedPositionThrowsException() {
        // given
        MyList<Long> list = new MyArrayList<>();

        // when
        list.add(71L);

        // then
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(4, 0L);
        });
    }

    @Test
    public void addFirstTest() {
        // given
        MyList<Long> list = new MyArrayList<>();

        // when
        list.add(61L);
        list.addFirst(555L);

        // then
        assertEquals(555L, list.get(0));
    }

    @Test
    public void addLastTest() {
        // given
        MyList<Long> list = new MyArrayList<>();

        // when
        list.add(78L);
        list.add(-911L);
        list.addLast(10000L);

        // then
        assertEquals(10000L, list.get(list.size() - 1));
    }

    @Test
    public void setTestDoesNotThrowsAny() {
        // given
        MyList<Long> list = new MyArrayList<>();

        // when
        list.add(78L);
        list.add(-911L);
        list.addLast(10000L);

        // then
        assertDoesNotThrow(() -> {
            list.set(1, 888L);
        });
        assertEquals(list.get(1), 888L);
    }

    @Test
    public void setTestThrowsException() {
        // given
        MyList<String> list = new MyArrayList<>();

        // when
        list.add("Hello");

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            list.set(4, "World");
        });
    }

    @Test
    public void getTestDoesNotThrowsAny() {
        // given
        MyList<String> list = new MyArrayList<>();

        // when
        list.add("Hello");

        // then
        assertDoesNotThrow(() -> {
            list.get(0);
        });
    }

    @Test
    public void getTestThrowsException() {
        // given
        MyList<String> list = new MyArrayList<>();

        // when
        list.add("Hello");

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            list.get(2);
        });
    }

    @Test
    public void getFirstTest() {
        // given
        MyList<String> list = new MyArrayList<>();

        // when
        list.add("Hello");
        list.add("world");

        // then
        assertEquals("Hello", list.getFirst());
    }

    @Test
    public void getLastTest() {
        // given
        MyList<String> list = new MyArrayList<>();

        // when
        list.add("Hello");
        list.add("world");

        // then
        assertEquals("world", list.getLast());
    }

    @Test
    public void containsReturnsTrue() {
        // given
        MyList<Float> list = new MyArrayList<>();

        // when
        list.add(3.4F);
        list.add(-5.1F);
        list.add(0F);
        list.add(99.52F);

        // then
        assertTrue(list.contains(-5.1F));
    }

    @Test
    public void containsReturnsFalse() {
        // given
        MyList<Float> list = new MyArrayList<>();

        // when
        list.add(3.4F);
        list.add(0F);
        list.add(99.52F);

        // then
        assertFalse(list.contains(-5.1F));
    }

    @Test
    public void indexOfSuccess() {
        // given
        MyList<String> list = new MyArrayList<>();

        // when
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        // then
        assertEquals(2, list.indexOf("three"));
    }

    @Test
    public void indexOfNotFount() {
        // given
        MyList<String> list = new MyArrayList<>();

        // when
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        // then
        assertEquals(-1, list.indexOf("five"));
    }

    @Test
    public void increaseCapacityTest() {
        // given
        MyList<Integer> list = new MyArrayList<>(1);

        // when
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    public void toStringTest() {
        // given
        MyList<String> list = new MyArrayList<>();

        // when
        list.add("Hello");
        list.add("World");

        // then
        assertDoesNotThrow(() -> {
            System.out.println(list);
        });
    }

    @Test
    public void getSize() {
        // given
        MyList<String> list = new MyArrayList<>();

        // when
        list.add("Hello");
        list.add("World");

        // then
        assertEquals(2, list.size());
    }

    @Test
    public void isEmptyReturnsTrue() {
        // given
        MyList<String> list = new MyArrayList<>();

        // then
        assertTrue(list.isEmpty());
    }

    @Test
    public void isEmptyReturnsFalse() {
        // given
        MyList<Double> list = new MyArrayList<>();

        // when
        list.add(58.41);

        // then
        assertFalse(list.isEmpty());
    }

    @Test
    public void quickSortTest() {
        // given
        MyList<Integer> list1 = new MyArrayList<>();
        int[] list2 = {7, -81, 0, 996, 64, 1104, -739};

        // when
        list1.add(7);
        list1.add(-81);
        list1.add(0);
        list1.add(996);
        list1.add(64);
        list1.add(1104);
        list1.add(-739);

        MyQuickSort.sort(list1, 0, list1.size() - 1);
        Arrays.sort(list2);

        // then
        for (int i = 0; i < list1.size(); ++i) {
            assertEquals(list1.get(i), list2[i]);
        }
    }
}
