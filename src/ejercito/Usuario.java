package ejercito;

public class Usuario extends Identificable{

    private String nombre;
    private Cuerpo tipoCuerpo;
    private Compania comp;
    private Cuartel cuart;
    private Gestion db;

    public Usuario(int codigo) {
        super(codigo);
    }

    public Usuario(int codigo,String nombre, Cuerpo tipoCuerpo, Compania comp, Cuartel cuart, Gestion db) {
        super(codigo);
        this.nombre = nombre;
        this.tipoCuerpo = tipoCuerpo;
        this.comp = comp;
        this.cuart = cuart;
        this.db = db;
    }

    // Métodos getter para acceder a los atributos privados
    @Override
    public int getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public Cuerpo getTipoCuerpo() {
        return tipoCuerpo;
    }
    
    public Compania getComp() {
        return comp;
    }
    
    public Cuartel getCuart() {
        return cuart;
    }

    public Gestion getDb() {
        return db;
    }

    public void MostrarDatos(){
        System.out.println("Codigo Usuario: " + this.codigo);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Cuerpo: " + this.tipoCuerpo.getDenominacion_cuerpo()); // Suponiendo que Cuerpo tiene getNombre()
        System.out.println("Compania: " + this.comp.getDenominacion_compania()); // Suponiendo que Compania tiene getDenominacion()
        System.out.println("Cuartel: " + this.cuart.getNombre_cuartel()); 
    }
}
