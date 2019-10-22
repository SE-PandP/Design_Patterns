package guru.springframework.gof.state.context;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CandyVendingMachineTest {

     @Test
    public void testCandyVendingMachine() throws Exception {
       System.out.println("-----Test 1: Testing machine by inserting coin and pressing button-----");
        CandyVendingMachine machine=new CandyVendingMachine(3);
        /* Context "CandyVendingMachine" provides and interface to client to perform some action and delegates state specific requests to the ConcreteState subclass that defines the current state.*/
        /* Context uses a state interface "CandyVendingMachineState"  that encapsulates the behavior associated with a particular state of the Context */
        /* NoCoinState, ContainsCoinState, DispensedState, and NoCandyState are the ConcreteState subclasses that implements a behavior associated with a state of the Context */
        
        System.out.println(machine);
        machine.insertCoin();
        System.out.println(machine);
        machine.pressButton();
        System.out.println(machine);

        System.out.println("-----Test 2: Testing machine by pressing button without inserting coin-----");
        CandyVendingMachine machine2=new CandyVendingMachine(3);
        System.out.println(machine2);
        machine2.pressButton();
        System.out.println(machine2);

         System.out.println("-----Test 3: Testing machine running out of candies-----");
         CandyVendingMachine machine3=new CandyVendingMachine(3);
         System.out.println(machine3);
         machine3.insertCoin();
         machine3.pressButton();
         machine3.insertCoin();
         machine3.pressButton();
         machine3.insertCoin();
         machine3.pressButton();
         machine3.insertCoin();
         machine3.pressButton();
         System.out.println(machine3);
    }

}