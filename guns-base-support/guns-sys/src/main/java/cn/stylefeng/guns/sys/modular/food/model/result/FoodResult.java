package cn.stylefeng.guns.sys.modular.food.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 食品表
 * </p>
 *
 * @author  wangzheng
 * @since 2020-03-27
 */
@Data
public class FoodResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long id;

    /**
     * 商品编号，UUID生成，唯一
     */
    private String number;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 生产日期
     */
    private Date productdate;

    /**
     * 保质期  单位：天
     */
    private Long expirationdate;

    /**
     * 库存
     */
    private Long stock;

    /**
     * 单位
     */
    private String unit;

    /**
     * 状态：1.上架  2.下架
     */
    private Integer status;

    /**
     * 添加时间
     */
    private Date addtime;

    /**
     * 最后更新时间
     */
    private Date updatetime;

    /**
     * 添加人
     */
    private String addperson;

    /**
     * 描述
     */
    private String description;

    /**
     * 备注
     */
    private String remark;

}
