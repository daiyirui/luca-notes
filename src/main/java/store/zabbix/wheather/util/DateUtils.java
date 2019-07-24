package store.zabbix.wheather.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * description: 时间工具类
 *
 * @author eyck.cui update: 2019-07-25 00:16
 **/
public class DateUtils {

    /**
     * description: 获得10位时间戳
     *
     * @param date 当前时间
     * @return java.lang.Long
     * @author eyck.cui update: 2019-07-25 00:22
     **/
    public static Long getTimestamp(Date date) {
        return LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));

    }

}
