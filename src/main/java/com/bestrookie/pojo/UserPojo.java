package com.bestrookie.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2021/7/9 17:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 这里要特别的注意，如果你的数据表名和实体类不一致，比如我的数据库表为（user）
 * 而我的实体类为（UserPojo）如果不用下面的注解标记 那么mybatis-plus就会在数据库中
 * 寻找user_pojo这个表 从而导致错误
 */
@TableName(value = "user")
public class UserPojo {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String email;
    @TableField(fill = FieldFill.INSERT) //只在插入的时候 填充
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)//在插入和更新的时候填充
    private Date updateTime;
    @Version
    private Integer version;
    @TableLogic
    private int deleted;
}
