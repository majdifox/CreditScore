package utils;

public enum AncienneteEmploi {
    PLUS_DE_5_ANS(5),
    ENTRE_2_5_ANS(3),
    ENTRE_1_2_ANS(1),
    MOINS_DE_1_AN(0);

    private final int points;

//    constructor
    AncienneteEmploi(int points){
        this.points = points;
    }

//    getter
    public int getPoints(){
        return points;
    }

}
