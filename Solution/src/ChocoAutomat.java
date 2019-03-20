public class ChocoAutomat extends Item {

    //Tile onTile;

    @Override
    public void countDown() {
        --Counter;
        if(Counter <= 0) {
//            Tile[] Neighbours = onTile.getNeighbours();
//            for(int i = 0; i < Neighbours.size(); ++i) {
//                Neighbours[i].beep();
//            }
            Counter = 100;
        }
    }

    public ChocoAutomat(/*Tile t*/){
        //onTile = t;
        Counter = 100;
    }
}
