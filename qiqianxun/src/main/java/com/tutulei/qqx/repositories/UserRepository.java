package com.tutulei.qqx.repositories;


import com.tutulei.qqx.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserPhoneAndUserPwd(String phone,String password);
    UserEntity findByUserPhone(String phone);
    UserEntity findByUserName(String name);
    UserEntity findByUserIdAndUserPwd(int id,String pwd);
}
