package com.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ItemDAO itemDAO;

    public Item update(Item item) throws Exception {
        if (item == null || item.getId() == null || itemDAO.findById(item.getId()) == null) {
            throw new Exception("Проверьте данные");
        }

        return itemDAO.update(item);
    }

    public Item save(Item item) {
        return itemDAO.save(item);
    }

    public void delete(Long id) throws Exception {
        if (id == null || id == 0) {
            throw new Exception("id не может быть пустым или равно 0");
        }

        itemDAO.delete(id);
    }

    public Item serviceFindById(Long id) {

        return itemDAO.findById(id);
    }
}
