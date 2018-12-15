class SimpleGeneric<Bbb, y> {

    //declaration of object type T
    private Bbb objReff = null;
    y objRe = null;

    //constructor to accept type parameter T
    public SimpleGeneric(Bbb param, y par, int num) {
        this.objReff = param;
        this.objRe = par;
    }

    public Bbb getObjReff() {
        return this.objReff;
    }

    //this method prints the holding parameter type
    public void printType() {
        System.out.println("Type: " + objReff.getClass().getName());
    }
}