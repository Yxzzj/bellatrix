package pres.jeremy.bellatrix.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pres.jeremy.bellatrix.user.entity.RoleDO;
import pres.jeremy.bellatrix.user.mapper.RoleMapper;
import pres.jeremy.bellatrix.user.service.IRoleService;

@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleDO> implements IRoleService {
}
