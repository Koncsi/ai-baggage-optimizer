package hu.bkoncser;

/**
 * Created by Koncsi on 30/10/2016.
 */
public class Item {
    int height;
    int width;


    Item(int h, int w){
        height = h;
        width = w;
    }

    int computeMomentum(){
        return height*width;
    }

    int maxExtension(){
        if(height>width)
            return height;
        else
            return width;
    }

    int bulkiness(){
        return (int) Math.sqrt(height*width);
    }
}
