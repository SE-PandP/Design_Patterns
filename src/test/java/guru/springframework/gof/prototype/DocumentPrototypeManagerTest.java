package guru.springframework.gof.prototype;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 4/21/2015.
 */
public class DocumentPrototypeManagerTest {

    @Test
    public void testGetClonedDocument() throws Exception {
    	/* PrototypeCapableDocument is an interface or abstract class that defines the contract for classes that permits cloning of its objects */
        /* DocumentPrototypeManager is a class that implements a registry to manage available prototypes for clients. On a client request, this class creates a copy of a prototype.*/
    	PrototypeCapableDocument clonedTAndC = DocumentPrototypeManager.getClonedDocument("tandc");
        clonedTAndC.setVendorName("Mary Parker");
        System.out.println(clonedTAndC);
        PrototypeCapableDocument clonedNDA = DocumentPrototypeManager.getClonedDocument("nda");
        clonedNDA.setVendorName("Patrick Smith");
        System.out.println(clonedNDA);
        /* TAndC and NDAgreement are the classes that provide operations to clone its objects using getClonedDocument() */
    }
}