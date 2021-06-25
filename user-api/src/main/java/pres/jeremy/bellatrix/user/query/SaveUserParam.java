package pres.jeremy.bellatrix.user.query;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class SaveUserParam {

    private String name;

    private String password;

    private Integer gender;

    private String address;
}
