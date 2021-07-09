package pres.jeremy.bellatrix.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import pres.jeremy.bellatrix.user.base.BaseDO;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@TableName("b_user_role")
@ApiModel(description = "用户角色表")
public class UserRoleDO extends BaseDO {

    private Long userId;

    private Long roleId;
}
