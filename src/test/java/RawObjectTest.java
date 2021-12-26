import org.junit.Test;
import ru.fls.Main;

import static org.junit.Assert.assertEquals;

public class RawObjectTest {


    @Test
    public void deserialization() throws Exception {
        assertEquals("KCIUQ XOF   SPMUJ    ", Main.revertWords("QUICK FOX   JUMPS    "));
    }

}