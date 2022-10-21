package com.magaton.pjtpadroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magaton.pjtpadroes.model.Item;
import com.magaton.pjtpadroes.service.ItemService;

@RestController
@RequestMapping("itens")
public class ItemRestController {

    @Autowired
    private ItemService itemService;
//Lista todos os itens
    @GetMapping
    public ResponseEntity<Iterable<Item>> buscarTodos(){
        return ResponseEntity.ok(itemService.buscarTodos());
    }

//Busca um item pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(itemService.buscarPorId(id));
    }

//Salvar itme no banco de dados
    @PostMapping
    public ResponseEntity<Item> salvar(@RequestBody Item item){
        itemService.salvar(item);
        return ResponseEntity.ok(item);
    }

//Atualizar item no banco de dados
    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizar(@PathVariable Long id, @RequestBody Item item){
        itemService.atualizar(id, item);
        return ResponseEntity.ok(item);
    }

//Deletar item do banco de dados
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id){
        itemService.apagar(id);
        return ResponseEntity.ok().build();
    }

    
}
