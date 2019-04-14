import java.util.*;

/**
 * whatever,write something.
 * <p>
 * author:Benjamin
 * date:2018.12.24
 */

public class Main {

    public static int muthod(HashMap<String, Integer> strs, ArrayList<String> string, int length){
        ArrayList<String> string_ = (ArrayList<String>)string.clone();
        boolean flag = false;
        for(String s:string_){
            if(s.length() == length){
                flag = true;
                return get(string_, s) + muthod(strs, string_, length);
            }
        }
        for(String s:string_){
            if(s.length() > length){
                flag = true;
                return get(string_, s) + muthod(strs, string_,s.length());
            }
        }
        return 0;
    }

    public static int get(ArrayList<String> string, String str){
        int num = 0;
        int sub;
        Iterator<String> it = string.iterator();
        while(it.hasNext()){
            String s = it.next();
            if((sub = s.indexOf(str)) != -1){
                System.out.println(s.length() + " " + sub);
                string.add(s.substring(0,sub));
                string.add(s.substring(sub+str.length()));
                it.remove();
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 子串数量
        int num = in.nextInt();
        in.nextLine();
        // 子串数组
        HashMap<String, Integer> strs = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String s = in.nextLine();
            strs.put(s,s.length());
        }
        //主串
        ArrayList<String> string = new ArrayList<>();
        string.add(in.nextLine());

        System.out.println(muthod(strs, string, 0));

        in.close();
    }
}