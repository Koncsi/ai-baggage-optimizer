package hu.bkoncser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by bkoncser on 2016-10-26.
 */
public class Main {

    public static void main(String[] args){

        Baggage baggage = null;
        ArrayList<Item> items = new ArrayList<>();

        String[] values;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {

            input = reader.readLine();
            values = input.split("\t",-1);
            baggage = new Baggage(Integer.parseInt(values[0]), Integer.parseInt(values[1]));

            input = reader.readLine();
            int itemSize = Integer.parseInt(input);

            for(int i = 0; i < itemSize; i++){
                input = reader.readLine();
                values = input.split("\t",-1);
                items.add(new Item(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        baggage.optimize(items);
        baggage.print();

    }
}
