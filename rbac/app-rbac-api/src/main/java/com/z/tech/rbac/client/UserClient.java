package com.z.tech.rbac.client;

import com.z.tech.rbac.api.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import static com.z.tech.rbac.api.AppDefinition.APPLICATION_NAME;
import static com.z.tech.rbac.api.UserService.USER_WEB_API;

@FeignClient(value = APPLICATION_NAME, path = USER_WEB_API, fallbackFactory = UserClient.UserClientFallFactory.class)
public interface UserClient extends UserService {
    @Component
    static class UserClientFallFactory implements FallbackFactory<UserClient> {
        @Override
        public UserClient create(Throwable cause) {
            return new UserClient() {
                @Override
                public String works() {
                    throw new RuntimeException("服务器暂时无响应您的请求。。。");
//                    cause.printStackTrace();
//                    String msg = "fall back factory msg :ERROR from  fall back";
//                    System.err.println(msg);
//                    return msg;
                }
            };
        }
    }
}
