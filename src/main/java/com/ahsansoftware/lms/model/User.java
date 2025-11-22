package com.ahsansoftware.lms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "users")
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false , unique = true , length = 50)
    private String username;

    @NotBlank
    @Column(nullable = false)
    private String password;
    
    @NotBlank
    @Email
    @Column(nullable = false , unique = true )
    private String email;

    private String role = "USER";

    public User(){}

    public User(Long id , String username , String password , String email , String role){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    @Override
    public Collection<?extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("ROLE_"+role));
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

    public Long getId(){ return id; }
    public void serId(Long id){
        this.id = id;
    }

    public void setUsername(String username){ this.username = username; }
    public void setPassword(String password){ this.password = password; }

    public String getRole(){ return role; }
    public void setRole(String role){
        this.role = role;
    }

    public String getEmail(){ return email; }
    public void setEmail(String email){
        this.email = email;
    }


}
