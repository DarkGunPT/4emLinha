package jogo.logica.dados;

import jogo.logica.memento.CareTaker;

import java.io.*;

public class GuardaCarrega {


    public static void guardar(Jogo jogo, CareTaker careTaker, File nome) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nome));
            Object[] objectsnew = {jogo,careTaker};
            oos.writeObject(objectsnew);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarReplay(Jogo jogo, CareTaker careTaker, File nome) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nome));
            Object[] objectsnew = {jogo,careTaker};
            oos.writeObject(objectsnew);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object[] carrega(File nome) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nome));
            Object[] objectsnew = (Object[]) ois.readObject();
            ois.close();
            return objectsnew;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Object[] carregaReplay(File nome){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nome));
            Object[] objectsnew = (Object[]) ois.readObject();
            ois.close();
            return objectsnew;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}