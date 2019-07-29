package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Paste {
    private int id;
    private String title;
    private String content;
    private Integer offer;
    private Integer ansnum;
    private String createtime;
    private Integer glanceover;
    private Integer solve;
    private Integer isdelete;
    private Integer ansid;

    //一个帖子对应一个用户
    private User user;

    private Set<User>  userAnswerSet=new HashSet<User>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        //去掉内容中的br
        this.content = content.replaceAll("<br />"," ");
    }

    public Integer getOffer() {
        return offer;
    }

    public void setOffer(Integer offer) {
        this.offer = offer;
    }

    public Integer getAnsnum() {
        return ansnum;
    }

    public void setAnsnum(Integer ansnum) {
        this.ansnum = ansnum;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getGlanceover() {
        return glanceover;
    }

    public void setGlanceover(Integer glanceover) {
        this.glanceover = glanceover;
    }

    public Integer getSolve() {
        return solve;
    }

    public void setSolve(Integer solve) {
        this.solve = solve;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getAnsid() {
        return ansid;
    }

    public void setAnsid(Integer ansid) {
        this.ansid = ansid;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<User> getUserAnswerSet() {
        return userAnswerSet;
    }

    public void setUserAnswerSet(Set<User> userAnswerSet) {
        this.userAnswerSet = userAnswerSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paste paste = (Paste) o;
        return id == paste.id &&
                Objects.equals(title, paste.title) &&
                Objects.equals(content, paste.content) &&
                Objects.equals(offer, paste.offer) &&
                Objects.equals(ansnum, paste.ansnum) &&
                Objects.equals(createtime, paste.createtime) &&
                Objects.equals(glanceover, paste.glanceover) &&
                Objects.equals(solve, paste.solve) &&
                Objects.equals(isdelete, paste.isdelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, offer, ansnum, createtime, glanceover, solve, isdelete);
    }
}
