/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
public class IntegradoTest {
    @Test
    public void generatePassword(){
    
    BCryptPasswordEncoder passGen =  new  BCryptPasswordEncoder();
    System.out.println(passGen.encode("admin"));
    }
    
}
