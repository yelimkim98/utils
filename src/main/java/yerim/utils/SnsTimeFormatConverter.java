package yerim.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class SnsTimeFormatConverter {

  private static final Long SEC_PER_MINUTE = 60L;
  private static final Long SEC_PER_HOUR = 3600L;
  private static final Long SEC_PER_DAY = 86400L;
  private static final Long SEC_PER_WEEK = 604800L;
  
  /**
   * 60초(1분) 미만 : 방금 전
   * 60초(1분) 이상, 3600초(1시간) 미만 : N분 전
   * 3600초(1시간) 이상, 86400초(24시간) 미만 : N시간 전
   * 86400초(24시간) 이상, 604800초(24*7시간) 미만 : N일 전
   * 604800초(24*7시간) 이상 : 2022년 O월 O일
   */
  public String convert(LocalDateTime target, LocalDateTime now) {
    final ZoneOffset SHARED_ZONE_OFFSET = ZoneOffset.MIN;
    long differenceInSec = now.toEpochSecond(SHARED_ZONE_OFFSET) - target.toEpochSecond(SHARED_ZONE_OFFSET);

    if (differenceInSec >= SEC_PER_WEEK) {
      return target.getYear() + "년 " + target.getMonthValue() + "월 " + target.getDayOfMonth() + "일";
    }
    if (differenceInSec >= SEC_PER_DAY) {
      return (differenceInSec / SEC_PER_DAY) + "일 전";
    }
    if (differenceInSec >= SEC_PER_HOUR) {
      return (differenceInSec / SEC_PER_HOUR) + "시간 전";
    }
    if (differenceInSec >= SEC_PER_MINUTE) {
      return (differenceInSec / SEC_PER_MINUTE) + "분 전";
    }
    if (differenceInSec >= 0) {
      return "방금 전";
    }
    throw new IllegalArgumentException("target 시각은 현재시각보다 작아야합니다.");
  }
}
