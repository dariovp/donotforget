package donotforget.ServerWrapper;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.util.List;

import donotforget.commons.Categoria;
import donotforget.commons.Evento;
import donotforget.remote.Categorias;
import donotforget.remote.Eventos;

public class ServerWrapper {
    private Registry reg;

    public List<Categoria> getCategorias() {
        try {
            this.reg = LocateRegistry.getRegistry(null);
            Categorias cat = (Categorias) reg.lookup("categorias-server");
            return cat.getCategorias();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addCategoria(Categoria c) {
        try {
            this.reg = LocateRegistry.getRegistry(null);
            Categorias cat = (Categorias) reg.lookup("categorias-server");
            if(cat.addCategoria(c)) {
                System.out.println("true en sw");
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeCategoria(int id) {
        try {
            this.reg = LocateRegistry.getRegistry(null);
            Categorias eventsStub = (Categorias) reg.lookup("categorias-server");
            return eventsStub.removeCategoria(id);
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addEvent(Evento e) {
        try {
            this.reg = LocateRegistry.getRegistry(null);
            Eventos eventos = (Eventos) reg.lookup("events-server");
            if (eventos.addEvent(e)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Evento> getEventsFromMonth(LocalDate month, List<Categoria> categorias) {
        try {
            this.reg = LocateRegistry.getRegistry(null);
            Eventos eventsStub = (Eventos) reg.lookup("events-server");
            return eventsStub.getEventsFromMonth(month, categorias);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Evento> getEventsFromDay(LocalDate day, List<Categoria> categorias) {
        try {
            this.reg = LocateRegistry.getRegistry(null);
            Eventos eventsStub = (Eventos) reg.lookup("events-server");
            return eventsStub.getEventsFromDay(day, categorias);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean removeEvent(int id) {
        try {
            this.reg = LocateRegistry.getRegistry(null);
            Eventos eventsStub = (Eventos) reg.lookup("events-server");
            return eventsStub.removeEvent(id);
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
