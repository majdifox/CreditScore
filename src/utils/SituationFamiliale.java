package utils;

public enum SituationFamiliale {
    MARIE(3),
    CELIBATAIRE(2),
    DIVORCE(1),
    VEUF(1);

    private final int points;

//    constructor
    SituationFamiliale(int points){
        this.points = points;
    }

//getter
    public int getPoints(){
        return points;
    }

}
