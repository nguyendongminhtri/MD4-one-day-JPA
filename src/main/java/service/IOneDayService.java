package service;

import model.OneDay;

import java.util.List;

public interface IOneDayService {
    List<OneDay> findAll();
    void save(OneDay oneDay);
    void delete(Long id);
    OneDay findById(Long id);
}
