package dao;

import entity.Dictionary;

import java.sql.SQLException;
import java.util.List;

public interface DictionaryDao {
    /**
     * 向数据库中的dictionary（数据字典）表中添加数据
     * @param dictionary 传入的封装好的数对象
     * @return 添加成功返回true，否则返回false
     */
    public boolean addDictionary(Dictionary dictionary);

    /**
     * 根据d_id从Dictionary表中删除一条信息
     * @param d_id 需要删除的信息的d_id
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteDictionary(int d_id);

    /**
     * 根据传入信息更改一条Dictionary表中的数据
     * @param dictionary 传入的信息，d_id为查找该条信息的条件，其他数据均为新数据修改到该信息处
     * @return 修改成功返回true，否则返回false
     */
    public boolean updateDictionary(Dictionary dictionary);

    /**
     * 查询Dictionary表中的所有信息
     * @return 将表中的所有信息封装成List<Dictionary>进行返回
     */
    public List<Dictionary> findAllDictionary() throws SQLException;
}
