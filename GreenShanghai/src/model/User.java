package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String telephone;
    private String code;
    private String image;
    private Integer coin;
    private String email;
    private Integer status;

    //一个用户可以发多个帖子
    private Set<Paste> pasteSet=new HashSet<Paste>();
    private Set<Paste> answerPasteSet=new HashSet<Paste>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<Paste> getPasteSet() {
        return pasteSet;
    }

    public void setPasteSet(Set<Paste> pasteSet) {
        this.pasteSet = pasteSet;
    }

    public Set<Paste> getAnswerPasteSet() {
        return answerPasteSet;
    }

    public void setAnswerPasteSet(Set<Paste> answerPasteSet) {
        this.answerPasteSet = answerPasteSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(telephone, user.telephone) &&
                Objects.equals(code, user.code) &&
                Objects.equals(image, user.image) &&
                Objects.equals(coin, user.coin) &&
                Objects.equals(email, user.email) &&
                Objects.equals(status, user.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, telephone, code, image, coin, email, status);
    }
}
