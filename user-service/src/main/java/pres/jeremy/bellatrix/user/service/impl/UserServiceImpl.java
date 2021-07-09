package pres.jeremy.bellatrix.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pres.jeremy.bellatrix.common.web.utils.BeanUtil;
import pres.jeremy.bellatrix.common.web.utils.ExceptionUtil;
import pres.jeremy.bellatrix.common.web.utils.MD5Util;
import pres.jeremy.bellatrix.common.web.dto.UserDTO;
import pres.jeremy.bellatrix.user.entity.UserDO;
import pres.jeremy.bellatrix.user.enums.ResultCode;
import pres.jeremy.bellatrix.user.mapper.UserMapper;
import pres.jeremy.bellatrix.user.query.LoginParam;
import pres.jeremy.bellatrix.user.query.SaveUserParam;
import pres.jeremy.bellatrix.user.service.IUserService;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements IUserService {

    @Override
    public Boolean saveUser(SaveUserParam saveUserParam) {
        UserDO userDO = BeanUtil.clone(saveUserParam, UserDO.class);
        saveUserParam.setPassword(MD5Util.getMD5(saveUserParam.getPassword()));
        baseMapper.insert(userDO);
        return true;
    }

    @Override
    public UserDTO login(LoginParam loginParam) {
        UserDO userDO = baseMapper.selectOne(new LambdaQueryWrapper<UserDO>()
                .eq(UserDO::getUserName, loginParam.getUserName()));
        ExceptionUtil.checkException(userDO, ResultCode.USER_NAME_NOT_EXISTS);
        if (!MD5Util.md5Verify(userDO.getPassword(), loginParam.getPassword())) {
            ExceptionUtil.throwException(ResultCode.PASSWORD_ERROR);
        }
        return BeanUtil.clone(userDO, UserDTO.class);
    }
}
