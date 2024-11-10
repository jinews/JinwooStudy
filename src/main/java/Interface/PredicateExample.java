package Interface;

import java.util.function.Predicate;
/**
 * 조건, 판단기준, 조건검사 인터페이스, 판별자
 * Predicate : 특정 조건을 검사하거나 필터링 하는데 사용
 * 단일 인자를 받아 불리언 값을 반환하는 test 메서드를 가지고 있음
 * 주어진 조건을 만족하는지 여부를 판단
 * test(T t) : 조건을 검사하여 true or false 를 반환
 * and(Predicate other): 두 조건을 AND 조건으로 결합
 * or(Predicate other): 두 조건을 OR 조건으로 결합
 * negate(): 조건을 반대로 설정 (true -> false, false -> true)
 * */
public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = number -> number % 2 == 0;

        System.out.println(isEven.test(4));
        System.out.println(isEven.test(5));

        Predicate<Integer> isGreaterThan10 = number -> number > 10;
        Predicate<Integer> isEvenAndGreaterThan10 = isEven.and(isGreaterThan10);

        System.out.println(isEvenAndGreaterThan10.test(12));
        System.out.println(isEvenAndGreaterThan10.test(8));
    }
}
