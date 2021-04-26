package at.htlklu;


public class Test {

    public static void main(String[] args) {
        Player[] players = new Player[6];
        int goalKeepersCount = (int) ((Math.random() * (6 - 1)) + 1);

        for (int i = 0; i < goalKeepersCount; i++) {
            players[i] = Goalkeeper.random("Juergen", i);
        }

        for (int i = goalKeepersCount; i < players.length; i++) {
            players[i] = FieldPlayer.random("Fred", i);
        }

        for (Player player : players) {
            System.out.println(player);
        }

        System.out.println("Is team valid: " + isValidTeam(players));
    }

    private static boolean isValidTeam(Player[] players){
        for(int i = 0; i<players.length; i++){
            if(players[i] instanceof Goalkeeper && i > 0){
               return false;
            }
        }

        return true;
    }
}
