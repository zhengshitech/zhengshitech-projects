package com.z.tech.rbac.controller;

import com.z.tech.core.exception.BizException;
import com.z.tech.rbac.dto.TenantDTO;
import com.z.tech.rbac.service.TenantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.z.tech.core.exception.BizCode.QUERY_DATA_NOT_EXIST;
import static com.z.tech.rbac.api.AppDefinition.MY_API_PREFIX;

/**
 * @author H
 */
@Api(value = "租户管理", description = "租户管理")
@RestController
@Validated
@RequestMapping(MY_API_PREFIX + "/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;


    @ApiOperation(value = "添加租户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody @Valid TenantDTO newTenant) {
        System.err.println("add a new tenant---" + newTenant);
        tenantService.save(newTenant);
        return "operate success with id:" + newTenant.getId();
    }

    @ApiOperation(value = "查询一个租户")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public TenantDTO get(@PathVariable("id") Integer id) {
        System.out.println("get tenant of :" + id);
        TenantDTO tenant = tenantService.getByID(id);
        return tenant;
    }


    @ApiOperation(value = "查询一个租户，并返回null")
    @RequestMapping(value = "/get_and_return_null", method = RequestMethod.GET)
    public TenantDTO getAndReturnNull() {
        return null;
    }

    @ApiOperation(value = "查询一个租户，并返回list null")
    @RequestMapping(value = "/get_and_return_list_null", method = RequestMethod.GET)
    public List<TenantDTO> getAndReturnListNull() {
        return null;
    }


    @ApiOperation(value = "查询一个租户，并返回new ArraryList when it's null")
    @RequestMapping(value = "/get_and_return_new_list_when_null", method = RequestMethod.GET)
    public List<TenantDTO> getAndReturnNewList() {
        return new ArrayList<>(0);
    }


    @ApiOperation(value = "返回void测试")
    @RequestMapping(value = "/get_void", method = RequestMethod.GET)
    public void getAndReturnVoid() {

    }

    @ApiOperation(value = "返回boolean测试")
    @RequestMapping(value = "/get_return_boolean", method = RequestMethod.GET)
    public boolean getAndReturnBoolean() {
        return true;
    }


    @ApiOperation(value = "返回int测试")
    @RequestMapping(value = "/get_return_int", method = RequestMethod.GET)
    public int getAndReturnInt() {
        return 2;


    }

    @ApiOperation(value = "异常测试")
    @RequestMapping(value = "/my_exception/{type}", method = RequestMethod.GET)
    public int myException(@PathVariable("type") Integer type) {
        if (Objects.equals(1, type)) {
            throw new BizException(QUERY_DATA_NOT_EXIST);
        } else if (Objects.equals(2, type)) {
            throw new NullPointerException("测试");
        }
        return 2;
    }

}
