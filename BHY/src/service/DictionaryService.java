package service;

import entity.Dictionary;
import entity.DictionaryQueryVo;
import main.config.mapper.DictionaryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DictionaryService {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try (
                InputStream inputStream = Resources.getResourceAsStream("main/config/SqlMapConfig.xml")
        ) {
            DictionaryService.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据父节点的value查找其子结点
     * @param dictionary 查询信息，只需要填充d_value字段
     * @return 成功返回List，失败返回null
     */
    public static List<Dictionary> findDicByParValue(Dictionary dictionary){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DictionaryMapper dictionaryMapper = sqlSession.getMapper(DictionaryMapper.class);
        List<Dictionary> dictionaries = null;

        try {
            dictionaries = dictionaryMapper.findDicByParValue(dictionary);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dictionaries;
    }

    /**
     * 分页查询字典信息
     * @param dictionaryQueryVo 只需要填充分页信息
     * @return 查询成功返回List，否则返回null
     */
    public static List<Dictionary> findDicLimit(DictionaryQueryVo dictionaryQueryVo){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DictionaryMapper dictionaryMapper = sqlSession.getMapper(DictionaryMapper.class);
        List<Dictionary> dictionaries = null;

        try {
            dictionaries = dictionaryMapper.findDicLimit(dictionaryQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dictionaries;
    }
}
