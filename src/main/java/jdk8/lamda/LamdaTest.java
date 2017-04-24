package jdk8.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by lihuiyan on 2017/4/24.
 */
public class LamdaTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(n-> System.out.println(n));
        System.out.println("-----");
        evaluate(list, n -> true);

    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n);
            }
        }
    }
}
