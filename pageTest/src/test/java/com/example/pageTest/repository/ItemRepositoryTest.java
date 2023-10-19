package com.example.pageTest.repository;

import com.example.pageTest.entity.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    void findPageBy() {
        // given
        itemRepository.save(new Item("item1"));
        itemRepository.save(new Item("item2"));
        itemRepository.save(new Item("item3"));
        itemRepository.save(new Item("item4"));
        itemRepository.save(new Item("item5"));

        int page = 1;
        int size = 2;
        Pageable pageable = PageRequest.of(page,size);

        // when
        Page<Item> result = itemRepository.findPageBy(pageable);

        // then
        Assertions.assertThat(result.getContent()).extracting("name")
                .containsExactly(
                        "item3","item4"
                );
        Assertions.assertThat(result.getTotalPages()).isEqualTo(3);

    }

}