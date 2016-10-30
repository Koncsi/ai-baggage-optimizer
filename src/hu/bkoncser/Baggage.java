package hu.bkoncser;

import java.util.ArrayList;

/**
 * Created by Koncsi on 30/10/2016.
 */
public class Baggage {
    int height;
    int width;

    int[][] layout;

    Baggage(int h, int w){
        height = h;
        width = w;

        layout = new int[h][w];
    }

    public void optimize(ArrayList<Item> items) {
        Item[] sortedItems = sort(items);
        for(int i = 0; i<sortedItems.length; i++){
           // System.out.println(i + ": " + sortedItems[i].computeMomentum());
            putIn(sortedItems[i], i+1);
        }
    }

    private void putIn(Item sortedItem,int i) {

        if(isEnoughtSpace(sortedItem.computeMomentum())){
            fitIn(sortedItem, i);
        }

    }

    private void fitIn(Item sortedItem, int name) {
        for(int j = 0; j <width; j++){
            for(int i = 0; i< height; i++){
                if(isFit(sortedItem,i,j)){
                    add(sortedItem,i,j, name);
                    return;
                }        
            }
        }
    }

    private void add(Item sortedItem, int i, int j, int name) {
        for(int Jndex = 0; Jndex < sortedItem.width; Jndex++){
            for(int Index = 0; Index < sortedItem.height; Index++){
                layout[i+Index][j+Jndex] = name;
            }
        }
    }

    private boolean isFit(Item sortedItem, int i, int j) {
        if(i+sortedItem.height <= height && j+sortedItem.width <= width){
            for(int k = i; k< height; k++){
                for(int l = j; l <width; l++){
                    if(layout[k][l] != 0)
                        return false;
                }
            }
            return  true;
        }
        else
            return false;
    }

    private boolean isEnoughtSpace(int size) {
        int empty = 0;
        for(int i = 0; i< height; i++)
            for(int j = 0; j <width; j++)
                if(layout[i][j] == 0)
                    empty++;
        if(empty>size)
            return true;
        else
            return false;
    }

    private Item[] sort(ArrayList<Item> items) {
        Item[] sorted = new Item[items.size()];
        int index = 0;
        while(index < sorted.length){
            Item maxItem = items.get(0);
            for(Item i:items){
                if(i.computeMomentum() > maxItem.computeMomentum() && i.maxExtension() > maxItem.maxExtension() && i.bulkiness() > maxItem.bulkiness())
                    maxItem = i;
            }
            items.remove(maxItem);
            sorted[index++] = maxItem;
        }
        return sorted;
    }

    public void print() {
        for(int i= 0; i < height; i++){
            for(int j = 0; j<width; j++){
                if(j == width-1)
                    System.out.println(layout[i][j]);
                else
                    System.out.print(layout[i][j] + " ");
            }
        }
    }
}
