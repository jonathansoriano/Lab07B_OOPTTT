import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerXTest {
    PlayerX player1;

    @BeforeEach
    void setUp() {
        player1 = new PlayerX();
    }

    @Test
    void getPlayerMove() {
        assertEquals("X", player1.getPlayerMove());
    }
}