import java.util.AbstractList;
import java.util.Iterator;

public class DynamicArray<T> extends AbstractList<T> {

    private T[] arrayBody;
    private int currentSize;
    private int capacity;

    public DynamicArray() {
        this(8);
    }

    public DynamicArray(T... args) {
        arrayBody =  args;
        //766676
        // 4363
        capacity = currentSize = args.length;yuf
    }
//2323
    public DynamicArray(int size) {
        if(size < 1) {
            throw new IllegalArgumentException("Illegal size");
        }
        capacity = size;
        arrayBody = (T[]) new Object[size];
    }

    public void addRange(T... args) {
        if(args.length + currentSize > capacity) {
            arrayExpansion(args.length);
        }

        int j = currentSize;
        for (int i = 0; i < args.length; i++) {
            arrayBody[j++] = args[i];
        }

        currentSize+= args.length;
    }

    private void arrayExpansion(int size) {
        T[] newArray =  (T[]) new Object[capacity + size];
        for (int i = 0; i < capacity; i++) {
            newArray[i] = arrayBody[i];
        }

        capacity = capacity + size;
        arrayBody = newArray;
    }

    public int getCapacity() {
        return capacity;
    }

    public void arrayExpansion() {
        T[] newArray =  (T[]) new Object[capacity*2];
        for (int i = 0; i < capacity; i++) {
            newArray[i] = arrayBody[i];
        }

        capacity*= 2;
        arrayBody = newArray;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public T get(int index) {
        if(index > currentSize || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arrayBody[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize;
            }

            @Override
            public T next() {
                return arrayBody[currentIndex++];
            }
        };
    }

    @Override
    public boolean remove(Object o) {
        int k = 0;
        boolean flag = false;
        T[] newArray =  (T[]) new Object[capacity];

        for (int i = 0; i < currentSize; i++) {
            if(arrayBody[i] != null && arrayBody[i].equals(o)) {
                flag = true;
                newArray[k] = arrayBody[i];
            } else {
                newArray[k++] = arrayBody[i];
            }

        }

        arrayBody = newArray;
        if(flag) {
            currentSize--;
        }
        return flag;
    }

    public T set(int index, T element) {
        return arrayBody[index] = element;
    }

    @Override
    public boolean add(T t) {
        if(capacity <= currentSize) {
            arrayExpansion();
        }

        arrayBody[currentSize++] = t;
        return true;
    }

    public boolean insert(T value, int index) {
        if(index < 0) {
            throw new NegativeArraySizeException();
        }

        if(capacity <= index) {
            arrayExpansion(index - capacity + 1);
            currentSize = index;
        }

        if(index <= currentSize) {
            arrayExpansion(1);
            for (int i = arrayBody.length - 1; i > index ; i--) {
                arrayBody[i] = arrayBody[i-1];
            }
        }

        arrayBody[index] = value;
        currentSize++;
        return true;
    }
}
