package model;

import model.Customers;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomersTest {

  @Test
 public void testCustomers(){
   Customers customers= new Customers();
   //customers.setCustomerNo(new Atomic1222);
   customers.setFirst("first_name");
   customers.setLast("last_name");
   customers.setEmail("email@gmail.cpm");
   customers.setPhone("(954)-555-1423");
   customers.setGender("Male");

    assertTrue(customers.getCustomerNo() >1);

    customers.setGender("Woo Man");
    assertTrue(customers.getGender().equals("Male") || customers.getGender().equals("Female"));
 }

}