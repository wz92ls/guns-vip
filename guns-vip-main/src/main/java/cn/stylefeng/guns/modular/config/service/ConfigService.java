package cn.stylefeng.guns.modular.config.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.config.entity.Config;
import cn.stylefeng.guns.modular.config.model.params.ConfigParam;
import cn.stylefeng.guns.modular.config.model.result.ConfigResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 参数配置 服务类
 * </p>
 *
 * @author 
 * @since 2020-03-28
 */
public interface ConfigService extends IService<Config> {

    /**
     * 新增
     *
     * @author 
     * @Date 2020-03-28
     */
    void add(ConfigParam param);

    /**
     * 删除
     *
     * @author 
     * @Date 2020-03-28
     */
    void delete(ConfigParam param);

    /**
     * 更新
     *
     * @author 
     * @Date 2020-03-28
     */
    void update(ConfigParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 
     * @Date 2020-03-28
     */
    ConfigResult findBySpec(ConfigParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 
     * @Date 2020-03-28
     */
    List<ConfigResult> findListBySpec(ConfigParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 
     * @Date 2020-03-28
     */
     LayuiPageInfo findPageBySpec(ConfigParam param);

}
