package com.example.pageTest.repository;

import com.example.pageTest.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
    Page<Item> findPageBy(Pageable pageable);
}
