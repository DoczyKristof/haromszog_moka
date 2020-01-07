package logika;
public class DHaromszog {
    //adattagok
    private double aOldal;
    private double bOldal;
    private double cOldal;
    //konstr
    public DHaromszog(String sor, int sorszam){
        
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
    //setterek
    public void setaOldal(double aOldal) throws Exception{
        if (aOldal > 0) {
            this.aOldal = aOldal;
        }
        else{
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
}