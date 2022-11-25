package fr.xamez.aventuriersrail.rails;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ServiceDuJeu extends Service<Void> {
    private Jeu jeu;

    public ServiceDuJeu(String[] nomJoueurs) {
        jeu = new Jeu(nomJoueurs);
    }

    @Override
    protected Task<Void> createTask() {
        return getJeu();
    }

    public Jeu getJeu() {
        return jeu;
    }

}