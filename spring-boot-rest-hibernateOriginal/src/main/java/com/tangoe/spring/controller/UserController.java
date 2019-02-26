package com.tangoe.spring.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tangoe.spring.bean.User;
import com.tangoe.spring.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping( value = { "/user" } )
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<User> getUserById( @PathVariable( "id" ) int id )
    {
        System.out.println( "Fetching User with id " + id );
        User user = userService.findById( id );
        if( user == null )
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
        return new ResponseEntity<>( user, HttpStatus.OK );
    }

    @PostMapping( value = "/create", headers = "Accept=application/json" )
    public ResponseEntity<Void> createUser( @RequestBody User user, HttpServletRequest request,
                                            UriComponentsBuilder ucBuilder )
    {
        request.getHeader( "authorization" );
        //String lUserName = (new String(Base64Utils.decodeFromString( request.getHeader( "authorization" ).split("\\s+")[1] ))).split( ":" )[0];
        //String lPassword = (new String(Base64Utils.decodeFromString( request.getHeader( "authorization" ).split("\\s+")[1] ))).split( ":" )[1];
       // System.out.println( "Creating User " + lUserName );
        
        String encryptedPassword = getMD5EncryptedValue(user.getPassword());
        user.setPassword( encryptedPassword );
        
        userService.createUser( user );
        return new ResponseEntity<>( HttpStatus.CREATED ); 
    }

    @GetMapping( value = "/get", headers = "Accept=application/json" )
    public List<User> getAllUser()
    {
        List<User> tasks = userService.getUser();
        return tasks;

    }

    @PutMapping( value = "/update", headers = "Accept=application/json" )
    public ResponseEntity<String> updateUser( @RequestBody User currentUser )
    {
        User user = userService.findById( currentUser.getId() );
        if( user == null )
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
        userService.update( currentUser, currentUser.getId() );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @DeleteMapping( value = "/{id}", headers = "Accept=application/json" )
    public ResponseEntity<User> deleteUser( @PathVariable( "id" ) int id )
    {
        User user = userService.findById( id );
        if( user == null )
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
        userService.deleteUserById( id );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }

    @PatchMapping( value = "/{id}", headers = "Accept=application/json" )
    public ResponseEntity<User> updateUserPartially( @PathVariable( "id" ) int id,
                                                     @RequestBody User currentUser )
    {
        User user = userService.findById( id );
        if( user == null )
        {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
        User usr = userService.updatePartially( currentUser, id );
        return new ResponseEntity<>( usr, HttpStatus.OK );
    }
    
    public String getMD5EncryptedValue(String password) {
        final byte[] defaultBytes = password.getBytes();
        try {
            final MessageDigest md5MsgDigest = MessageDigest.getInstance("MD5");
            md5MsgDigest.reset();
            md5MsgDigest.update(defaultBytes);
            final byte messageDigest[] = md5MsgDigest.digest();
            final StringBuffer hexString = new StringBuffer();
            for (final byte element : messageDigest) {
                final String hex = Integer.toHexString(0xFF & element);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            password = hexString + "";
        } catch (final NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return password;
    }
}
