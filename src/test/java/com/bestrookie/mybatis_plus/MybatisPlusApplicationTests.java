package com.bestrookie.mybatis_plus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bestrookie.mapper.UserMapper;
import com.bestrookie.pojo.UserPojo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<UserPojo> userList = userMapper.selectList(null);
        for (UserPojo userPojo : userList) {
            System.out.println(userPojo.toString());
        }
    }
    @Test
    public void testInsert(){
        UserPojo user = new UserPojo();
        user.setAge(18);
        user.setEmail("123@123.com");
        user.setName("rookie");
        System.out.println("============================");
        System.out.println(user);
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }
    @Test
    public void testUpdate(){
        UserPojo user = userMapper.selectById(1);
        user.setName("best");
        System.out.println(userMapper.updateById(user));

    }
    @Test
    public void testLock(){
        UserPojo user1 = userMapper.selectById(1);
        user1.setName("1111");
        UserPojo user2 = userMapper.selectById(1);
        user2.setName("2222");
        userMapper.updateById(user2);
        userMapper.updateById(user1);
    }
    @Test
    public void testSelect(){
        //根据id查询
        UserPojo user = userMapper.selectById(2);
        //根据id集合查询多个
        List<UserPojo> userPojos = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","jack");
        //map 相当于定义的一个条件
        userMapper.selectByMap(map);
    }
    @Test
    public void testPage(){
        Page<UserPojo> page = new Page<>(1,5);
        IPage<UserPojo> userPojoIPage = userMapper.selectPage(page, null);
    }
    @Test
    public void testDelete(){
        userMapper.deleteById(1L);
    }

}
