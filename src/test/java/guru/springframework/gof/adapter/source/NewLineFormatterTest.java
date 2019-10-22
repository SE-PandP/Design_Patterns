package guru.springframework.gof.adapter.source;

import guru.springframework.gof.adapter.adaptee.CsvFormattable;
import guru.springframework.gof.adapter.adaptee.CsvFormatter;
import guru.springframework.gof.adapter.csvadapter.CsvAdapterImpl;
import org.junit.Test;

import static org.junit.Assert.*;


public class NewLineFormatterTest {
    @Test
    public void testFormatText() throws Exception {

            String testString=" Formatting line 1. Formatting line 2. Formatting line 3.";
            TextFormattable newLineFormatter=new NewLineFormatter(); /* Existing interface */
            /* The NewLineFormatter format the text by replacing periods with newline character*/
            String resultString = newLineFormatter.formatText(testString);
            System.out.println(resultString);
            /* As per the new requirement, we need to provide additional formating to support CSV */
            CsvFormattable csvFormatter=new CsvFormatter(); /* This is the new incompatible interface that needs adapting*/
            TextFormattable csvAdapter=new CsvAdapterImpl(csvFormatter); /* To adapt the CsvFormatter to the NewLineFormatter */
            String resultCsvString=csvAdapter.formatText(testString);
            System.out.println(resultCsvString);
    }
}