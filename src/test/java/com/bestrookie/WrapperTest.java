package com.bestrookie;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bestrookie.mapper.UserMapper;
import com.bestrookie.pojo.UserPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2021/7/14 14:31
 */
@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        //查询name不为空，并且邮箱不为空，并且年龄大于等于12
        QueryWrapper<UserPojo> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name").isNotNull("email").ge("age",12);
        userMapper.selectList(wrapper);
    }
    @Test
    void test2(){
        QueryWrapper<UserPojo> wrapper = new QueryWrapper<>();
        //查找一个
        wrapper.eq("name","张全蛋");
        userMapper.selectOne(wrapper);
    }
    @Test
    void test3(){
        QueryWrapper<UserPojo> wrapper = new QueryWrapper<>();
        //查询年龄在20~30岁之间的用户
        wrapper.between("age",20,30);
        System.out.println(userMapper.selectCount(wrapper));
    }
    @Test
    void  test4(){
        //模糊查询
        QueryWrapper<UserPojo> wrapper = new QueryWrapper<>();
        wrapper.notLike("name","e");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        System.out.println(maps.toString());
    }
    @Test
    void test5(){
        //拼接sql
        QueryWrapper<UserPojo> wrapper = new QueryWrapper<>();
        wrapper.inSql("id","select id from user where id<3");
        userMapper.selectObjs(wrapper);
    }
    @Test
    void test6(){
        //通过id进行排序
        QueryWrapper<UserPojo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        userMapper.selectList(wrapper);
    }
}
