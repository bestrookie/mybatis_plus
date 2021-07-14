package com.bestrookie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bestrookie.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2021/7/12 13:40
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPojo> {
}
