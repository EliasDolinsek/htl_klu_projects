package at.htlklu;

public class FieldPlayer extends Player {

    protected int goals;

    public FieldPlayer(String name, int id, int penaltyMinutes, int catchQuote, int assists, int goals) {
        super(name, id, penaltyMinutes, catchQuote, assists);
        this.goals = goals;
    }

    public static FieldPlayer random(String name, int id) {
        return new FieldPlayer(name, id, (int) (Math.random() * 60), (int) (Math.random() * 100), (int) (Math.random() * 5), (int) (Math.random() * 10));
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    @Override
    public String toString() {
        return "FieldPlayer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", goals=" + goals +
                ", penaltyMinutes=" + penaltyMinutes +
                ", catchQuote=" + catchQuote +
                ", assists=" + assists +
                '}';
    }
}
