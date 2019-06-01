package util;


import entity.Page;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 关于输入映射和动态sql
 */
public class SQLUtil {
//    public static String getSelectSQL(String tableName, Map<String, String> fields, Page page){
//        StringBuffer sql = new StringBuffer("select * from " + tableName);
//        if(!fields.isEmpty()){
//            sql.append(" where ");
//            Set<String> keys = fields.keySet();
//            for(String key : keys){
//                if(!"".equals(fields.get(key))) {
//                    sql.append(key).append("=").append(fields.get(key)).append(",");
//                }
//            }
//            //删除最后一个逗号
//            sql.deleteCharAt(sql.length() - 1);
//        }
//        if(page != null){
//            sql.append(" limit ").append(page.getOffSet()).append(",").append(Page.getSize());
//        }
//        sql.append(";");
//        return sql.toString();
//    }
//
//    public static void main(String[] args) {
//        String tableName = "cargo";
//        Map<String, String> fields = new HashMap<>();
//        fields.put("c_name", "aa");
//        fields.put("c_type", "bb");
//        Page page = new Page(3);
//        System.out.println(getSelectSQL(tableName, fields, page));
//    }
}
