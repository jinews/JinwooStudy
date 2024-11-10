package DevelopmentOFHandsOnJavaSoftware;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * BankTransactionAnalyzerSimple 클래스의 파싱로직을 추출한 클래스
 * */
public class BankStatementCSVParser implements BankStatementParser {

    //날짜 포매터 설정
    public static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Override
    public BankTransaction parseFrom(final String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }
    @Override
    public List<BankTransaction> parseLinesFrom(final List<String> lines){
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for(final String line: lines){
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }
}