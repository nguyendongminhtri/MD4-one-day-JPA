package service;

import model.OneDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IOneDayRepository;

import java.util.List;

public class OneDayService implements IOneDayService{
    @Autowired
    IOneDayRepository oneDayRepository;
    @Override
    public List<OneDay> findAll() {
        return oneDayRepository.findAll();
    }

    @Override
    public void save(OneDay oneDay) {
        oneDayRepository.save(oneDay);
    }

    @Override
    public void delete(Long id) {
        oneDayRepository.deleteById(id);
    }

    @Override
    public OneDay findById(Long id) {
        return oneDayRepository.findById(id);
    }
}
