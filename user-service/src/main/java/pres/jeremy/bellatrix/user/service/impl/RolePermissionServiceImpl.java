package pres.jeremy.bellatrix.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pres.jeremy.bellatrix.user.entity.RolePermissionDO;
import pres.jeremy.bellatrix.user.mapper.RolePermissionMapper;
import pres.jeremy.bellatrix.user.service.IRolePermissionService;

@Slf4j
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermissionDO> implements IRolePermissionService {
}
