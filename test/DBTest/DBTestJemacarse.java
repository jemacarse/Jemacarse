/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBTest;

import javax.persistence.Persistence;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class DBTestJemacarse {
    
   @Test
   public void test (){
       
       Persistence.createEntityManagerFactory("JemacarsePU");
   }
    
    
}
