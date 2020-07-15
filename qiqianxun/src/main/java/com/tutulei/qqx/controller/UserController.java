package com.tutulei.qqx.controller;


import com.tutulei.qqx.entity.UserEntity;
import com.tutulei.qqx.formbean.User;
import com.tutulei.qqx.repositories.UserRepository;
import com.tutulei.qqx.view.ChangeMsg;
import com.tutulei.qqx.view.ChangePwd;
import com.tutulei.qqx.view.LoginView;
import com.tutulei.qqx.view.NewUser;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository repository;
    //spring会自动依赖注入↓
    UserController(UserRepository repository){
        this.repository = repository;
    }

    //用户登录post
    @PostMapping("/user/login")
    User Login(@RequestBody LoginView loginmsg) {
        User user = new User();
        UserEntity userentity = repository.findByUserPhoneAndUserPwd(
                loginmsg.getPhone(),
                loginmsg.getPassword()
        );
        if(userentity!=null){
            BeanUtils.copyProperties(userentity, user);
            return user;
        }
        return null;
    }
    //用户注册post
    @PostMapping("/user/register")
    User Register(@RequestBody NewUser newUser){
        UserEntity entity = new UserEntity();
        UserEntity u1 = repository.findByUserPhone(newUser.getUserPhone());
        UserEntity u2 = repository.findByUserName(newUser.getUserName());
        if(u1 == null && u2 == null) {
            BeanUtils.copyProperties(newUser, entity);
            entity.setUserState("暂无");
            UserEntity userEntity = repository.save(entity);
            User user = new User();
            BeanUtils.copyProperties(userEntity, user);
            return user;
        }
        return null;
    }
    //修改密码
    @PostMapping("/user/changePWD")
    boolean ChangePwd(@RequestBody ChangePwd changePwd){
        UserEntity user = repository.findByUserIdAndUserPwd(changePwd.getId(),changePwd.getOldpwd());
        if(user != null){
            user.setUserPwd(changePwd.getNewpwd());
            repository.save(user);
        }else {
            System.out.println("旧密码错误");
            return false;
        }
        return true;
    }
    //修改信息
    @PostMapping("/user/changeMsg")
    boolean ChangeMsg(@RequestBody ChangeMsg changeMsg){
//        UserEntity user = repository.findByUserIdAndUserPwd(changePwd.getId(),changePwd.getOldpwd());
//        if(user != null){
//            user.setUserPwd(changePwd.getNewpwd());
//            repository.save(user);
//        }else {
//            System.out.println("旧密码错误");
//            return false;
//        }
        return true;
    }
}
