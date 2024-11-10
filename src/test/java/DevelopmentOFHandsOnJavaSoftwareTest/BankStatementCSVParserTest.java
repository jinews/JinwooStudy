package DevelopmentOFHandsOnJavaSoftwareTest;


import DevelopmentOFHandsOnJavaSoftware.BankStatementCSVParser;
import DevelopmentOFHandsOnJavaSoftware.BankStatementParser;
import DevelopmentOFHandsOnJavaSoftware.BankTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {
    // 테스트할 클래스를 불러오기
    private final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        /* ( Given 단계 ) */
        // 예제 텍스트 작성
        final String line = "30-01-2017,-50,Tesco";

        /* ( When 단계 ) */
        // 예제 텍스트를 불러온 파서클래스에 주입
        final BankTransaction result = statementParser.parseFrom(line);
        // 비교/확인군으로 생성자로 객체를 직접 생성
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30),-50,"Tesco");
        final double tolerance = 0.0d;

        /* ( Then 단계 ) */
        Assertions.assertEquals(expected.getDate(), result.getDate());
        Assertions.assertEquals(expected.getAmount(), result.getAmount());
        Assertions.assertEquals(expected.getDescription(), result.getDescription());
    }

}
