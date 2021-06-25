package pres.jeremy.bellatrix.user.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import pres.jeremy.bellatrix.common.util.constant.FieldConstant;
import pres.jeremy.bellatrix.common.util.utils.UserUtil;
import pres.jeremy.bellatrix.user.dto.UserDTO;

import java.time.LocalDateTime;

@Component
public class ModelMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object gmtCreate = this.getFieldValByName(FieldConstant.GMT_CREATE, metaObject);
        if (null == gmtCreate) {
            this.strictInsertFill(metaObject, FieldConstant.GMT_CREATE, LocalDateTime.class, LocalDateTime.now());
        }
        Object gmtModify = this.getFieldValByName(FieldConstant.GMT_MODIFY, metaObject);
        if (null == gmtModify) {
            this.strictInsertFill(metaObject, FieldConstant.GMT_MODIFY, LocalDateTime.class, LocalDateTime.now());
        }
        Object createMan = this.getFieldValByName(FieldConstant.CREATOR, metaObject);
        if (null == createMan) {
            UserDTO user = UserUtil.getUser();
            if (user != null) {
                this.strictInsertFill(metaObject, FieldConstant.CREATOR, String.class, UserUtil.getUser().getName());
            }
        }
        Object isDeleted = this.getFieldValByName(FieldConstant.IS_DELETED, metaObject);
        if (null == isDeleted) {
            this.strictInsertFill(metaObject, FieldConstant.IS_DELETED, Integer.class, 0);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, FieldConstant.GMT_MODIFY, LocalDateTime.class, LocalDateTime.now());
        UserDTO user = UserUtil.getUser();
        if (user != null) {
            this.strictInsertFill(metaObject, FieldConstant.CREATOR, String.class, UserUtil.getUser().getName());
        }
    }
}
