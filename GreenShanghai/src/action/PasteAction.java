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

        //��ֹû�е�½�ͽ����������
        User user=(User) ActionContext.getContext().getSession().get("user");
        if(user==null){
            ActionContext.getContext().put("error","���ȵ�½�ٷ���");
            return "error";
        }

        //��װһЩû�д��ݵĲ���
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

    //�鿴������ϸ��Ϣ
    public String getDetail() throws Exception{
        //�������
        Paste paste=pasteService.findPasteByIdReturnPaste(pasteid);
        ActionContext.getContext().put("paste",paste);

        //����������лظ�
        List<Answer> answerList=answerService.findAllAnswerByPasteId(pasteid);
        ActionContext.getContext().put("answerList",answerList);

        return "detail";
    }

    //�������
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
