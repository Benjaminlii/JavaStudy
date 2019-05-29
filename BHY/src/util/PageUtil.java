package util;

/**
 * 分页帮助类
 */
public class PageUtil {
    private static final int size = 20;

    public static int getOffSet(int page){
        return size * (page-1);
    }

    public static int getSize() {
        return size;
    }
}
