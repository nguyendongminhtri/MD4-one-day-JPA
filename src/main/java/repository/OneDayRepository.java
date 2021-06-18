package repository;

import model.OneDay;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class OneDayRepository implements IOneDayRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<OneDay> findAll() {
        String queryStr = "select o from OneDay as o";
        List<OneDay> customerList = entityManager.createQuery(queryStr,OneDay.class).getResultList();
        return customerList;
    }

    @Override
    public void save(OneDay oneDay) {
        if(oneDay !=null){
            entityManager.merge(oneDay);
        } else {
            entityManager.persist(oneDay);
        }
    }


    @Override
    public void deleteById(Long id) {
        OneDay oneDay = findById(id);
        if(oneDay!=null){
            entityManager.remove(oneDay);
        }
    }

    @Override
    public OneDay findById(Long id) {
        String queryStr = "select c from OneDay as c where c.id =:id";
        OneDay customer = entityManager.createQuery(queryStr,OneDay.class).setParameter("id",id).getSingleResult();
        return customer;
    }
}
