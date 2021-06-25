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
@TableName("b_user")
@ApiModel(description = "用户表")
public class UserDO extends BaseDO {

    private String name;

    private String password;

    private Integer gender;

    private String address;
}
