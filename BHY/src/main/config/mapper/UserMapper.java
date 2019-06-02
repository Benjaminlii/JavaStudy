package main.config.mapper;

import entity.UserCustom;
import entity.UserQueryVo;

import java.util.List;

public interface UserMapper {
    /**
     * [分页][条件]查询所有用户信息
     *
     * @param userQueryVo 查询信息的封装，包括User信息和Page（分页）信息
     * @return 查询出的UserCustom列表
     */
    public List<UserCustom> findUserLimitInDetail(UserQueryVo userQueryVo) throws Exception;

    /**
     * 根据username查询用户对象
     *
     * @param username 用户名
     * @return 查询到返回UserCustom对象，否则返回null
     */
    public UserCustom findUserByUserName(String username) throws Exception;

    /**
     * 添加一条用户信息
     * 并将添加的用户信息的u_id回返
     *
     * @param userCustom 要添加的用户信息
     * @return 添加成功返回true，否则返回false
     */
    public boolean insertUser(UserCustom userCustom) throws Exception;

    /**
     * 更新用户信息（大概就是修改密码）
     * @param userCustom 更新的用户信息（包括要修改的用户名和新密码）
     * @return 成功返回true，否则返回false
     */
    public boolean updateUser(UserCustom userCustom) throws Exception;

}
