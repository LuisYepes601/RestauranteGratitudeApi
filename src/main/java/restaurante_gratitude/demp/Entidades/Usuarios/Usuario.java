/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Usuarios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Identificaciones.Identificacion;
import restaurante_gratitude.demp.Entidades.Direccion.Direccion;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Genero;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Sexo;
import restaurante_gratitude.demp.Entidades.Cuenta.Estado_cuenta;
import restaurante_gratitude.demp.Entidades.Devoluciones.Devolucion;
import restaurante_gratitude.demp.Entidades.OfertsCupons.Cupones.UsoCupon;
import restaurante_gratitude.demp.Entidades.PQRS.PQRS;
import restaurante_gratitude.demp.Entidades.Pedidos.DetallePedido;
import restaurante_gratitude.demp.Entidades.Pedidos.Pedido;
import restaurante_gratitude.demp.Entidades.Preferencias.Preferencia;
import restaurante_gratitude.demp.Entidades.Productos.ProductosFavoritos;
import restaurante_gratitude.demp.Entidades.RangoCalificacion.CalficacionProducto;
import restaurante_gratitude.demp.Entidades.ReportesProblema.ReporteProblema;
import restaurante_gratitude.demp.Entidades.Reservas.Reserva;
import restaurante_gratitude.demp.Entidades.Roles.Rol;

/**
 *
 * @author Usuario
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String primerNombre;

    private String segundoNombre;

    @Column(nullable = false)
    private String primerApellido;

    @Column(nullable = false)
    private String segundoApellido;

    @Column()
    private String telefono;

    @Column(nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "id_identificacion")
    private Identificacion identificacion;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @OneToOne
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;

    private String foto_perifl;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "id_sexo")
    private Sexo sexo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaRegistro;

    @Column(nullable = false)
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_estado_cuenta")
    private Estado_cuenta estado_cuenta;

    @OneToMany(mappedBy = "usuario")
    private List<ReporteProblema> reporteProblemas;

    @ManyToOne
    @JoinColumn(name = "id_preferencias")
    private Preferencia preferencia;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "usuario")
    private List<PQRS> pqrses;

    @OneToMany(mappedBy = "usuario")
    private List<Devolucion> devoluciones;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "usuario")
    private List<UsoCupon> usoCupones;

    @OneToMany(mappedBy = "usuario")
    private List<CalficacionProducto> calficacionProductos;

    @OneToMany(mappedBy = "usuario")
    private List<DetallePedido> detallePedidos;

    @OneToMany(mappedBy = "usuario")
    private List<ProductosFavoritos> productosFavoritos;

    @OneToOne(mappedBy = "Usuario")
    private Empleado empleado;

    public Usuario(int id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String telefono, String email, Identificacion identificacion, Rol rol, Direccion direccion, String foto_perifl, Date fechaNacimiento, String contraseña, Genero genero, Sexo sexo, Date fechaRegistro, boolean estado, Estado_cuenta estado_cuenta, List<ReporteProblema> reporteProblemas, Preferencia preferencia, List<Reserva> reservas, List<PQRS> pqrses, List<Devolucion> devoluciones, List<Pedido> pedidos, List<UsoCupon> usoCupones, List<CalficacionProducto> calficacionProductos, List<DetallePedido> detallePedidos, List<ProductosFavoritos> productosFavoritos, Empleado empleado) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.email = email;
        this.identificacion = identificacion;
        this.rol = rol;
        this.direccion = direccion;
        this.foto_perifl = foto_perifl;
        this.fechaNacimiento = fechaNacimiento;
        this.contraseña = contraseña;
        this.genero = genero;
        this.sexo = sexo;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.estado_cuenta = estado_cuenta;
        this.reporteProblemas = reporteProblemas;
        this.preferencia = preferencia;
        this.reservas = reservas;
        this.pqrses = pqrses;
        this.devoluciones = devoluciones;
        this.pedidos = pedidos;
        this.usoCupones = usoCupones;
        this.calficacionProductos = calficacionProductos;
        this.detallePedidos = detallePedidos;
        this.productosFavoritos = productosFavoritos;
        this.empleado = empleado;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getFoto_perifl() {
        return foto_perifl;
    }

    public void setFoto_perifl(String foto_perifl) {
        this.foto_perifl = foto_perifl;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Estado_cuenta getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(Estado_cuenta estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }

    public List<ReporteProblema> getReporteProblemas() {
        return reporteProblemas;
    }

    public void setReporteProblemas(List<ReporteProblema> reporteProblemas) {
        this.reporteProblemas = reporteProblemas;
    }

    public Preferencia getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Preferencia preferencia) {
        this.preferencia = preferencia;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<PQRS> getPqrses() {
        return pqrses;
    }

    public void setPqrses(List<PQRS> pqrses) {
        this.pqrses = pqrses;
    }

    public List<Devolucion> getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(List<Devolucion> devoluciones) {
        this.devoluciones = devoluciones;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<UsoCupon> getUsoCupones() {
        return usoCupones;
    }

    public void setUsoCupones(List<UsoCupon> usoCupones) {
        this.usoCupones = usoCupones;
    }

    public List<CalficacionProducto> getCalficacionProductos() {
        return calficacionProductos;
    }

    public void setCalficacionProductos(List<CalficacionProducto> calficacionProductos) {
        this.calficacionProductos = calficacionProductos;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public List<ProductosFavoritos> getProductosFavoritos() {
        return productosFavoritos;
    }

    public void setProductosFavoritos(List<ProductosFavoritos> productosFavoritos) {
        this.productosFavoritos = productosFavoritos;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
