package pres.jeremy.bellatrix.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pres.jeremy.bellatrix.user.entity.UserRoleDO;
import pres.jeremy.bellatrix.user.mapper.UserRoleMapper;
import pres.jeremy.bellatrix.user.service.IUserRoleService;

@Slf4j
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleDO> implements IUserRoleService {
}
