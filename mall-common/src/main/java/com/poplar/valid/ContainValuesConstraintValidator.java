package com.poplar.valid;

import com.google.common.collect.Sets;
import com.poplar.anno.ContainValues;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collections;
import java.util.Set;

/**
 * Create BY poplar ON 2020/4/11
 * 自定义校验器
 */
public class ContainValuesConstraintValidator implements ConstraintValidator<ContainValues, Integer> {

    private Set<Integer> set = Collections.synchronizedSet(Sets.newHashSet());

    //初始化方法
    @Override
    public void initialize(ContainValues constraintAnnotation) {

        int[] valus = constraintAnnotation.valus();
        if (valus.length > 0) {
            for (int i = 0; i < valus.length; i++) {
                set.add(valus[i]);
            }
        }
    }

    //判断校验是否成功
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
