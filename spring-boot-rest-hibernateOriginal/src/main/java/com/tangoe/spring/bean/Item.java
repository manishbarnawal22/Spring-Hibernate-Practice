package com.tangoe.spring.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name = "ITEM" )
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name = "TITLE", unique = true, nullable = true)
    private String title;
    
    @Column(name = "BODY", nullable = true)
    private String body;

    //If we want to override the id column in link table we can do like below:
    //@JoinTable(name = "ITEM_TAG" ,joinColumns = {@JoinColumn(name="ITEM_ID") },
    //inverseJoinColumns = {@JoinColumn(name="ID")}) else it will generate based on the entityname(s)_Id
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ITEM_TAG" )
    private List<Tag> tags = new ArrayList<>();
    
    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody( String body )
    {
        this.body = body;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public List<Tag> getTags()
    {
        return tags;
    }

    public void setTags( List<Tag> tags )
    {
        this.tags = tags;
    }
}
