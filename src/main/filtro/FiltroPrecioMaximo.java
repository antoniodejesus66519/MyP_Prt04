package filtro;

import rockBuster.Producto;

public class FiltroPrecioMaximo implements FiltroProducto {

    private double precio;

    public FiltroPrecioMaximo(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean cumpleCriterio(Producto producto) {
        if (producto == null) {
            return false;
        }
        return producto.precio() <= this.precio;
    }

    public void fijarPrecio(int precio) {
        this.precio = precio;
    }

    public void fijarPrecio(double precio) {
        this.precio = precio;
    }
}