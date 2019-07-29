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

    //�û�ע��
    public String register() throws Exception {

        //�����û�ͷ�� ע���ʱ��͸��û�һ�������ͷ��
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

    //�û���½
    public String login() throws Exception {

        boolean success=userService.findUser(user);

        if(success){
            //���ڱ��д��ڶ�Ӧuser������������Ҫ��session���з���user����
            ActionContext.getContext().getSession().put("user",userService.findUserByUsernameReturnUser(user));
            return "toindex";
        }else {
            ActionContext.getContext().put("error","�û����������");
            return "tologin";
        }
    }

    //�û��ǳ�
    public String logout() throws Exception {

        ActionContext.getContext().getSession().remove("user");

        return "tologin";
    }


}
