package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.User;
import service.UserService;

import java.util.Random;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    private UserService userService;

    private User user=new User();

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getModel() {
        return user;
    }

    //用户注册
    public String register() throws Exception {

        //处理用户头像 注册的时候就给用户一个随机的头像
        Random r=new Random();
        user.setImage("/images/"+r.nextInt(21)+".gif");
        user.setCoin(0);

        boolean success=userService.addUser(user);

        if(success){
            return "tologin";
        }else{
            return "toregister";
        }
    }

    //用户登陆
    public String login() throws Exception {

        boolean success=userService.findUser(user);

        if(success){
            //由于表中存在对应user表的外键，这里要在session域中放入user对象
            ActionContext.getContext().getSession().put("user",userService.findUserByUsernameReturnUser(user));
            return "toindex";
        }else {
            ActionContext.getContext().put("error","用户名密码错误！");
            return "tologin";
        }
    }

    //用户登出
    public String logout() throws Exception {

        ActionContext.getContext().getSession().remove("user");

        return "tologin";
    }


}
