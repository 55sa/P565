package edu.iu.p565.customerservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.iu.p565.customerservice.model.Customer;
import edu.iu.p565.respository.CustomerRespositoy;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerRespositoy respositoy;


    @GetMapping
    public List<Customer> findAll(){
        return respositoy.findAll();
    }

//Post localhost: 8080/customers
@PostMapping
    public int creat(@RequestBody Customer customer){
        return respositoy.create(customer);
    }
    
  
public void  update(@RequestBody Customer customer, int id){
    respositoy.update(customer, id);
}

@DeleteMapping("/{id}")
public void  delete(@PathVariable Customer customer,int id ){
    respositoy.delete(id);
}


}
