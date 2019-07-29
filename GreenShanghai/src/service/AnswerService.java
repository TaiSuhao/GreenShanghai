package service;

import dao.AnswerDao;
import model.Answer;
import model.Paste;

import java.util.List;

public class AnswerService {

    private AnswerDao answerDao;

    public void addAnswer(Answer answer, Paste paste) {
        paste.setAnsnum(paste.getAnsnum()+1);
        answerDao.addAnswer(answer);
    }

    public AnswerDao getAnswerDao() {
        return answerDao;
    }

    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public List<Answer> findAllAnswerByPasteId(String pasteid) {
        return answerDao.findAllAnswerByPasteId(pasteid);
    }

    public void deleteAnswerById(String answerid, Paste paste) {
        paste.setAnsnum(paste.getAnsnum()-1);
        answerDao.deleteAnswerById(answerid);
    }
}
