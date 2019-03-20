public class SlotMachine extends Item {

    //Tile onTile;

    @Override
    public void countDown() {
        --Counter;
        if(Counter <= 0){
            //onTile.ring();
        }
    }

    public SlotMachine(/*Tile t*/) {
        super();
        //onTile = t;
    }
}
