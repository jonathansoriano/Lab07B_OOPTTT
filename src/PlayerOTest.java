import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerOTest {
    PlayerO player1;

    @BeforeEach
    void setUp(){
        player1 = new PlayerO();
    }

    @Test
    void getPlayerMove() {
        assertEquals("O", player1.getPlayerMove());
    }
}