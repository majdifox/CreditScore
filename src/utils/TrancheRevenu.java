package utils;

public enum TrancheRevenu {
    PLUS_DE_10000(30),
    ENTRE_8000_10000(25),
    ENTRE_5000_8000(20),
    ENTRE_3000_5000(15),
    MOINS_DE_3000(10);

    private final int points;

//    constructor
    TrancheRevenu(int points){
        this.points = points;
    }

//    getter
    public int getPoints(){
        return points;
    }
}
