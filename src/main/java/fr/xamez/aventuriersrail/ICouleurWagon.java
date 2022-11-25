package fr.xamez.aventuriersrail;

import fr.xamez.aventuriersrail.rails.CouleurWagon;

public interface ICouleurWagon {
    static ICouleurWagon[] values() {
        return CouleurWagon.values();
    }
}