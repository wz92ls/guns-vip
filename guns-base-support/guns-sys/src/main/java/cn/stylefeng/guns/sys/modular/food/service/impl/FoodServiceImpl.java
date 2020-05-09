package cn.stylefeng.guns.sys.modular.food.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.sys.modular.food.entity.Food;
import cn.stylefeng.guns.sys.modular.food.mapper.FoodMapper;
import cn.stylefeng.guns.sys.modular.food.model.params.FoodParam;
import cn.stylefeng.guns.sys.modular.food.model.result.FoodResult;
import  cn.stylefeng.guns.sys.modular.food.service.FoodService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 食品表 服务实现类
 * </p>
 *
 * @author  wangzheng
 * @since 2020-03-27
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {

    @Override
    public void add(FoodParam param){
        Food entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(FoodParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(FoodParam param){
        Food oldEntity = getOldEntity(param);
        Food newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public FoodResult findBySpec(FoodParam param){
        return null;
    }

    @Override
    public List<FoodResult> findListBySpec(FoodParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(FoodParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(FoodParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Food getOldEntity(FoodParam param) {
        return this.getById(getKey(param));
    }

    private Food getEntity(FoodParam param) {
        Food entity = new Food();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
