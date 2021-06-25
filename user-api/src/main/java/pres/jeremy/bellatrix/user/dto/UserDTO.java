package pres.jeremy.bellatrix.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserDTO {

    private Long id;

    private String name;

    private String password;

    private Integer gender;

    private String address;
}
