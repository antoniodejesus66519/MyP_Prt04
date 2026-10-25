package filtro;

import rockBuster.Producto;

public class FiltroGenero implements FiltroProducto {

    private String genero;

    public FiltroGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean cumpleCriterio(Producto producto) {
        if (producto == null || this.genero == null) {
            return false;
        }
        return producto.genero().equalsIgnoreCase(this.genero);
    }

    public void fijarGenero(String genero) {
        this.genero = genero;
    }
}