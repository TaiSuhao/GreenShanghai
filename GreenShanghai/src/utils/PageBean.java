package utils;

import model.Paste;

import java.util.List;

public class PageBean {

    //ÿҳ������
    private Integer pageSize;
    //��ǰҳ
    private Integer currentPage;
    //��������
    private Integer totalCount;
    //��ҳ��
    private Integer totalPage;

    //ÿҳ��ʾ������list
    private List list;

    public PageBean(Integer currentPage,Integer totalCount,Integer pageSize){
        this.currentPage=currentPage;
        this.totalCount=totalCount;
        this.pageSize=pageSize;

        //��ȫУ��
        if(this.currentPage==null){
            this.currentPage=1;
        }

        if (this.pageSize==null){
            this.pageSize=8; //ÿҳ��ʾ8��
        }

        //����totalpage
        this.totalPage=(int)Math.ceil(1.0*this.totalCount/this.pageSize);

        //��ȫУ�� ��һ�û�������� ����
        if(this.currentPage>this.totalPage){
            this.currentPage=this.totalPage;
        }
        if (this.currentPage<1){
            this.currentPage=1;
        }

    }

    //�����ʼ�������� 2*(currentPage-1)
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
