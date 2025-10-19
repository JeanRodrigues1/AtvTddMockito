package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number>{
    private CustomStack<T> customStack;

    public NumberAscOrder(CustomStack<T> customStack) {
        this.customStack = customStack;
    }


    public List<T> sort(){
        List<T> numeros = new ArrayList<>();

        while (!customStack.isEmpty()){
            try{
                numeros.add(customStack.pop());
            } catch(StackEmptyException e){
                e.printStackTrace();
            }
        }

        Collections.sort(numeros, null);

        return numeros;
    }
}
