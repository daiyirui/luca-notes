package store.zabbix.apartment.util;

/**
 * description: 对象工具类
 *
 * @author eyck.cui createTime: 2019-07-27 10:52
 **/
public class ObjectUtils {

    /**
     * description: 判断字符串是否为数字
     *
     * @param str
     * @return boolean
     * @author eyck.cui date: 2019-07-27 10:53
     **/
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
