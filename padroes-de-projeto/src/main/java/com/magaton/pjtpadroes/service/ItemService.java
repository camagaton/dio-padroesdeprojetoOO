package com.magaton.pjtpadroes.service;

import com.magaton.pjtpadroes.model.Item;

public interface  ItemService {

    Iterable<Item> buscarTodos();

    Item buscarPorId(Long id);

    void salvar(Item item);

    void atualizar(Long id, Item item);

    void apagar(Long id);
    
}
