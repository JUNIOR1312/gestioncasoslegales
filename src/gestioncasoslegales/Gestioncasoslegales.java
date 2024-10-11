package gestioncasoslegales;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gestioncasoslegales {

    public interface ModuloMonitoreo {
        void recolectarDatos();
    }

    public static class ModuloDenuncias implements ModuloMonitoreo {
        @Override
        public void recolectarDatos() {
            System.out.println("Recoleccion de datos de denuncias.");
            Random random = new Random();
            int denunciasRegistradas = 10 + random.nextInt(41);
            System.out.println("Denuncias registradas: " + denunciasRegistradas);
        }
    }

    public static class ModuloAccesoLegal implements ModuloMonitoreo {
        @Override
        public void recolectarDatos() {
            System.out.println("Recoleccion de datos de acceso legal.");
            Random random = new Random();
            int consultasLegales = 5 + random.nextInt(16);
            System.out.println("Consultas legales realizadas: " + consultasLegales);
        }
    }

    public static class ModuloTransparencia implements ModuloMonitoreo {
        @Override
        public void recolectarDatos() {
            System.out.println("Recoleccion de datos de transparencia.");
            Random random = new Random();
            int reportesTransparencia = random.nextInt(101);
            System.out.println("Nivel de transparencia detectado: " + reportesTransparencia + "%");
        }
    }

    public static class Gestion {

        private List<ModuloMonitoreo> modulos;

        public Gestion() {
            this.modulos = new ArrayList<>();
        }

        public void agregarModulo(ModuloMonitoreo modulo) {
            modulos.add(modulo);
        }

        public void recolectarDatos() {
            for (ModuloMonitoreo modulo : modulos) {
                modulo.recolectarDatos();
            }
        }
    }

    public static void main(String[] args) {
        Gestion gestion = new Gestion();

        gestion.agregarModulo(new ModuloDenuncias());
        gestion.agregarModulo(new ModuloAccesoLegal());
        gestion.agregarModulo(new ModuloTransparencia());

        gestion.recolectarDatos();
    }
}
