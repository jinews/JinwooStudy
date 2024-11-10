package DevelopmentOFHandsOnJavaSoftware;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;
    /**
     * 은행 거래 정보들을 리스트로 받아 객체를 생성하는 메서드
     * */
    public BankStatementProcessor(final List<BankTransaction> bankTransactions){
        this.bankTransactions = bankTransactions;
    }
    /**
     * 메서드가 수행하는 일을 바로 이해할 수 있도록 자체 문서화를 제공하는 문서명 사용
     * calculate = 계산 / totalAmount = 총 금액
     * 금액을 모두 합한 총 금액을 반환
     */
    public double calculateTotalAmount (){
        double total = 0d;
        for(final BankTransaction bankTransaction: bankTransactions){
            total += bankTransaction.getAmount();
        }
        return total;
    }
    /**
     * 해당하는 달의 총 금액을 반환
     */
    public double calculateTotalInMonth(final Month month){
        double total = 0;
        for(final BankTransaction bankTransaction: bankTransactions){
            if(bankTransaction.getDate().getMonth() == month){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
    /**
     * 입금자명을 인자로받아 해당하는 금액을 합하여 반환
     */
    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for(final BankTransaction bankTransaction: bankTransactions){
            if(bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
    /**
     * 특정 금액 이상의 은행 거래 내역 찾기
     * 인자값 : 기준 금액
     * 1. 결괏값 들어갈 리스트 생성
     * 2. 은행 거래내역중 금액 정보를 얻어내고 기준 금액보다 크면 결과 리스트에 추가
     */
    public List<BankTransaction> findTransactionsGreaterThanEqual( final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction: bankTransactions){
            if(bankTransaction.getAmount() >= amount){
                result.add(bankTransaction);
            }
        }
        return result;
    }
    /**
     * 특정 월의 입출금 내역 찾기
     * 인자값 : 찾고자하는 특정 월 값
     * 1. 결괏값 리스트 생성
     * 2. 은행 거래정보 객체에서 인자값과 동일한 달의 거래정보를 결과 리스트에 넣어 반환
     */
    public List<BankTransaction> findTransactionsInMonth( final Month month ) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
    /**
     * 함수형 인터페이스를 사용하여 if문에 boolean 값으로 해당하는 값 반환할 수 있도록 유연하게 변환
     */
    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter){
        final List<BankTransaction> result = new ArrayList<>();
        for(BankTransaction bankTransaction: bankTransactions){
            if(bankTransactionFilter.test(bankTransaction)){
                result.add(bankTransaction);
            }
        }
        return result;
    }
}
