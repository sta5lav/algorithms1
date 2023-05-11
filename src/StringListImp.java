import Exeptions.IndexOutOfBoundsException;
import Exeptions.NullException;
import Exeptions.FullStorageException;

import java.util.Arrays;

public class StringListImp implements StringList {

    private String[] strings;


    private int size;

    public StringListImp(int size) {
        strings = new String[size];
    }

    public StringListImp() {
        strings = new String[15];
    }

    @Override
    public String add(String item) {
        validatecheckStringsArrayIsFull();
        validatecheckItem(item);
        strings[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validatecheckIndex(index);
        validatecheckItem(item);
        validatecheckStringsArrayIsFull();
        if (index == size) {
            add(item);
            return item;
        }
        size++;
        for (int i = size; i > index; i++) {
            strings[i] = strings[i - 1];
        }
        strings[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validatecheckItem(item);
        validatecheckIndex(index);
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validatecheckItem(item);
        if (!contains(item)) {
            throw new NullException();
        }
        if(indexOf(item) == (size - 1)){
            size--;
            return item;
        }
        for (int i = indexOf(item); i < size - 1; i++) {
            strings[i] = strings[i + 1];
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        validatecheckIndex(index);
        String s = get(index);
        if (index == size - 1) {
            size--;
            return s;
        }
        for (int i = index; i < size - 1; i++) {
            strings[i] = strings[i + 1];
        }
        return s;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) == -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (strings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >=0 ; i--) {
            if (strings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validatecheckIndex(index);
        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
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
    public String[] toArray() {
        return Arrays.copyOf(strings, size);
    }


    public void validatecheckIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Индекс больше фактического количества элементов или выходит за пределы массива!");
        }
    }


    public void validatecheckItem(String item) {
        if (item == null) {
            throw new NullException();
        }
    }


    public void validatecheckStringsArrayIsFull() {
        if (size == strings.length) {
            throw new FullStorageException("Индекс больше фактического количества элементов или выходит за пределы массива!");
        }
    }

}
