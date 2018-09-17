package com.z.tech.rbac.dao.impl;

import com.z.tech.rbac.dao.UserDao;
import com.z.tech.rbac.dto.UserDTO;
import com.z.tech.rbac.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author H
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void save(UserDTO user) {
        userMapper.insert(user);
    }

    @Override
    public void modify(UserDTO user) {

        userMapper.update(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public UserDTO getByID(Integer id) {
        return userMapper.selectByID(id);
    }

    @Override
    public List<UserDTO> getByIDs(List<Integer> ids) {
        return userMapper.selectByIDs(ids);
    }


    @Override
    public boolean getByPhone(String phone) {
        int count = userMapper.selectByPhone(phone);
        return count>0;
    }

    @Override
    public List<UserDTO> getByDepartment(Integer departmentId) {
        return userMapper.selectByDepartment(departmentId);
    }
}
