package com.spring.loginmapper;



import org.apache.ibatis.annotations.Mapper;

import com.spring.loginvo.LoginVo;

@Mapper
public interface LoginMapper {

	public LoginVo getLogin(LoginVo loginVo) throws Exception;
}
