package utils;

public enum CritereComplementaire {
    AVEC_INVESTISSEMENTS(10),
    SANS_INVESTISSEMENTS(0);

    private final int points;

//    constructor
    CritereComplementaire(int points){
        this.points = points;
    }
//    getter
    public int getPoints(){
        return points;
    }
}
