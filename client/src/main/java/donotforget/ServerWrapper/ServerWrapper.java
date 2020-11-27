package donotforget.ServerWrapper;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import donotforget.commons.Categoria;
import donotforget.remote.Categorias;

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
            Categorias cat = (Categorias) reg.lookup("Hello");
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
}
