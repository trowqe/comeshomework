package task5;

import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void test1() {
        int arr[] = {1, 2, 2, 3, 5, 7, 8, 8, 9, 9};
        assert (0 == BinarySearch.search(arr, 1, 0, arr.length - 1));
        assert (1 == BinarySearch.search(arr, 2, 0, arr.length - 1));
        assert (3 == BinarySearch.search(arr, 3, 0, arr.length - 1));
        assert (4 == BinarySearch.search(arr, 5, 0, arr.length - 1));
        assert (5 == BinarySearch.search(arr, 7, 0, arr.length - 1));
        assert (7 == BinarySearch.search(arr, 8, 0, arr.length - 1));
        assert (8 == BinarySearch.search(arr, 9, 0, arr.length - 1));
    }


    @Test
    public void test2() {
        int arr[] = {1, 2, 3, 5, 7, 8, 9};
        assert (0 == BinarySearch.search(arr, 1, 0, arr.length - 1));
        assert (1 == BinarySearch.search(arr, 2, 0, arr.length - 1));
        assert (2 == BinarySearch.search(arr, 3, 0, arr.length - 1));
        assert (3 == BinarySearch.search(arr, 5, 0, arr.length - 1));
        assert (4 == BinarySearch.search(arr, 7, 0, arr.length - 1));
        assert (5 == BinarySearch.search(arr, 8, 0, arr.length - 1));
        assert (6 == BinarySearch.search(arr, 9, 0, arr.length - 1));
    }

    @Test
    public void test3() {
        int arr[] = {1};
        assert (0 == BinarySearch.search(arr, 1, 0, arr.length - 1));
    }

    @Test
    public void test4() {
        int arr[] = {5, 5, 5, 5, 5, 6};
        assert (5 == BinarySearch.search(arr, 6, 0, arr.length - 1));
    }

    @Test
    public void test5() {
        int arr[] = {5, 5, 5, 5, 6, 6};
        assert (4 == BinarySearch.search(arr, 6, 0, arr.length - 1));
        assert (2 == BinarySearch.search(arr, 5, 0, arr.length - 1));
    }

}
