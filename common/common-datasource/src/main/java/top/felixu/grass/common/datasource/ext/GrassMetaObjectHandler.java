package top.felixu.grass.common.datasource.ext;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import top.felixu.grass.common.core.constants.GrassConstants;
import top.felixu.grass.common.core.utils.UserUtils;

import java.time.LocalDateTime;

/**
 * Mybatis-Plus 自动填充
 *
 * @author felixu
 * @date 2019.07.16
 */
@Component
public class GrassMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (ObjectUtils.isEmpty(metaObject) ||
                ObjectUtils.isEmpty(metaObject.getValue(GrassConstants.Field.CREATE_BY))) {
            setInsertFieldValByName(GrassConstants.Field.CREATE_BY, UserUtils.getCurrentUserId(), metaObject);
        }
        if (ObjectUtils.isEmpty(metaObject) ||
                ObjectUtils.isEmpty(metaObject.getValue(GrassConstants.Field.CREATE_TIME))) {
            setInsertFieldValByName(GrassConstants.Field.CREATE_TIME, LocalDateTime.now(), metaObject);
        }
        updateFill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (ObjectUtils.isEmpty(metaObject) ||
                ObjectUtils.isEmpty(metaObject.getValue(GrassConstants.Field.UPDATE_BY))) {
            setUpdateFieldValByName(GrassConstants.Field.UPDATE_BY, UserUtils.getCurrentUserId(), metaObject);
        }
        if (ObjectUtils.isEmpty(metaObject) ||
                ObjectUtils.isEmpty(metaObject.getValue(GrassConstants.Field.UPDATE_TIME))) {
            setUpdateFieldValByName(GrassConstants.Field.UPDATE_TIME, LocalDateTime.now(), metaObject);
        }
    }
}
