package cn.stylefeng.guns.modular.config.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.config.entity.Config;
import cn.stylefeng.guns.modular.config.model.params.ConfigParam;
import cn.stylefeng.guns.modular.config.service.ConfigService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 参数配置控制器
 *
 * @author 
 * @Date 2020-03-28 10:23:27
 */
@Controller
@RequestMapping("/config")
public class ConfigController extends BaseController {

    private String PREFIX = "/config/config";

    @Autowired
    private ConfigService configService;

    /**
     * 跳转到主页面
     *
     * @author 
     * @Date 2020-03-28
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/config.html";
    }

    /**
     * 新增页面
     *
     * @author 
     * @Date 2020-03-28
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/config_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 
     * @Date 2020-03-28
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/config_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 
     * @Date 2020-03-28
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ConfigParam configParam) {
        this.configService.add(configParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 
     * @Date 2020-03-28
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(ConfigParam configParam) {
        this.configService.update(configParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 
     * @Date 2020-03-28
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(ConfigParam configParam) {
        this.configService.delete(configParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 
     * @Date 2020-03-28
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(ConfigParam configParam) {
        Config detail = this.configService.getById(configParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 
     * @Date 2020-03-28
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(ConfigParam configParam) {
        return this.configService.findPageBySpec(configParam);
    }

}


