package dao;

import entity.Cargo;

import java.util.List;

public interface CargoDao {
    /**
     * 向数据库中的cargo（商品）表中添加数据
     * @param cargo 传入的封装好的数对象
     * @return 添加成功返回true，否则返回false
     */
    public boolean addCargo(Cargo cargo);

    /**
     * 根据c_id从cargo表中删除一条信息
     * @param c_id 需要删除的信息的c_id
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteCargo(int c_id);

    /**
     * 根据传入信息更改一条cargo表中的数据
     * @param cargo 传入的信息，c_id为查找该条信息的条件，其他数据均为新数据修改到该信息处
     * @return 修改成功返回true，否则返回false
     */
    public boolean updateCargo(Cargo cargo);

    /**
     * 查询cargo表中的所有信息
     * @return 将表中的所有信息封装成List<Cargo>进行返回
     */
    public List<Cargo> findAllCargo();
}
