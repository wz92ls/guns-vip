package cn.stylefeng.guns.sys.modular.food.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 食品表
 * </p>
 *
 * @author  wangzheng
 * @since 2020-03-27
 */
@TableName("food")
public class Food implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 商品编号，UUID生成，唯一
     */
    @TableField("NUMBER")
    private String number;

    /**
     * 商品名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 价格
     */
    @TableField("PRICE")
    private BigDecimal price;

    /**
     * 生产日期
     */
    @TableField("PRODUCTDATE")
    private Date productdate;

    /**
     * 保质期  单位：天
     */
    @TableField("EXPIRATIONDATE")
    private Long expirationdate;

    /**
     * 库存
     */
    @TableField("STOCK")
    private Long stock;

    /**
     * 单位
     */
    @TableField("UNIT")
    private String unit;

    /**
     * 状态：1.上架  2.下架
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 添加时间
     */
    @TableField("ADDTIME")
    private Date addtime;

    /**
     * 最后更新时间
     */
    @TableField("UPDATETIME")
    private Date updatetime;

    /**
     * 添加人
     */
    @TableField("ADDPERSON")
    private String addperson;

    /**
     * 描述
     */
    @TableField("DESCRIPTION")
    private String description;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getProductdate() {
        return productdate;
    }

    public void setProductdate(Date productdate) {
        this.productdate = productdate;
    }

    public Long getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(Long expirationdate) {
        this.expirationdate = expirationdate;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getAddperson() {
        return addperson;
    }

    public void setAddperson(String addperson) {
        this.addperson = addperson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Food{" +
        "id=" + id +
        ", number=" + number +
        ", name=" + name +
        ", price=" + price +
        ", productdate=" + productdate +
        ", expirationdate=" + expirationdate +
        ", stock=" + stock +
        ", unit=" + unit +
        ", status=" + status +
        ", addtime=" + addtime +
        ", updatetime=" + updatetime +
        ", addperson=" + addperson +
        ", description=" + description +
        ", remark=" + remark +
        "}";
    }
}
