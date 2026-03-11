package com.bobocode.tdd;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LinkedListTest {

    private List<Integer> list = new LinkedList<>();

    @Test
    void testAddIntoEmptyList() {
        list.add(41);

        int element = list.get(0);

        assertThat(element).isEqualTo(41);
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void testGetFirstElementFromSingleElementList() {
        list.add(25);

        int element = list.get(0);

        assertThat(element).isEqualTo(25);
    }

    @Test
    void testAddElements() {
        list = LinkedList.of(43, 233, 54);

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(43);
        assertThat(list.get(1)).isEqualTo(233);
        assertThat(list.get(2)).isEqualTo(54);
    }

    @Test
    void testSize() {
        list = LinkedList.of(4, 7, 9, 0, 7);

        int size = list.size();

        assertThat(size).isEqualTo(5);
    }

    @Test
    void testGetFirstElement() {
        list = LinkedList.of(31, 32);

        int firstElement = list.getFirst();
        assertThat(firstElement).isEqualTo(31);
    }

    @Test
    void testGetLastElement() {
        list = LinkedList.of(41, 42);

        int lastElement = list.getLast();

        assertThat(lastElement).isEqualTo(42);
    }

    @Test
    void testGetFirstOfEmptyList() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> list.getFirst());
    }

    @Test
    void testGetLastOfEmptyList() {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> list.getLast());
    }


    @Test
    void testGetElements() {
        list = LinkedList.of(25, 87, 45);

        int firstElement = list.get(0);
        int secondElement = list.get(1);
        int thirdElement = list.get(2);

        assertThat(firstElement).isEqualTo(25);
        assertThat(secondElement).isEqualTo(87);
        assertThat(thirdElement).isEqualTo(45);

    }

    @Test
    void testAddElementByZeroIndexIntoEmptyList() {
        list.add(0, 45);

        int element = list.get(0);

        assertThat(element).isEqualTo(45);
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void testAddElementByIndexToTheEndOfList() {
        list = LinkedList.of(98, 64, 23, 1, 3, 4);

        int newElementIndex = list.size();
        list.add(newElementIndex, 44);

        assertThat(list.get(newElementIndex)).isEqualTo(44);
        assertThat(list.size()).isEqualTo(7);
    }

    @Test
    void testAddElementToTheHeadOfNonEmptyList() {
        list = LinkedList.of(4, 6, 8, 9, 0, 2);

        list.add(0, 53);

        assertThat(list.get(0)).isEqualTo(53);
        assertThat(list.get(1)).isEqualTo(4);
        assertThat(list.size()).isEqualTo(7);
    }

    @Test
    void testAddElementByIndex() {
        list = LinkedList.of(43, 5, 6, 8);

        int newElementIdx = 2;
        list.add(newElementIdx, 66);

        assertThat(list.get(newElementIdx)).isEqualTo(66);
        assertThat(list.get(0)).isEqualTo(43);
        assertThat(list.get(1)).isEqualTo(5);
        assertThat(list.get(3)).isEqualTo(6);
        assertThat(list.get(4)).isEqualTo(8);
        assertThat(list.size()).isEqualTo(5);
    }

    @Test
    void testAddElementByNegativeIndex() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.add(-1, 66));
    }

    @Test
    void testAddElementByIndexLargerThanListSize() {
        list = LinkedList.of(4, 6, 11, 9);

        int newElementIdx = 5;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.add(newElementIdx, 88));
    }

    @Test
    void testAddElementByIndexEqualToSize() {
        list = LinkedList.of(1, 2, 3, 4, 5); // size = 5

        list.add(5, 111);
        int element = list.get(5);

        assertThat(element).isEqualTo(111);
        assertThat(list.size()).isEqualTo(6);
    }

    @Test
    void testSetFirstElementOnEmptyTree() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.set(0, 34));
    }

    @Test
    void testSetElementByIndexEqualToSize() {
        list = LinkedList.of(2, 3, 4); // size = 3

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.set(3, 222));
    }

    @Test
    void testSetElementByIndex() {
        list = LinkedList.of(34, 78, 9, 8);

        int index = 2; //element = 78
        list.set(index, 99);

        assertThat(list.get(index)).isEqualTo(99);
        assertThat(list.get(0)).isEqualTo(34);
        assertThat(list.get(1)).isEqualTo(78);
        assertThat(list.get(3)).isEqualTo(8);
        assertThat(list.size()).isEqualTo(4);
    }

    @Test
    void testGetFirstElementFromEmptyList() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.get(0));
    }

    @Test
    void testGetElementByNegativeIndex() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.get(-1));
    }

    @Test
    void testGetElementByIndexEqualsToListSize() {
        list = LinkedList.of(33, 46, 25, 87, 45);
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.get(5));
    }

    @Test
    void testRemoveElementFromEmptyList() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.remove(234));
    }

    @Test
    void testRemoveFirstElement() {
        list = LinkedList.of(4, 6, 8, 9);

        int deletedElement = list.remove(0);

        assertThat(list.get(0)).isEqualTo(6);
        assertThat(list.size()).isEqualTo(3);
        assertThat(deletedElement).isEqualTo(4);
    }

    @Test
    void testRemoveLastElement() {
        list = LinkedList.of(4, 6, 8, 9);

        int deletedElement = list.remove(list.size() - 1);

        assertThat(list.get(list.size() - 1)).isEqualTo(8);
        assertThat(list.size()).isEqualTo(3);
        assertThat(deletedElement).isEqualTo(9);
    }

    @Test
    void testRemoveElement() {
        list = LinkedList.of(1, 2, 3, 4, 5);

        int elementIndex = 2;
        int deletedElement = list.remove(elementIndex); // element = 3

        assertThat(list.get(elementIndex)).isEqualTo(4);
        assertThat(list.size()).isEqualTo(4);
        assertThat(deletedElement).isEqualTo(3);
    }

    @Test
    void testContainsOnEmptyList() {
        boolean contains = list.contains(34);

        assertThat(contains).isFalse();
    }

    @Test
    void testContains() {
        list = LinkedList.of(45, 6, 3, 6);

        boolean containsExistingElement = list.contains(3);
        boolean containsNotExistingElement = list.contains(54);

        assertThat(containsExistingElement).isTrue();
        assertThat(containsNotExistingElement).isFalse();
    }

    @Test
    void testIsEmptyOnEmptyList() {
        boolean empty = list.isEmpty();

        assertThat(empty).isTrue();
    }

    @Test
    void testIsEmpty() {
        list = LinkedList.of(34, 5, 6);

        boolean empty = list.isEmpty();

        assertThat(empty).isFalse();
    }

    @Test
    void testSizeOnEmptyList() {
        int size = list.size();

        assertThat(size).isEqualTo(0);
    }

    @Test
    void testClearOnEmptyList() {
        list.clear();

        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void testClearChangesTheSize() {
        list = LinkedList.of(4, 5, 6);

        list.clear();

        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    void testClearRemovesElements() {
        list = LinkedList.of(4, 5, 6);

        list.clear();

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> list.get(0));
    }
}
