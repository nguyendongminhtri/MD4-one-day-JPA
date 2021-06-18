package repository;

import model.OneDay;

import java.util.List;

public interface IOneDayRepository {
    List<OneDay> findAll();
    void save(OneDay oneDay);
    void deleteById(Long id);
    OneDay findById(Long id);
}
