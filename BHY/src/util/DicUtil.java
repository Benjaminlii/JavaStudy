package util;

import dao.DictionaryDao;
import dao.DictionaryDaoImpl;
import entity.Dictionary;
import net.sf.json.JSONObject;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据字典的工具类
 */
public class DicUtil {
    /**
     * 将传入的Dictionary List转换成由d_id和d_value组成的map
     * @param dicList 字典列表
     * @return 字典map
     */
    public static Map<Integer, String> dicToMap(List<Dictionary> dicList){
        Map<Integer, String> dicMap = new HashMap<>();
        for(Dictionary dic : dicList){
            dicMap.put(dic.getD_id(), dic.getD_value());
        }
        return dicMap;
    }

    /**
     * 获得数据字典中d_id和d_value对应的map所转化成的json对象
     * @return json{d_id：d_value。。。。。}
     */
    public static JSONObject getDicMapJson(){
        //得到宠物类型的字典
        JSONObject dics = null;
        DictionaryDao dictionaryDao = new DictionaryDaoImpl();
        try {
            dics = JSONObject.fromObject(
                    DicUtil.dicToMap(
                            dictionaryDao.findAllDictionary()
                    )
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dics;
    }
}
