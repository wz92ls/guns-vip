package cn.stylefeng.guns.sys.modular.sysconfig.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.sys.modular.sysconfig.entity.SConfig;
import cn.stylefeng.guns.sys.modular.sysconfig.model.params.SConfigParam;
import cn.stylefeng.guns.sys.modular.sysconfig.model.result.SConfigResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 参数配置 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2020-03-27
 */
public interface SConfigService extends IService<SConfig> {

    /**
     * 新增
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    void add(SConfigParam param);

    /**
     * 删除
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    void delete(SConfigParam param);

    /**
     * 更新
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    void update(SConfigParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    SConfigResult findBySpec(SConfigParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
    List<SConfigResult> findListBySpec(SConfigParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author stylefeng
     * @Date 2020-03-27
     */
     LayuiPageInfo findPageBySpec(SConfigParam param);

}
