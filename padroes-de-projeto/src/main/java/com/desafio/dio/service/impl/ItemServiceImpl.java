package com.desafio.dio.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.dio.model.Item;
import com.desafio.dio.model.ItemRepository;
import com.desafio.dio.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    //Singleton injetar os componentes do Spring com @Autowired.
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Iterable<Item> buscarTodos(){
        return itemRepository.findAll();
    }

    @Override
    public Item buscarPorId(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.get();
    }

    @Override
    public void salvar(Item item) {
        salvar(item);
        
    }

    @Override
    public void atualizar(Long id, Item item) {
       Optional<Item> itemBd = itemRepository.findById(id);
       if(itemBd.isPresent()){
        salvar(item);
       }
        
    }

    @Override
    public void apagar(Long id) {
        itemRepository.deleteById(id);
        
    }
    
}
