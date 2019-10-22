package guru.springframework.gof.strategy.context;

import guru.springframework.gof.strategy.strategies.AesEncryptionStrategy;
import guru.springframework.gof.strategy.strategies.BlowfishEncryptionStrategy;
import guru.springframework.gof.strategy.strategies.EncryptionStrategy;
import org.junit.Test;

import static org.junit.Assert.*;


public class EncryptorTest {

    @Test
    public void testEncrypt() throws Exception {
    	
     /* EncryptionStrategy is the Strategy interface that is common to all supported algorithm-specific classes */
     /* AesEncryptionStrategy is the Concrete Strategy that implements the algorithm using the Strategy interface */
      EncryptionStrategy aesStrategy=new AesEncryptionStrategy();
      Encryptor aesEncryptor=new Encryptor(aesStrategy);
      /* Encryptor is the Context interface to client for encrypting data. The Context maintains a reference to a Strategy object and is instantiated and initialized by clients with a ConcreteStrategy object */
      aesEncryptor.setPlainText("This is plain text");
      aesEncryptor.encrypt();

        EncryptionStrategy blowfishStrategy=new BlowfishEncryptionStrategy();
        Encryptor blowfishEncryptor=new Encryptor(blowfishStrategy);
        blowfishEncryptor.setPlainText("This is plain text");
        blowfishEncryptor.encrypt();
    }
}