package at.htlklu;

public class Player {

    protected final String name;
    protected final int id;

    protected int penaltyMinutes;
    protected int catchQuote;
    protected int assists;

    public Player(String name, int id, int penaltyMinutes, int catchQuote, int assists) {
        this.name = name;
        this.id = id;
        this.penaltyMinutes = penaltyMinutes;
        this.catchQuote = catchQuote;
        this.assists = assists;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPenaltyMinutes() {
        return penaltyMinutes;
    }

    public void setPenaltyMinutes(int penaltyMinutes) {
        this.penaltyMinutes = penaltyMinutes;
    }

    public int getCatchQuote() {
        return catchQuote;
    }

    public void setCatchQuote(int catchQuote) {
        this.catchQuote = catchQuote;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

}
