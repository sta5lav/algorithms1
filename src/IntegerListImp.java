import Exeptions.FullStorageException;
import Exeptions.IndexOutOfBoundsException;
import Exeptions.NullException;

import java.util.Arrays;

public class IntegerListImp implements IntegerList {

    private int[] integerList;

    private int size;

    public IntegerListImp(int size) {
        integerList = new int[size];
    }

    public IntegerListImp() {
        integerList = new int[15];
    }


    @Override
    public int add(int item) {
        grow();
        validatecheckItem(item);
        integerList[size++] = item;
        return item;
    }

    @Override
    public int add(int index, int item) {
        validatecheckIndex(index);
        validatecheckItem(item);
        grow();
        if (index == size) {
            add(item);
            return item;
        }
        size++;
        for (int i = size; i > index; i++) {
            integerList[i] = integerList[i - 1];
        }
        integerList[index] = item;
        return item;
    }

    @Override
    public int set(int index, int item) {
        validatecheckItem(item);
        validatecheckIndex(index);
        integerList[index] = item;
        return item;
    }

    @Override
    public int remove(Integer item) {
        validatecheckItem(item);
        if (!contains(item)) {
            throw new NullException();
        }
        if (indexOf(item) == (size - 1)) {
            size--;
            return item;
        }
        for (int i = indexOf(item); i < size - 1; i++) {
            integerList[i] = integerList[i + 1];
        }
        size--;
        return item;
    }

    @Override
    public int remove(int index) {
        validatecheckIndex(index);
        Integer s = get(index);
        if (size - 1 == index) {
            size--;
            return s;
        }
        for (int i = index; i < size - 1; i++) {
            integerList[i] = integerList[i + 1];
        }
        return s;
    }

    @Override
    public boolean contains(int item) {
        sort();
        return binarySearch(item);
    }

    @Override
    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (integerList[i] == (item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        for (int i = size - 1; i >= 0; i--) {
            if (integerList[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        validatecheckIndex(index);
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return integerList.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int[] toArray() {
        return Arrays.copyOf(integerList, size);
    }


    @Override
    public void sort() {
        for (int i = 0; i < integerList.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integerList.length; j++) {
                if (integerList[j] < integerList[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integerList, i, minElementIndex);
        }
    }
    public  void mergeSort() {
        mergeSort(integerList);
    }

    public  void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }

    private void grow() {
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] == 0) {
                return;
            }
        }
        int[] integerList;
        integerList = Arrays.copyOf(this.integerList, (int) (size * 1.5));
        this.integerList = integerList;
    }

    private boolean binarySearch(int element) {
        int min = 0;
        int max = integerList.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == integerList[mid]) {
                return true;
            }

            if (element < integerList[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }


    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public void validatecheckIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Индекс больше фактического количества элементов или выходит за пределы массива!");
        }
    }


    public void validatecheckItem(Integer item) {
        if (item == null) {
            throw new NullException();
        }
    }


    public void validatecheckStringsArrayIsFull() {
        if (size == integerList.length) {
            throw new FullStorageException("Индекс больше фактического количества элементов или выходит за пределы массива!");
        }
    }
}
