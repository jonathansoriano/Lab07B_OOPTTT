public class PlayerX implements Player {
    private String playerMove;

    public PlayerX(){
        this.playerMove = "X";
    }

    @Override
    public String getPlayerMove() {
        return playerMove;
    }
}
