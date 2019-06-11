package main.config.mapper;

import entity.Dictionary;
import entity.DictionaryQueryVo;

import java.util.List;

public interface DictionaryMapper {

    /**
     * 根据父节点的value查找其子结点
     * @param dictionary 查询信息，只需要填充d_value字段
     * @return 成功返回List，失败返回null
     */
    public List<Dictionary> findDicByParValue(Dictionary dictionary) throws Exception;

    /**
     * 分页查询字典信息
     * @param dictionaryQueryVo 只需要填充分页信息
     * @return 查询成功返回List，否则返回null
     */
    public List<Dictionary> findDicLimit(DictionaryQueryVo dictionaryQueryVo) throws Exception;

    /**
     * 根据d_id查询字典
     * @param d_id 拆线呢的id
     * @return 查询成功返回字典对象，失败返回null
     */
    public Dictionary findDicByID(Integer d_id) throws Exception;
}
