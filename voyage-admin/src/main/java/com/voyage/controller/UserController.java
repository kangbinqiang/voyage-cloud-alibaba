package com.voyage.controller;


import com.voyage.common.ResponseMO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Slf4j
@Api(tags = "用户管理")
@RefreshScope
public class UserController extends BaseController {


    @PostMapping
    @ApiOperation(value = "新增用户")
//    @RequiresPermissions("users")
    public ResponseMO add() {
        return success();
    }

}
