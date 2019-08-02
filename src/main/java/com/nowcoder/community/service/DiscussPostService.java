package com.nowcoder.community.service;

import com.nowcoder.community.dao.DisccussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DisccussPostMapper disccussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userid , int offset, int limit){
        return disccussPostMapper.selectDiscussPosts(userid,offset,limit);
    }

    public int findDiscussPostRows(int userId){
        return disccussPostMapper.selectDiscussPostRows(userId);
    }
}
