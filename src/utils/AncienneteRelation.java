package utils;

public enum AncienneteRelation {
    PLUS_DE_3_ANS(10),
    ENTRE_1_3_ANS(8),
    MOINS_DE_1_AN(5);

    private final int points;

// constructor
    AncienneteRelation(int points){
        this.points = points;
    }

//    getter
    public int getPoints(){
        return points;
    }
}
