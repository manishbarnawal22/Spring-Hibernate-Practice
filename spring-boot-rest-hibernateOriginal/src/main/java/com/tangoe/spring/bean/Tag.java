package com.tangoe.spring.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name = "TAG" )
public class Tag
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
  
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    
    @ManyToMany( mappedBy = "tags")
    private List<Item> items = new ArrayList<>();
    
    public Integer getId() {
        return id;
    }
    
    public List<Item> getItems()
    {
        return items;
    }

    public void setItems( List<Item> items )
    {
        this.items = items;
    }

}
