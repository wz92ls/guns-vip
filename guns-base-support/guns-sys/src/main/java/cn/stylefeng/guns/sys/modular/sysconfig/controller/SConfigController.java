package cn.stylefeng.guns.sys.modular.sysconfig.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.sys.modular.sysconfig.entity.SConfig;
import cn.stylefeng.guns.sys.modular.sysconfig.model.params.SConfigParam;
import cn.stylefeng.guns.sys.modular.sysconfig.service.SConfigService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 参数配置控制器
 *
 * @author stylefeng
 * @Date 2020-03-27 10:06:01
 */
@Controller
@RequestMapping("/sConfig")
public class SConfigController extends BaseController {

    private String PREFIX = "/modular/modularA/sConfig";

    @Autowired
    private SConfigService sConfigService;

    /**
     * 跳转到主页面
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/sConfig.html";
    }

    /**
     * 新增页面
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/sConfig_add.html";
    }

    /**
     * 编辑页面
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/sConfig_edit.html";
    }

    /**
     * 新增接口
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(SConfigParam sConfigParam) {
        this.sConfigService.add(sConfigParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(SConfigParam sConfigParam) {
        this.sConfigService.update(sConfigParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(SConfigParam sConfigParam) {
        this.sConfigService.delete(sConfigParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(SConfigParam sConfigParam) {
        SConfig detail = this.sConfigService.getById(sConfigParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(SConfigParam sConfigParam) {
        return this.sConfigService.findPageBySpec(sConfigParam);
    }

}


