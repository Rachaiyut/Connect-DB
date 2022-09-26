package com.example.connecDB;

import org.springframework.data.jpa.repository.JpaRepository;;

public interface ProductReposity extends JpaRepository<product, Integer> {
    
}