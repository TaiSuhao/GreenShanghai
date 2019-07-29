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
import java.util.List;

public class PasteAction extends ActionSupport implements ModelDriven<Paste> {

    public Paste paste=new Paste();
    private PasteService pasteService;
    private AnswerService answerService;
    private String pasteid;

    public String addPaste() throws Exception {

        //防止没有登陆就进行添加帖子
        User user=(User) ActionContext.getContext().getSession().get("user");
        if(user==null){
            ActionContext.getContext().put("error","请先登陆再发帖");
            return "error";
        }

        //封装一些没有传递的参数
        paste.setAnsnum(0);
        Date date=new Date(System.currentTimeMillis());
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createtime=format.format(date);
        paste.setCreatetime(createtime);
        paste.setGlanceover(0);
        paste.setSolve(0);
        paste.setIsdelete(0);
        paste.setUser(user);

        pasteService.addPaste(paste);

        return "toindex";
    }

    //查看帖子详细信息
    public String getDetail() throws Exception{
        //获得帖子
        Paste paste=pasteService.findPasteByIdReturnPaste(pasteid);
        ActionContext.getContext().put("paste",paste);

        //获得帖子所有回复
        List<Answer> answerList=answerService.findAllAnswerByPasteId(pasteid);
        ActionContext.getContext().put("answerList",answerList);

        return "detail";
    }

    //解决帖子
    public String solvePaste() throws Exception {

        pasteService.solvePasteByIdAndAnswerId(pasteid,paste.getAnsid());
        ActionContext.getContext().put("pasteid",pasteid);
        return "toDetail";
    }

    public Paste getModel() {
        return paste;
    }

    public PasteService getPasteService() {
        return pasteService;
    }

    public void setPasteService(PasteService pasteService) {
        this.pasteService = pasteService;
    }

    public String getPasteid() {
        return pasteid;
    }

    public void setPasteid(String pasteid) {
        this.pasteid = pasteid;
    }

    public AnswerService getAnswerService() {
        return answerService;
    }

    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

}
