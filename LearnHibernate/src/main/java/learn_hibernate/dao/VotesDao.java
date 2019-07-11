package learn_hibernate.dao;

import learn_hibernate.entity.Votes;
import org.hibernate.Session;

import java.util.List;

public class VotesDao extends AbstractDao<Votes>
{
  @Override
  public Votes read(long id)
  {
    Long key = Long.valueOf(id);
    Session session = HibernateUtil.getSessionFactory().openSession();
    Votes votes = session.get(Votes.class, key);
    session.close();
    return votes;
  }

  @Override
  public List<Votes> readAll()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Votes> votesList = session.createQuery("from Votes").list();
    session.close();
    return votesList;
  }
}
