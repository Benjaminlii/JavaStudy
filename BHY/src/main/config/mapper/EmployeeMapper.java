package main.config.mapper;

import entity.EmployeeCustom;
import entity.EmployeeQueryVo;

import java.util.List;

public interface EmployeeMapper {
    /**
     * [分页][条件]查询员工信息
     * @param employeeQueryVo 查询条件
     * @return 查询出的员工信息
     */
    public List<EmployeeCustom> findEmployeeLimitInDetail(EmployeeQueryVo employeeQueryVo) throws Exception;

    /**
     * 添加一条员工信息，将e_id回返
     * @param employeeCustom 添加的信息
     * @return 成功返回true，否则返回false
     */
    public boolean insertEmployee(EmployeeCustom employeeCustom) throws Exception;

    /**
     * 更新员工信息
     * @param employeeCustom 包装更新信息，e_id为检索信息，其他为更新信息
     *                       可以更新的信息：姓名e_name，工资e_salary，所属宠物店st_id，职务d_id，年龄e_age
     * @return 更新成功返回true，否则返回false
     */
    public boolean updateEmployee(EmployeeCustom employeeCustom) throws Exception;

    /**
     * 删除一条员工信息
     * @param e_id 要删除的员工的e_id
     * @return 删除成功返回true，否则返回false
     */
    public boolean deleteEmployee(Integer e_id) throws Exception;
}
