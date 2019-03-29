import java.util.Collections;

public class Runner {

    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3, 44, 77);
        DynamicArray<Integer> array1 = new DynamicArray<>(10);
        DynamicArray<Integer> array2 = new DynamicArray<>();
        System.out.println(array1.getCapacity());
        System.out.println(array2.getCapacity());
        System.out.println(array);
        array.add(399);
        array.add(-100);
        array.add(444);
        System.out.println(array);
        array.insert(666, 2);
        System.out.println(array);

        Collections.sort(array);
//        System.out.println(array);

        array.addRange(5, -100, 77);
        System.out.println(array);
        array.remove(new Integer(666));
        System.out.println(array);
        array.set(0, 33);
        System.out.println(array.get(0));
    }
}
