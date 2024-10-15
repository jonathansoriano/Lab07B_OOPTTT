import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TTTButtonTest {
    TTTButton button1;
    @BeforeEach
    void setUp() {
        button1 = new TTTButton(0, 0);
    }

    @Test
    void getRow() {
        assertEquals(0, button1.getRow());
    }

    @Test
    void getCol() {
        assertEquals(0, button1.getCol());
    }
}