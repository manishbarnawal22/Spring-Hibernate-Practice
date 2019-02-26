package com.tangoe.spring.dao;

import java.util.List;

import com.tangoe.spring.bean.Item;

public interface ItemDao
{
    public void createItem( Item item );

    public List<Item> getItem();

    public Item findById( int id );

    public Item update( Item itemVal,
                        int id );

    public void deleteItemById( int id );
}
