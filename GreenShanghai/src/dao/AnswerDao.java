package dao;

import model.Answer;
import model.Paste;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class AnswerDao extends HibernateDaoSupport {
    public void addAnswer(Answer answer) {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.save(answer);
    }

    public List<Answer> findAllAnswerByPasteId(String pasteid) {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        String sql="select * from answer where pasteid=?";
        NativeQuery query=session.createSQLQuery(sql);
        query.addEntity(Answer.class);
        query.setParameter(1,pasteid);
        List<Answer> list=query.list();
        return list;
    }

    public void deleteAnswerById(String answerid) {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        String sql="delete from answer where id=?";
        NativeQuery query=session.createSQLQuery(sql);
        query.setParameter(1,answerid);
        query.executeUpdate();
    }

    public Answer findAnswerById(Integer answerid) {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        String sql="select * from answer where id=?";
        NativeQuery query=session.createSQLQuery(sql);
        query.setParameter(1,answerid);
        query.addEntity(Answer.class);
        Answer result=(Answer) query.uniqueResult();
        return result;
    }
}
