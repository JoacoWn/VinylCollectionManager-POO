package logica;

import data.Vinilo;

import java.util.ArrayList;

public class ColeccionVinilo {
    private int maxVinilos = 100;
    private ArrayList<Vinilo> vinilos;

    public ColeccionVinilo() {
        vinilos = new ArrayList<>();
    }

    public void addVinilo(Vinilo vinilo) {
        if (espaciosVacios()>0) {
            vinilos.add(vinilo);
        }
    }

    public int espaciosVacios(){
        return maxVinilos - vinilos.size();
    }
    public int getVinilos(){
        return vinilos.size();
    }

    public Boolean estaVinilo(Vinilo vinilo){
        for (Vinilo vinilo1 : vinilos) {
            if (vinilo1.equals(vinilo)) {
                return true;
            }
        }
        return false;
    }







}
