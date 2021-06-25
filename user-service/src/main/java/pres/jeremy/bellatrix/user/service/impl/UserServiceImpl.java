package pres.jeremy.bellatrix.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pres.jeremy.bellatrix.common.util.utils.BeanUtil;
import pres.jeremy.bellatrix.user.entity.UserDO;
import pres.jeremy.bellatrix.user.mapper.UserMapper;
import pres.jeremy.bellatrix.user.query.SaveUserParam;
import pres.jeremy.bellatrix.user.service.IUserService;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements IUserService {

    @Override
    public Boolean saveUser(SaveUserParam saveUserParam) {
        UserDO userDO = BeanUtil.clone(saveUserParam, UserDO.class);
        baseMapper.insert(userDO);
        return true;
    }
}
