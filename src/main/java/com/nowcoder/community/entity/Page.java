package com.nowcoder.community.entity;
/**
封装分页相关的信息
 */
public class Page {

    //当前页码
    private int current = 1;
    //显示上限
    private int limit = 10;
    //数据总数,用于计算总的页数
    private int row;
    //查询路径(复用分页的链接）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1)
            this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit >= 1 && limit <= 100)
            this.limit = limit;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if(row >= 0)
          this.row = row;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
    获取当前页的起始行
     */
    public int getOffset(){
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     */
    public int getTotal(){
        if(row % limit == 0)
            return row / limit;
        else
            return row / limit + 1;
    }

    /**
     * 获取起始页码
     */
    public int getFrom(){
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 获取结束页码
     */
    public int getTo(){
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }
}
