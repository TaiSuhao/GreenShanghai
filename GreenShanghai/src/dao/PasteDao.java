package dao;

import model.Paste;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.math.BigInteger;
import java.util.List;

public class PasteDao extends HibernateDaoSupport {
    public void addPaste(Paste paste) {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.save(paste);
    }

    public List<Paste> findAllPaste() {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        String hql="from model.Paste";
        Query query=session.createQuery(hql);
        List<Paste> list=query.list();
        return list;
    }

    //查找所有帖子数量
    public Integer findAllPasteNumber() {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        String sql="select count(*) from paste";
        NativeQuery query=session.createSQLQuery(sql);
        BigInteger result= (BigInteger) query.uniqueResult();
        return result.intValue();
    }

    //返回一个分页的帖子
    public List<Paste> getPastePageList(Integer start, Integer pageSize) {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        String sql="select * from paste limit ?,?";
        NativeQuery query=session.createSQLQuery(sql);
        query.addEntity(Paste.class);
        query.setParameter(1,start);
        query.setParameter(2,pageSize);
        List pasteList=query.list();
        return pasteList;
    }

    public Paste findPasteByIdReturnPaste(String pasteid) {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        String sql="select * from paste where id=?";
        NativeQuery query=session.createSQLQuery(sql);
        query.addEntity(Paste.class);
        query.setParameter(1,pasteid);
        Paste result=(Paste) query.uniqueResult();
        return result;
    }

    public void addPasteGlanceover(String pasteid) {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        String sql="update paste set glanceover=glanceover+1 where id=?";
        NativeQuery query=session.createSQLQuery(sql);
        query.addEntity(Paste.class);
        query.setParameter(1,pasteid);
        query.executeUpdate();
    }

    public void solvePasteByIdAndAnswerId(String pasteid, Integer answerid) {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        String sql="update paste set solve=1,ansid=? where id=?";
        NativeQuery query=session.createSQLQuery(sql);
        query.setParameter(1,answerid);
        query.setParameter(2,pasteid);
        query.executeUpdate();
    }
}
