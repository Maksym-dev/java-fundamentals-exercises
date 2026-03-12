package com.bobocode.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinarySearchTreeTest {
    
    private static final Integer[] elements = {10, 9, 11, 8, 12, 7};

    @Test
    void testCreateWithElements() {
        BinarySearchTree<Integer> bst = RecursiveBinarySearchTree.of(elements);
        for (var e : elements) {
            assertThat(bst.contains(e)).isTrue();
        }
        assertThat(bst.size()).isEqualTo(elements.length);
    }

    @Test
    void testInsertUniqueElements() {
        BinarySearchTree<Integer> bst = RecursiveBinarySearchTree.of();
        for (int i = 0; i < elements.length; i++) {
            var e = elements[i];
            assertThat(bst.contains(e)).isFalse(); //does not contain
            assertThat(bst.size()).isEqualTo(i);

            assertThat(bst.insert(e)).isTrue(); //do insert

            assertThat(bst.contains(e)).isTrue(); //and contains
            assertThat(bst.size()).isEqualTo(i + 1);
        }
    }

    @Test
    void testInsertNonUniqueElements() {
        BinarySearchTree<Integer> bst = RecursiveBinarySearchTree.of(elements);
        for (var e : elements) {
            assertThat(bst.insert(e)).isFalse(); //does not insert
            assertThat(bst.contains(e)).isTrue(); //but contains
        }
        assertThat(bst.size()).isEqualTo(elements.length);
    }

    @ParameterizedTest
    @MethodSource("depthArguments")
    void testDepth(Integer[] elements, int depth) {
        BinarySearchTree<Integer> bst = RecursiveBinarySearchTree.of(elements);
        assertThat(bst.depth()).isEqualTo(depth);
    }

    @Test
    void testInorderTraversal() {
        BinarySearchTree<Integer> bst = RecursiveBinarySearchTree.of(elements);
        Integer[] sortedElements = Arrays.copyOf(elements, elements.length);
        Arrays.sort(sortedElements);

        List<Integer> traversedElements = new ArrayList<>(bst.size());
        bst.inOrderTraversal(traversedElements::add);

        assertThat(traversedElements).isEqualTo(List.of(sortedElements));
    }

    public static Stream<Arguments> depthArguments() {
        return Stream.of(
                //empty tree
                arguments(new Integer[]{}, 0),
                //tree with a single element
                arguments(new Integer[]{24}, 0),
                /*
                 * .......10
                 * ....../  \
                 * .....5   15
                 * ..../      \
                 * ...1       20
                 */
                arguments(new Integer[]{10, 5, 15, 1, 20}, 2),
                /*
                 * ..1
                 * ...\
                 * ....2
                 * .....\
                 * ..... 3
                 * .......\
                 * ........4
                 * .........\
                 * ..........5
                 */
                arguments(new Integer[]{1, 2, 3, 4, 5}, 4));
    }
}
