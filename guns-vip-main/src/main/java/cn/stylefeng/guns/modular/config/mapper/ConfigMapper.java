package cn.stylefeng.guns.modular.config.mapper;

import cn.stylefeng.guns.modular.config.entity.Config;
import cn.stylefeng.guns.modular.config.model.params.ConfigParam;
import cn.stylefeng.guns.modular.config.model.result.ConfigResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 参数配置 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-03-28
 */
public interface ConfigMapper extends BaseMapper<Config> {

    /**
     * 获取列表
     *
     * @author 
     * @Date 2020-03-28
     */
    List<ConfigResult> customList(@Param("paramCondition") ConfigParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 
     * @Date 2020-03-28
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") ConfigParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 
     * @Date 2020-03-28
     */
    Page<ConfigResult> customPageList(@Param("page") Page page, @Param("paramCondition") ConfigParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 
     * @Date 2020-03-28
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") ConfigParam paramCondition);

}
