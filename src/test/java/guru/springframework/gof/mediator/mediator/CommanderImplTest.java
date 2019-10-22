package guru.springframework.gof.mediator.mediator;

import guru.springframework.gof.mediator.colleague.ArmedUnit;
import guru.springframework.gof.mediator.colleague.SoldierUnit;
import guru.springframework.gof.mediator.colleague.TankUnit;
import org.junit.Test;

import static org.junit.Assert.*;


public class CommanderImplTest {

    @Test
    public void testMediator() throws Exception {
        Commander commander= new CommanderImpl(); 
        /* commander is a mediator interface that declares methods for communicating with Colleague objects */
        /* CommanderImpl is the concrete mediator that maintains and coordinates Colleague objects */
        ArmedUnit soldierUnit=new SoldierUnit(commander); /* Colleague*/
        ArmedUnit tankUnit=new TankUnit(commander); /* Another Colleague*/
        /* Below is the logic for communication between Colleague using mediator */
        commander.registerArmedUnits(soldierUnit, tankUnit);
        commander.startAttack(soldierUnit);
        commander.startAttack(tankUnit);
        commander.ceaseAttack(soldierUnit);
        commander.startAttack(tankUnit);
    }
}