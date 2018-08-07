package com.ljj.ssm.po;

import com.ljj.ssm.controller.validation.ValidGroup;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public class Items {
    private Integer id;

    //校验名称在1-30个字符这件,groups:校验属于那个分组
    @Size(min = 1,max = 30,message = "{items.name.length.error}",groups = {ValidGroup.class})
    private String name;

    private BigDecimal price;

    @NotNull(message = "{items.pic.isNull}",groups = {ValidGroup.class})
    private String pic;

    @NotNull(message = "{items.createtime.isNull}")
    private Date createtime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}