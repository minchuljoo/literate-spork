package com.spring.loginservice;


import com.spring.loginvo.LoginVo;

public interface LoginService {

	public LoginVo getLogin(LoginVo loginVo) throws Exception;
}
