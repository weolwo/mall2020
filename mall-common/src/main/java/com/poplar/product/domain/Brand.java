package com.poplar.product.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.poplar.anno.ContainValues;
import com.poplar.valid.AddGroup;
import com.poplar.valid.UpdateGroup;
import com.poplar.valid.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
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
     *
     * @NotNull 可用于任意类型
     */
    @TableId
    @Null(message = "新增品牌id必须为空", groups = AddGroup.class)
    @NotNull(message = "更新品牌id不能为空", groups = UpdateGroup.class)
    private Long brandId;
    /**
     * 品牌名
     */
    @NotBlank(message = "品牌名称不能为空", groups = {UpdateGroup.class, AddGroup.class})
    private String name;
    /**
     * 品牌logo地址
     */
    @URL(message = "logo地址不正确", groups = {UpdateGroup.class, AddGroup.class})
    private String logo;
    /**
     * 介绍
     */
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     * //自定义校验器
     */
    @NotNull(message = "状态不能为空", groups = {AddGroup.class, UpdateStatusGroup.class})
    @ContainValues(valus = {0, 1}, groups = {UpdateGroup.class, AddGroup.class, UpdateStatusGroup.class})
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @Pattern(regexp = "^[a-zA-Z]$", message = "请输入任意字母", groups = {UpdateGroup.class, AddGroup.class})
    private String firstLetter;
    /**
     * 排序
     */
    @Min(value = 0, message = "排序数字必须大于0", groups = {UpdateGroup.class, AddGroup.class})
    private Integer sort;

}
