package dao;

import entity.Pet;
import entity.PetCustom;

import java.sql.SQLException;
import java.util.List;

public interface PetDao {
    /**
     * 向数据库中的Pet（宠物）表中添加数据
     * @param pet 传入的封装好的数对象
     * @return 添加成功返回true，否则返回false
     */
    public boolean addPet(Pet pet);

    /**
     * 根据p_id从Pet表中删除一条信息
     * @param p_id 需要删除的信息的p_id
     * @return 删除成功返回true，否则返回false
     */
    public boolean deletePet(int p_id);

    /**
     * 根据传入信息更改一条Pet表中的数据
     * @param pet 传入的信息，p_id为查找该条信息的条件，其他数据均为新数据修改到该信息处
     * @return 修改成功返回true，否则返回false
     */
    public boolean updatePet(Pet pet);

    /**
     * 查询Pet表中的所有信息
     * @return 将表中的所有信息封装成List<Pet>进行返回
     */
    public List<Pet> findAllPet() throws SQLException;

    /**
     * 查询Pet表中的详细信息（使用连接查询）
     * @return PetCustom包装类的List
     */
    public List<PetCustom> findAllPetInDetail() throws SQLException;

    public List<PetCustom> findPetLimitInDetail(int pagr) throws SQLException;
}
