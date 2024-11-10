package DevelopmentOFHandsOnJavaSoftware;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 *  결합도를 줄이기위해 생성하는 클래스
 *  인자값으로 파일이름, parser인터페이스를 받는다
 */
public class BankStatementAnalyzer {
    private static final String RESOURCE = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCE + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }
    private static void collectSummary(final BankStatementProcessor bankStatementProcessor){
        System.out.println("The total for all transactions is" + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for all in January is" + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for all in February is" + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is" + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}