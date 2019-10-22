package guru.springframework.gof.facade.controller;

import guru.springframework.gof.facade.servicefacade.OrderServiceFacadeImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderFulfillmentControllerTest {

    @Test
    public void testOrderProduct() throws Exception {
        OrderFulfillmentController controller=new OrderFulfillmentController(); /* Controller  */
        controller.facade=new OrderServiceFacadeImpl(); /* Controller invoking subsystem through facade */
        controller.orderProduct(9);
        boolean result=controller.orderFulfilled;
        assertTrue(result);
    }
}