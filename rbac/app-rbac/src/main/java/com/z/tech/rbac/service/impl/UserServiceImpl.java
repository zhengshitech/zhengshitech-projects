package com.z.tech.rbac.service.impl;

import com.z.tech.rbac.dao.UserDao;
import com.z.tech.rbac.dto.UserDTO;
import com.z.tech.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

import static com.z.tech.rbac.util.CipherUtil.doEncrypt;
import static com.z.tech.rbac.util.UUIDUtil.randomUUID;

/**
 * @author H
 */
@Service
@Validated
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(@Valid UserDTO user) {
        String key = randomUUID();
        user.setPasswordKey(key);
        String savePass = doEncrypt(user.getPassword(), key);
        user.setPassword(savePass);
        userDao.save(user);
    }


    @Override
    public void modify(@Valid UserDTO user) {
        userDao.modify(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public UserDTO getByID(Integer id) {
        return userDao.getByID(id);
    }

    @Override
    public List<UserDTO> getByIDs(@Valid @Size(min = 1, message = "至少需要一个用户ID") List<Integer> ids) {
        return userDao.getByIDs(ids);
    }

    @Override
    public boolean getByPhone(String phone) {
        return userDao.getByPhone(phone);
    }

    @Override
    public List<UserDTO> getByDepartment(Integer departmentId) {
        return userDao.getByDepartment(departmentId);
    }
}
