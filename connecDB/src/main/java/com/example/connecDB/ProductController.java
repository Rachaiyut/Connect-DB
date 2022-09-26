package com.example.connecDB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductReposity productreposity;

    @GetMapping("/products")
    public List<product> getProductList(){
        return productreposity.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<product> getProductById(@PathVariable Integer id){
        product p = productreposity.findById(id).orElseThrow();
        return ResponseEntity.ok(p);
    }

    @PostMapping("/products")
    public product createProduct(@RequestBody product p){
        return productreposity.save(p);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<product> updateProduct(@PathVariable Integer id, @RequestBody product productdetail){
        product p = productreposity.findById(id).orElseThrow(() -> new IllegalStateException("not found"));
        p.setProductname(productdetail.getProductname());
        p.setProductprice(productdetail.getProductprice());
        product updateProduct=productreposity.save(p);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("products/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Integer id){
            product p = productreposity.findById(id).orElseThrow();
            productreposity.delete(p);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }
    

    // @GetMapping("/products/{id}")
    // public product getProduct(@PathVariable("id") Integer id){
    //     return productreposity.findById(id);
    // }

    // @GetMapping("/delete")
    // public String SayDelete(){
    //     productreposity.delete(1);
    //     return "delete";
    // }
}
