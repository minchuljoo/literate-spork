package com.spring.logincontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.spring.loginserviceimpl.LoginServiceImpl;
import com.spring.loginvo.LoginVo;

@Controller
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginService;

	@RequestMapping("/")
	public ModelAndView main () throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("11111111111111111");
		mv.setViewName("/index");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView getLogin (LoginVo loginVo) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		LoginVo result = loginService.getLogin(loginVo);
		mv.addObject("result", result);
		mv.setViewName("/login/login");
		return mv;
	}
	
	@RequestMapping("/oauth")
    public String kakaoConnect() throws Exception {
        StringBuffer url = new StringBuffer();
        String key = "ee4969f23edf0ce8234d94ec0d713af6";
        url.append("https://kauth.kakao.com/oauth/authorize?");
        url.append("client_id=" + key);
        url.append("&redirect_uri=http://localhost:8090/oauth_kakao");
        url.append("&response_type=code");

        return "redirect:" + url;
    }
	
	@ResponseBody
	@RequestMapping("/oauth_kakao")
	public void kakaoToken(String code) throws Exception{

		String access_Token= loginService.getKakaoAccessToken(code);
		
		loginService.createKakaoUser(access_Token);
	}
}