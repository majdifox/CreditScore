package utils;

public enum TypeContrat {

    CDI_PUBLIC(25),
    CDI_PRIVE_GRANDE_ENTREPRISE(15),
    CDI_PRIVE_PME(12),
    CDD_INTERIM(10),
    PROFESSION_LIBERALE(18),
    AUTO_ENTREPRENEUR(12);

    //constructor
    private final int points;

    TypeContrat(int points){
        this.points = points;
    }

    //getters
    public int getPoints(){
        return points;
    }

}


