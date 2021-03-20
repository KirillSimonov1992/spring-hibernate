package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public List<Car> getCarsByUser(User user) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM Car WHERE " +
                        "user.id = :id");
        query.setParameter("id", user.getId());

        return query.getResultList();
    }
}
