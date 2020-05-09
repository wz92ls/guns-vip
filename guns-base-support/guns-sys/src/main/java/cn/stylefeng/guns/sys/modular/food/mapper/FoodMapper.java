package cn.stylefeng.guns.sys.modular.food.mapper;

import cn.stylefeng.guns.sys.modular.food.entity.Food;
import cn.stylefeng.guns.sys.modular.food.model.params.FoodParam;
import cn.stylefeng.guns.sys.modular.food.model.result.FoodResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 食品表 Mapper 接口
 * </p>
 *
 * @author  wangzheng
 * @since 2020-03-27
 */
public interface FoodMapper extends BaseMapper<Food> {

    /**
     * 获取列表
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    List<FoodResult> customList(@Param("paramCondition") FoodParam paramCondition);

    /**
     * 获取map列表
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") FoodParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    Page<FoodResult> customPageList(@Param("page") Page page, @Param("paramCondition") FoodParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author  wangzheng
     * @Date 2020-03-27
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") FoodParam paramCondition);

}
