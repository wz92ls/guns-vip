package cn.stylefeng.guns.sys.modular.third.controller;

import cn.hutool.json.JSONUtil;
import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.sys.modular.third.factory.OAuthRequestFactory;
import cn.stylefeng.guns.sys.modular.third.service.LoginService;
import cn.stylefeng.guns.sys.modular.third.service.OauthUserInfoService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.roses.kernel.model.response.SuccessResponseData;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * OAuth统一回调地址
 *
 * @author fengshuonan
 * @Date 2019/6/9 16:38
 */
@Controller
@RequestMapping("/oauth")
@Slf4j
public class OAuthController extends BaseController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private OauthUserInfoService oauthUserInfoService;

    /**
     * 第三方登录跳转
     *
     * @author fengshuonan
     * @Date 2019/6/9 16:44
     */
    @RequestMapping("/render/{source}")
    public void renderAuth(@PathVariable("source") String source, HttpServletResponse response) throws IOException {
//        log.info("第三方登录回调成功：" +source);
        AuthRequest authRequest = OAuthRequestFactory.getAuthRequest(source);
        String authorizeUrl=authRequest.authorize(AuthStateUtils.createState());
        log.info("lujing：" +authorizeUrl);
        response.sendRedirect(authorizeUrl);
    }

    /**
     * 第三方登录成功后的回调地址
     *
     * @author fengshuonan
     * @Date 2019/6/9 16:45
     */
    @RequestMapping("/callback/{source}")
    public String callback(@PathVariable("source") String source, AuthCallback callback) {

        //通过回调的code，请求对应的oauth server获取用户基本信息和token
        AuthRequest authRequest = OAuthRequestFactory.getAuthRequest(source);
        AuthResponse authResponse = authRequest.login(callback);

        log.info("【response】= {}", JSONUtil.toJsonStr(authResponse));

        log.info("第三方登录回调成功：" + authResponse.toString());

        AuthUser oauthUser = (AuthUser) authResponse.getData();
        log.info("第三方登录回调成功：" + oauthUser);

        //进行第三方用户登录过程
        String token = loginService.oauthLogin(oauthUser);
        log.info("token：" +token);
        //跳转到token登录接口

//        return REDIRECT + "/oauth/sysTokenLogin?token=" + token;
        return REDIRECT + "/";
    }

    /**
     * 第三方登录的头像
     *
     * @author fengshuonan
     * @Date 2019/6/9 16:44
     */
    @RequestMapping("/avatar")
    public String avatar() {

        Long userId = LoginContextHolder.getContext().getUser().getId();

        //获取第三方登录用户的头像
        String avatarUrl = oauthUserInfoService.getAvatarUrl(userId);

        return REDIRECT + avatarUrl;
    }

}
