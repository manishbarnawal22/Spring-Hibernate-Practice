package com.tangoe.spring.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tangoe.spring.bean.Item;
import com.tangoe.spring.bean.User;
import com.tangoe.spring.dao.ItemDao;

@Service
@Transactional
public class ItemServiceImpl implements ItemService
{
    @Autowired
    private ItemDao itemDao;
    
    @Override
    public void createItem( Item item )
    {
        itemDao.createItem( item );
    }

    @Override
    public List<Item> getItem()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Item findById( int id )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Item update( Item item,
                        int id )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteItemById( int id )
    {
        // TODO Auto-generated method stub
        
    }


}
