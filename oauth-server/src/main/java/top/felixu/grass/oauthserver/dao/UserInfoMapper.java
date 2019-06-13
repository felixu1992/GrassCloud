package top.felixu.grass.oauthserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.felixu.grass.oauthserver.entity.UserDetails;
import top.felixu.grass.oauthserver.entity.UserInfo;

/**
 * UserInfoMapper接口
 *
 * @author felixu
 * @since 2019-06-13
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 根据工号查询用户
     *
     * @param employeeNum 工号
     * @return
     */
    UserDetails getUserByEmployeeNum(@Param("employeeNum") String employeeNum);

    /**
     * 获取用户权限点
     */
//    List<UserPermissionDTO> selectUserPemissionById(@Param("userId")String userId);
}
