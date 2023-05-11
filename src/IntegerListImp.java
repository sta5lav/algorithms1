import Exeptions.FullStorageException;
import Exeptions.IndexOutOfBoundsException;
import Exeptions.NullException;

import java.util.Arrays;

public class IntegerListImp implements IntegerList{

    private final Integer[] integerList;

    private int size;

    public IntegerListImp(int size) {
       integerList = new Integer[size];
    }

    public IntegerListImp() {
        integerList = new Integer[15];
    }


    @Override
    public Integer add(Integer item) {
        validatecheckStringsArrayIsFull();
        validatecheckItem(item);
        integerList[size++] = item;
        return item;    }

    @Override
    public Integer add(int index, Integer item) {
        validatecheckIndex(index);
        validatecheckItem(item);
        validatecheckStringsArrayIsFull();
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
    public Integer set(int index, Integer item) {
        validatecheckItem(item);
        validatecheckIndex(index);
        integerList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validatecheckItem(item);
        if (!contains(item)) {
            throw new NullException();
        }
        if(indexOf(item) == (size - 1)){
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
    public Integer remove(int index) {
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
    public boolean contains(Integer item) {
        sort();
        return binarySearch(item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >=0 ; i--) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;    }

    @Override
    public Integer get(int index) {
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
       return size ==0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
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

    private boolean binarySearch(Integer element) {
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


    private static void swapElements(Integer[] arr, int indexA, int indexB) {
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
