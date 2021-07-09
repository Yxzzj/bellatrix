package pres.jeremy.bellatrix.common.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserDTO {

    private Long id;

    private String userName;

    private String name;

    private Integer gender;

    private String address;
}
