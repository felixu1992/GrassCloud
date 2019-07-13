package top.felixu.grass.oauthserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.felixu.grass.oauthserver.entity.UserDetails;
import top.felixu.grass.oauthserver.entity.UserInfo;


/**
 *  Mapper 接口
 *
 * @author felixu
 * @date 2019.07.12
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 使用工号查询用户详情
     *
     * @param employeeNum 工号
     * @return 用户详情
     */
    UserDetails findUserDetails(@Param("employeeNum") String employeeNum);
}
