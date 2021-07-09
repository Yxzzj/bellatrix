package pres.jeremy.bellatrix.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pres.jeremy.bellatrix.common.web.dto.UserDTO;
import pres.jeremy.bellatrix.user.entity.UserDO;
import pres.jeremy.bellatrix.user.query.LoginParam;
import pres.jeremy.bellatrix.user.query.SaveUserParam;

public interface IUserService extends IService<UserDO> {

    Boolean saveUser(SaveUserParam saveUserParam);

    UserDTO login(LoginParam loginParam);
}
