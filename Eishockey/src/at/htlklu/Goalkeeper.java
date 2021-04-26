package at.htlklu;

public class Goalkeeper extends Player {
    public Goalkeeper(String name, int id, int penaltyMinutes, int catchQuote, int assists) {
        super(name, id, penaltyMinutes, catchQuote, assists);
    }

    public static Goalkeeper random(String name, int id) {
        return new Goalkeeper(name, id, (int) (Math.random() * 60), (int) (Math.random() * 100), (int) (Math.random() * 5));
    }

    @Override
    public String toString() {
        return "Goalkeeper{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", penaltyMinutes=" + penaltyMinutes +
                ", catchQuote=" + catchQuote +
                ", assists=" + assists +
                '}';
    }
}
