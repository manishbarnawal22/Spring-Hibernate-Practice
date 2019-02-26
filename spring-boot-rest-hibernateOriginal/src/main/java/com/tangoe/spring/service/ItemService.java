package com.tangoe.spring.service;

import java.util.List;

import com.tangoe.spring.bean.Item;
import com.tangoe.spring.bean.User;

interface ItemService
{
    public void createItem( Item item );

    public List<Item> getItem();

    public Item findById( int id );

    public Item update( Item item,
                        int id );

    public void deleteItemById( int id );
}
