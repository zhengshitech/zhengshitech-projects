package com.z.tech.rbac.rbac;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        T001_TenantTests.class
        , T002_ApplicationRBACTests.class
        , T003_DepartmentTests.class
        , T004_UserTests.class
        , T005_RoleTests.class
        , T006_ResourceTests.class
        , T007_RoleResourcesTests.class
        , T008_RoleUsersTests.class
})
public class ApplicationRBACTests {

}
