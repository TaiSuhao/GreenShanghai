package service;

import dao.AnswerDao;
import dao.PasteDao;
import dao.UserDao;
import model.Answer;
import model.Paste;
import model.User;
import utils.PageBean;

import java.util.List;

public class PasteService {

    private PasteDao pasteDao;
    private AnswerDao answerDao;
    private UserDao userDao;

    public void addPaste(Paste paste) {
        pasteDao.addPaste(paste);
    }

    public PasteDao getPasteDao() {
        return pasteDao;
    }

    public void setPasteDao(PasteDao pasteDao) {
        this.pasteDao = pasteDao;
    }

    public List<Paste> findAllPaste() {
       return pasteDao.findAllPaste();
    }

    public AnswerDao getAnswerDao() {
        return answerDao;
    }

    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public PageBean getPastePageBean(Integer currentPage) {

        Integer totalCount=getPasteDao().findAllPasteNumber();
        PageBean pageBean=new PageBean(currentPage,totalCount,10);
        List<Paste> list=pasteDao.getPastePageList(pageBean.getStart(),pageBean.getPageSize());
        pageBean.setList(list);
        return pageBean;
    }

    public Paste findPasteByIdReturnPaste(String pasteid) {
        //这种方式太麻烦了
        //pasteDao.addPasteGlanceover(pasteid);
        //直接持久化对象进行操作
        Paste paste=pasteDao.findPasteByIdReturnPaste(pasteid);
        paste.setGlanceover(paste.getGlanceover()+1);
        return paste;
    }

    public void solvePasteByIdAndAnswerId(String pasteid, Integer answerid) {
        Paste paste=pasteDao.findPasteByIdReturnPaste(pasteid);
        //给回复的人加金币
        Answer answer=answerDao.findAnswerById(answerid);
        //System.out.println(answer.getUser().getUsername());
        User user=userDao.findUserByUserId(answer.getUser().getId());
        user.setCoin(user.getCoin()+paste.getOffer());
        pasteDao.solvePasteByIdAndAnswerId(pasteid,answerid);
    }


}
