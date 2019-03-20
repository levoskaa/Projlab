public class SlotMachine extends Item {

    @Override
    public void countDown() {
        --Counter;
        if(Counter <= 0){
//            Tile[]Neighbours = onTile.getNeighbours();
//            for(int i = 0; i < Neighbours.size(); ++i) {
//                Neighbours[i].ring();
//            }
            Counter = 100;
        }
    }

    public SlotMachine(/*Tile t*/) {
        //onTile = t;
        Counter = 100;
    }
}
