package com.aaa.wkn.base;
import com.aaa.wkn.utils.Map2BeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.aaa.wkn.staticproperties.OrderStatic.*;
/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/10 9:00
 */
public class BaseService<T> {
    // 全局变量，缓存子类的泛型类型
    private Class<T> cache = null;

    @Autowired
    private Mapper<T> mapper;

    protected Mapper getMapper() {
        return mapper;
    }

    public Integer add(T t) {
        return mapper.insert(t);
    }

    public Integer delete(T t) {
        return mapper.deleteByPrimaryKey(t);
    }

    public Integer deleteByIds(List<Integer> ids) {
        /**
         * delete * from user where 1 = 1 and id in (1,2,3,4,5,6,7,8)
         * andIn("id")--->id就是数据库中的主键名称
         */
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", ids)).build();
        return mapper.deleteByExample(example);
    }


    public Integer update(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }


    public Integer batchUpdate(T t, Integer[] ids) {
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t, example);
    }


    public T selectOne(T t) {
        return mapper.selectOne(t);
    }

    public T selectOneByFiled(Sqls where, String orderByFiled, String... fileds) {
        return (T) selectByFileds(null, null, where, orderByFiled, null, fileds).get(0);
    }


    public List<T> selectListByFiled(Sqls where, String orderByField, String... fields) {
        return selectByFileds(null, null, where, orderByField, null, fields);
    }

    public PageInfo<T> selectListByPageAndFiled(Integer pageNo, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return new PageInfo<T>(selectByFileds(pageNo, pageSize, where, orderFiled, null, fileds));
    }

    public List<T> selectList(T t) {
        return mapper.select(t);
    }


    public PageInfo<T> selectListByPage(T t, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(select);
        return pageInfo;
    }


    public T newInstance(Map map) {
        return (T) Map2BeanUtils.map2Bean(map, getTypeArguement());
    }

    private List<T> selectByFileds(Integer pageNo, Integer pageSize, Sqls where, String orderByFiled, String orderWord, String... fileds) {
        Example.Builder builder = null;
        if(null == fileds || fileds.length == 0) {
            // 查询所有数据
            builder = Example.builder(getTypeArguement());
        } else {
            // 说明需要进行条件查询
            builder = Example.builder(getTypeArguement()).select(fileds);
        }
        if(where != null) {
            // 说明有用户自定义的where语句条件
            builder = builder.where(where);
        }
        if(orderByFiled != null) {
            // 说明我需要对某个字段进行排序
            if(DESC.equals(orderWord.toUpperCase())) {
                // 说明需要倒序
                builder = builder.orderByDesc(orderByFiled);
            } else if(ASC.equals(orderWord.toUpperCase())) {
                builder = builder.orderByAsc(orderByFiled);
            } else {
                builder = builder.orderByDesc(orderByFiled);
            }
        }
        Example example = builder.build();
        // 实现分页
        if(pageNo != null & pageSize != null) {
            PageHelper.startPage(pageNo, pageSize);
        }
        return getMapper().selectByExample(example);
    }


    public Class<T> getTypeArguement() {
        if(null == cache) {
            cache = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return cache;
    }

    public ApplicationContext getApplicationContext() {
        return SpringContextUtils.getApplicationContext();
    }
}
