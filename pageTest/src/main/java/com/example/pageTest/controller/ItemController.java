package com.example.pageTest.controller;

import com.example.pageTest.entity.Item;
import com.example.pageTest.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/item")
    public Page<Item> items(@PageableDefault(size=5) Pageable pageable) {
        return itemRepository.findPageBy(pageable);
    }
}
