public class Couch extends Item {

    //Panda RestingPanda;

    @Override
    public void countDown(){ }

    public void receive(/*Panda p*/) {
        if(true/*RestingPanda == null*/){ //a true, csak azért van ott, hogy amíg nincs panda osztály, addig se sírjon az Intellj
            //RestingPanda = p;
            //RestingPanda.sit(onTile);
        }
    }

    public Couch(/*Tile t*/){
        //onTile = t;
    }
}
