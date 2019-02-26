package com.tangoe.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tangoe.spring.bean.Item;

@Repository
public class ItemDaoImpl implements ItemDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createItem( Item item )
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate( item );
    }

    @Override
    public List<Item> getItem()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Item> list = session.createCriteria( Item.class ).list();
        return list;
    }

    @Override
    public Item findById( int id )
    {
        Session session = sessionFactory.getCurrentSession();
        Item item = (Item) session.get( Item.class, id );
        return item;
    }

    @Override
    public Item update( Item itemVal,
                        int id )
    {
        Session session = sessionFactory.getCurrentSession();
        Item item = (Item) session.get( Item.class, id );
        item.setBody( itemVal.getBody() );
        session.update( item );
        return item;
    }

    @Override
    public void deleteItemById( int id )
    {
        Session session = sessionFactory.getCurrentSession();
        Item item = findById( id );
        session.delete( item );
    }
}
