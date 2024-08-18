package com.jyy.riskctrl.utils.date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = DateUtilTest.class)
class DateUtilTest {


    @Test
    void testConvertLocalDateTime2Str() {
        assertThat(DateUtil.convertLocalDateTime2Str(LocalDateTime.of(2020, 1, 1, 0, 0, 0))).isEqualTo("2020-01-01 00:00:00");
    }

    @Test
    void testConvertStr2LocalDateTime() {
        assertThat(DateUtil.convertStr2LocalDateTime("2020-01-01 00:00:00")).isEqualTo(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
    }

    @Test
    void testConvertTimestamp2LocalDateTime() {
        assertThat(DateUtil.convertTimestamp2LocalDateTime(1723943076000L)).isEqualTo(LocalDateTime.of(2024, 8, 18, 9, 4, 36));
    }

    @Test
    void testConvertLocalDateTime2Timestamp() {
        assertThat(DateUtil.convertLocalDateTime2Timestamp(LocalDateTime.of(2024, 8, 18, 9, 4, 36))).isEqualTo(1723943076000L);
    }
}
