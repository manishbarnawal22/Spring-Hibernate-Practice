package com.tangoe.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "USER" )
public class User
{

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;

    @Column( name = "PASSWORD" )
    private String password;
    
    @Column( name = "TYPE" )
    private String type;
    
    @Column( name = "FIRST_NAME" )
    private String firstname;

    @Column( name = "LAST_NAME" )
    private String lastname;

    @Column( name = "EMAIL" )
    private String email;

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname( String firstName )
    {
        this.firstname = firstName;
    }

    public String getLastName()
    {
        return lastname;
    }

    public void setLastname( String lastName )
    {
        this.lastname = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }
}
