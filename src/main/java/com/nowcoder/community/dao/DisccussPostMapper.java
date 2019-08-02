package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DisccussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);//动态sql.起始行号，最多显示的数据

    //动态拼一个条件，且有且只有一个参数，则必须加param用于给参数取别名
    int selectDiscussPostRows(@Param("userId")int userId);




}
