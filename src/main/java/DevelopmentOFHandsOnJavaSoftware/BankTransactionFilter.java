package DevelopmentOFHandsOnJavaSoftware;
//함수형 인터페이스 명시
@FunctionalInterface
public interface BankTransactionFilter {
    /**
     * 완료된 BankTransaction 객체를 인수로 받아 Boolean 을 반환하는 메서드
     * BankTransaction 모든 속성에 접근하여 true/false 여부 판단
     * Predicate 제네릭 인터페이스를 사용하여도 됨
     */
    boolean test(BankTransaction bankTransaction);
}
