package DevelopmentOFHandsOnJavaSoftware;

import java.time.Month;

public class BankTransactionIsInFebruaryAndExpensive  implements BankTransactionFilter{

    /**
     * bankTransactionFilter 함수형 인터페이스를 구현해 요구 사항을 충족시키는 메서드 생성
     */
    @Override
    public boolean test(final BankTransaction bankTransaction){
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() >= 1_000;
    }
}
