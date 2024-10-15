public class PlayerO implements Player{
    private String playerMove;

    public PlayerO(){
        this.playerMove = "O";
    }
    @Override
    public String getPlayerMove() {
        return playerMove;
    }
}
