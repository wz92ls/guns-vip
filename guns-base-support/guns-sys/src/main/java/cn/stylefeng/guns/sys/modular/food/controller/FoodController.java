package cn.stylefeng.guns.sys.modular.food.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.sys.modular.food.entity.Food;
import cn.stylefeng.guns.sys.modular.food.model.params.FoodParam;
import cn.stylefeng.guns.sys.modular.food.service.FoodService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


/**
 * 食品表控制器
 *
 * @author  wangzheng
 * @Date 2020-03-27 12:35:38
 */
@Controller
@RequestMapping("/food")
public class FoodController extends BaseController {

    private String PREFIX = "/food/food";

    @Autowired
    private FoodService foodService;

    /**
     * 跳转到主页面
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    @RequestMapping("")
    public String index() {

        return PREFIX + "/food.html";
    }

    /**
     * 新增页面
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/food_add.html";
    }

    /**
     * 编辑页面
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/food_edit.html";
    }

    /**
     * 新增接口
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(FoodParam foodParam) {
        this.foodService.add(foodParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(FoodParam foodParam) {
        this.foodService.update(foodParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(FoodParam foodParam) {
        this.foodService.delete(foodParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(FoodParam foodParam) {
        Food detail = this.foodService.getById(foodParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(FoodParam foodParam) {
        return this.foodService.findPageBySpec(foodParam);
    }

}


