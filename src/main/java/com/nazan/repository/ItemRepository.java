package com.nazan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nazan.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
