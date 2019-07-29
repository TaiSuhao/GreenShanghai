package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDao extends HibernateDaoSupport {
    public User findUser(User user) {


        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        String hql="from model.User where username=?1 and password=?2";
        Query query=session.createQuery(hql);
        query.setParameter(1,user.getUsername());
        query.setParameter(2,user.getPassword());
        User user1=(User)query.uniqueResult();
        return user1;

    }

    public void changeUser() {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        User user=session.get(User.class,1);
        user.setUsername("gwc");
    }

    public boolean addUser(User user) {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        session.save(user);
        boolean succcess=true;
        return succcess;
    }

    public User findUserByUserId(int id) {
        Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
        String sql="select * from user where id=?";
        NativeQuery query=session.createSQLQuery(sql);
        query.setParameter(1,id);
        query.addEntity(User.class);
        User result=(User) query.uniqueResult();
        return result;
    }
}
