package main.config.mapper;

import entity.UserCustom;
import entity.UserQueryVo;

import java.util.List;

public interface UserMapper {
    /**
     * [分页][条件]查询所有用户信息
     * @param userQueryVo 查询信息的封装，包括User信息和Page（分页）信息
     * @return 查询出的UserCustom列表
     */
    public List<UserCustom> findUserLimitInDetail(UserQueryVo userQueryVo) throws Exception;
}
