package cn.stylefeng.guns.modular.config.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.config.entity.Config;
import cn.stylefeng.guns.modular.config.mapper.ConfigMapper;
import cn.stylefeng.guns.modular.config.model.params.ConfigParam;
import cn.stylefeng.guns.modular.config.model.result.ConfigResult;
import  cn.stylefeng.guns.modular.config.service.ConfigService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 参数配置 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-03-28
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

    @Override
    public void add(ConfigParam param){
        Config entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ConfigParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ConfigParam param){
        Config oldEntity = getOldEntity(param);
        Config newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ConfigResult findBySpec(ConfigParam param){
        return null;
    }

    @Override
    public List<ConfigResult> findListBySpec(ConfigParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ConfigParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ConfigParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Config getOldEntity(ConfigParam param) {
        return this.getById(getKey(param));
    }

    private Config getEntity(ConfigParam param) {
        Config entity = new Config();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
