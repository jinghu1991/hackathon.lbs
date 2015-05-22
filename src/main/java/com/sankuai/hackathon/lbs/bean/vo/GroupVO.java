package com.sankuai.hackathon.lbs.bean.vo;

import com.sankuai.hackathon.lbs.bean.po.GroupPO;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: GroupVO
 * Author: qiqi
 * Create: 2015-05-21
 */
public class GroupVO extends GroupPO{

    private List<MemberVO> members;

    private Integer postCount; // 留言数

    private List<Double> location = new ArrayList<Double>(2);

    public List<Double> getLocation() {

        return location;
    }

    public void setLocation(List<Double> location) {

        this.location = location;
    }

    public List<MemberVO> getMembers() {

        return members;
    }

    public void setMembers(List<MemberVO> members) {

        this.members = members;
    }

    public Integer getPostCount() {

        return postCount;
    }

    public void setPostCount(Integer postCount) {

        this.postCount = postCount;
    }
}
