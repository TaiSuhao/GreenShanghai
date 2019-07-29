package model;

import java.util.Objects;

public class Answer {
    private int id;
    private String content;
    private String anstime;
    private Integer agree;
    private Integer solve;

    private User user;
    private Paste paste;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {

        this.content = content.replaceAll("<br />"," ");
    }

    public String getAnstime() {
        return anstime;
    }

    public void setAnstime(String anstime) {
        this.anstime = anstime;
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }

    public Integer getSolve() {
        return solve;
    }

    public void setSolve(Integer solve) {
        this.solve = solve;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Paste getPaste() {
        return paste;
    }

    public void setPaste(Paste paste) {
        this.paste = paste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id == answer.id &&
                Objects.equals(content, answer.content) &&
                Objects.equals(anstime, answer.anstime) &&
                Objects.equals(agree, answer.agree) &&
                Objects.equals(solve, answer.solve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,content, anstime, agree, solve);
    }
}
