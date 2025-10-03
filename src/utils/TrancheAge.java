package utils;

public enum TrancheAge {
    ENTRE_18_25(4),
    ENTRE_26_35(8),
    ENTRE_36_55(10),
    PLUS_DE_55(6);

    private final int points;

//    constructor
    TrancheAge( int points){
        this.points = points;
    }
//    getter
    public int getPoints(){
        return points;
    }
}
