package utils;

import model.Paste;

import java.util.List;

public class PageBean {

    //每页帖子数
    private Integer pageSize;
    //当前页
    private Integer currentPage;
    //总帖子数
    private Integer totalCount;
    //总页数
    private Integer totalPage;

    //每页显示的帖子list
    private List list;

    public PageBean(Integer currentPage,Integer totalCount,Integer pageSize){
        this.currentPage=currentPage;
        this.totalCount=totalCount;
        this.pageSize=pageSize;

        //安全校验
        if(this.currentPage==null){
            this.currentPage=1;
        }

        if (this.pageSize==null){
            this.pageSize=8; //每页显示8个
        }

        //计算totalpage
        this.totalPage=(int)Math.ceil(1.0*this.totalCount/this.pageSize);

        //安全校验 万一用户输入过大 负数
        if(this.currentPage>this.totalPage){
            this.currentPage=this.totalPage;
        }
        if (this.currentPage<1){
            this.currentPage=1;
        }

    }

    //获得起始索引函数 2*(currentPage-1)
    public Integer getStart(){
        return 2*(this.currentPage-1);
    }




    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
