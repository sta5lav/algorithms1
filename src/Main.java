import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        IntegerListImp integerListImp = new IntegerListImp(100000);
        IntegerListImp integerListImp2 = new IntegerListImp(100000);

//        IntegerListImp integerListImp3 = new IntegerListImp(100000);
//
//
        Random rnd = new Random();
        for (int i = 0; i < integerListImp.size(); i++) {
            int add = rnd.nextInt(1000);
            integerListImp.add(add);
            integerListImp2.add(add);

        }
        long start = System.currentTimeMillis();
        integerListImp.mergeSort();
        System.out.println(System.currentTimeMillis() - start);
        for (int i = 8000; i > 500; i--) {
            System.out.println(integerListImp.get(i));
        }


//        56147 Пузырьковый способ
//        8311 Сортировка выбором
//       19034  Сортировка вставкой


    }
}