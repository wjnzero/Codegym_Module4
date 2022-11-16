package com.hug.service.role;

import com.hug.model.Role;
import com.hug.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
