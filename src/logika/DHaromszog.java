package logika;
public class DHaromszog {
    //adattagok
    private double aOldal;
    private double bOldal;
    private double cOldal;
    private int sorSzam;
    //konstr
    public DHaromszog(String sor, int sorszam) throws Exception{
        this.setSorSzam(sorszam);
        String[] data = sor.replace(',','.').split(" ");
        this.setaOldal(Double.parseDouble(data[0]));
        this.setbOldal(Double.parseDouble(data[1]));
        this.setcOldal(Double.parseDouble(data[2]));
        this.EllNovekvoSor();
        this.EllMegszerk();
        this.EllDerek();
    }
    //getterek
    public double getaOldal() {
        return aOldal;
    }
    public double getbOldal() {
        return bOldal;
    }
    public double getcOldal() {
        return cOldal;
    }
    public int getSorSzam() {
        return sorSzam;
    }
    //setterek
    public void setaOldal(double aOldal) throws Exception{
        if (aOldal > 0) {
            this.aOldal = aOldal;
        }else{
            throw new Exception("Az A oldal nem lehet 0 vagy negatív!");
        }
    }
    public void setbOldal(double bOldal) throws Exception{
        if (bOldal > 0) {
            this.bOldal = bOldal;
        }else{
            throw new Exception("A B oldal nem lehet 0 vagy negatív!");
        }
    }
    public void setcOldal(double cOldal) throws Exception{
        if (cOldal > 0) {
            this.cOldal = cOldal;
        }else{
            throw new Exception("A C oldal nem lehet 0 vagy negatív!");
        }
    }
    public void setSorSzam(int sorSzam) {
        this.sorSzam = sorSzam;
    }
    //misc
    private boolean EllDerek() throws Exception{
        boolean derekLegeny = Math.pow(aOldal,2) + Math.pow(bOldal,2) == Math.pow(cOldal,2);
        if (derekLegeny) {
            throw new Exception("A háromszöget nem lehet megszerkezteni.");
        }
        return derekLegeny;
    }
    private boolean EllMegszerk() throws Exception{
        boolean szerkeztheto = aOldal + bOldal > cOldal;
        if (szerkeztheto) {
            throw new Exception("A háromszöget nem lehet megszerkezteni.");
        }
        return szerkeztheto;
    }
    private boolean EllNovekvoSor() throws Exception{
        boolean novekvo = aOldal < bOldal && bOldal < cOldal;
        if (!novekvo) {
            throw new Exception("Az adatok nincsenek növekvő sorrendendben.");
        }
        return novekvo;
    }
    public double Kerulet(){
        return this.aOldal + this.bOldal + this.cOldal;
    }
    public double Terulet(){
        return this.aOldal * this.bOldal / 2;
    }
    //toString
    @Override
    public String toString() {
        return String.format("%d. sor: a = %f b = %f c = %f",
                this.sorSzam,
                this.aOldal,
                this.bOldal,
                this.cOldal);
    }
}