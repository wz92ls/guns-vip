package cn.stylefeng.guns.sys.modular.food.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.sys.modular.food.entity.Food;
import cn.stylefeng.guns.sys.modular.food.model.params.FoodParam;
import cn.stylefeng.guns.sys.modular.food.model.result.FoodResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 食品表 服务类
 * </p>
 *
 * @author  wangzheng
 * @since 2020-03-27
 */
public interface FoodService extends IService<Food> {

    /**
     * 新增
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    void add(FoodParam param);

    /**
     * 删除
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    void delete(FoodParam param);

    /**
     * 更新
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    void update(FoodParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    FoodResult findBySpec(FoodParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    List<FoodResult> findListBySpec(FoodParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
     LayuiPageInfo findPageBySpec(FoodParam param);

}
