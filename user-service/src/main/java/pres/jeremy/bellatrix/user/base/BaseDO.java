package pres.jeremy.bellatrix.user.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class BaseDO {

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 是否删除（1：删除；0：未删除）
     */
    @TableLogic
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modify", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModify;

    /**
     * 创建人
     */
    @TableField(value = "creator", fill = FieldFill.INSERT_UPDATE)
    private String creator;
}
