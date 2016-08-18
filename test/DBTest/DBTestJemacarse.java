package DBTest;

import javax.persistence.Persistence;
import org.junit.Test;

public class DBTestJemacarse {
    
   @Test
   public void test (){
       
       Persistence.createEntityManagerFactory("JemacarsePU");
   }   
}
