package com.poplar.product.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 品牌
 *
 * @author poplar
 * @email poplar@gmail.com
 * @date 2020-04-03 14:38:11
 */
@Data
@TableName("pms_brand")
public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @TableId
    private Long brandId;
    /**
     * 品牌名
     */
    @NotBlank(message = "品牌名称不能为空")
    private String name;
    /**
     * 品牌logo地址
     */
    @URL(message = "logo地址不正确")
    private String logo;
    /**
     * 介绍
     */
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @Pattern(regexp = "^[a-zA-Z]$", message = "请输入任意字母")
    private String firstLetter;
    /**
     * 排序
     */
    @Min(value = 0, message = "排序数字必须大于0")
    private Integer sort;

}
