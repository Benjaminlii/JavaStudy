package HomeWork.Date_2018_11_27;
/**
 * 这个注释之前的别抄
 * P489 12.7
 */
public class binToDecimal {
    public static int bin2Dec(String bin) {
        try {
            return Integer.parseInt(bin, 2);//使用第二个参数指定的基数，将字符串参数解析为有符号的整数!
        }catch (NumberFormatException e){
            throw e;
        }
    }

    public static void main(String[] args) {
        String bin = "11010101";
        System.out.println(bin2Dec(bin));
    }
}
