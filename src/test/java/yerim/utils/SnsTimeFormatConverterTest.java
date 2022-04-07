package yerim.utils;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class SnsTimeFormatConverterTest {

  @Test
  void convert() {
    LocalDateTime date1 = LocalDateTime.of(2022, 3, 1, 0, 0);
    LocalDateTime date2 = LocalDateTime.of(2022, 3, 1, 0, 0, 3);

    SnsTimeFormatConverter snsTimeFormatConverter = new SnsTimeFormatConverter();

    System.out.println(snsTimeFormatConverter.convert(date1, date2));
  }
}
