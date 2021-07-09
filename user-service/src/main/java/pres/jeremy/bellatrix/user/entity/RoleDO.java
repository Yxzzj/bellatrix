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
@TableName("b_role")
@ApiModel(description = "角色表")
public class RoleDO extends BaseDO {

    private String code;

    private String name;

    private String description;
}