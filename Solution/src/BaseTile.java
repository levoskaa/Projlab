//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : BaseTile.java
//  @ Date : 2019.03.20.
//  @ Author : 
//
//


import java.util.*;


public abstract class BaseTile {
    public Animal localAnimal;
    public List<BaseTile> Neighbours;

    public List<BaseTile> getNeighbours() {
        return Neighbours;
    }
    
    public void receive(Animal a) {
    }
    
    public void remove() {
    }
    
    public void setAnimal(Animal a) {
    }
    
    public void setItem(Item i) {
    }
    
    public void decraseHealth() {
    }
}
