package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import model.Answer;
import model.Paste;
import model.User;
import service.AnswerService;
import service.PasteService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AnswerAction extends ActionSupport implements ModelDriven<Answer> {

    public Answer answer=new Answer();
    private AnswerService answerService;
    private PasteService pasteService;
    private String pasteid;
    private String answerid;

    public String addAnswer() throws Exception{

        User user=(User) ActionContext.getContext().getSession().get("user");
        if (user==null){
            ActionContext.getContext().put("error","请先登陆再回复");
            return "error";
        }
        Date date=new Date(System.currentTimeMillis());
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String anstime=format.format(date);
        answer.setAnstime(anstime);
        answer.setAgree(0);
        answer.setSolve(0);
        answer.setUser(user);
        System.out.println(user.getUsername());
        System.out.println(answer.getContent());
        System.out.println(pasteid);
        Paste paste=pasteService.findPasteByIdReturnPaste(pasteid);
        answer.setPaste(paste);

        //回答以后,增加ansnum
        answerService.addAnswer(answer,paste);

        return "toDetail";
    }

    //删除Answer
    public String deleteAnswer() throws Exception {

        Paste paste=pasteService.findPasteByIdReturnPaste(pasteid);

        answerService.deleteAnswerById(answerid,paste);
        ActionContext.getContext().put("pasteid",pasteid);

        return "toDetail";
    }

    public Answer getModel() {
        return answer;
    }

    public AnswerService getAnswerService() {
        return answerService;
    }

    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    public String getPasteid() {
        return pasteid;
    }

    public void setPasteid(String pasteid) {
        this.pasteid = pasteid;
    }

    public PasteService getPasteService() {
        return pasteService;
    }

    public void setPasteService(PasteService pasteService) {
        this.pasteService = pasteService;
    }

    public String getAnswerid() {
        return answerid;
    }

    public void setAnswerid(String answerid) {
        this.answerid = answerid;
    }
}
