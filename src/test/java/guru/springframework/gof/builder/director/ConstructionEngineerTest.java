package guru.springframework.gof.builder.director;

import guru.springframework.gof.builder.builders.HouseBuilder;
import guru.springframework.gof.builder.builders.ConcreteHouseBuilder;
import guru.springframework.gof.builder.builders.PrefabricatedHouseBuilder;
import guru.springframework.gof.builder.product.House;
import org.junit.Test;

public class ConstructionEngineerTest {

    @Test
    public void testConstructHouse() throws Exception {
        HouseBuilder concreteHouseBuilder = new ConcreteHouseBuilder(); /* HouseBuilder is an interface to build the parts of a product */
        ConstructionEngineer engineerA = new ConstructionEngineer(concreteHouseBuilder);
        House houseA = engineerA.constructHouse(); /* A class that represents the product to create */
        System.out.println("House is: "+houseA);
        PrefabricatedHouseBuilder prefabricatedHouseBuilder = new PrefabricatedHouseBuilder(); 
        /* PrefabricatedHouseBuilder and ConcreteHouseBuilder are the concrete classes that implement Builder to construct and assemble parts of the product and return the finished product */
        
        ConstructionEngineer engineerB = new ConstructionEngineer(prefabricatedHouseBuilder); /* A class that directs a builder to perform the steps in the order that is required to build the product */
        House houseB = engineerB.constructHouse();
        System.out.println("House is: "+houseB);
    }
}