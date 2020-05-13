/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.UsuarioDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class TestLogin {
    private static ValidarLogin validarLogin = new ValidarLogin();
    
    private String LONG_NOMBRE_INCORRECTA = "Longitud nombre incorrecta";
    private String LONG_PASSWORD_INCORRECTA = "Longitud contraseña incorrecta";
    private String DATOS_INCORRECTOS = "Datos incorrectos";
    private String USUARIO_AUTORIZADO = "Bienvenido";
    
    public TestLogin() {
        
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
       // UsuarioDAO dao = new UsuarioDAO();
        // ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        // Usuario a = new Usuario();
        // Usuario b = new Usuario();
        // Usuario c = new Usuario();
        
        // a.setNombre("Juan");
        // a.setPassword("1234");
        // b.setNombre("Diego");
        // b.setPassword("123");
        // c.setNombre("Maria");
        // c.setPassword("12345");
        
        // usuarios.add(a);
        // usuarios.add(b);
        // usuarios.add(c);
        
        
        // for (Usuario usuario: usuarios) {
           //  System.out.println(usuario.getNombre());
           //  System.out.println(usuario.getPassword());
           //  System.out.println("-----------------");
            // dao.crear(usuario);
        // }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testLongitudNombre() {
        Usuario u = new Usuario();
        u.setNombre("R");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarlogin(u), LONG_NOMBRE_INCORRECTA);
    }
    
    @Test
    public void testLongitudContrasenia() {
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setPassword("12");
        assertEquals(validarLogin.verificarlogin(u), LONG_PASSWORD_INCORRECTA);
        
        u.setNombre("Pepe");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarlogin(u), LONG_PASSWORD_INCORRECTA);
    }
    
    @Test
    public void testNombre() {
        Usuario u = new Usuario();
        u.setNombre("Henry");
        u.setPassword("12345");
        assertEquals(validarLogin.verificarlogin(u), DATOS_INCORRECTOS);
    }
    
    @Test
    public void testContrasenia() {
        Usuario u = new Usuario();
        u.setNombre("Maria");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarlogin(u), DATOS_INCORRECTOS);
    }
    
    @Test
    public void testDatos() {
        Usuario u = new Usuario();
        u.setNombre("Henry");
        u.setPassword("A234");
        assertEquals(validarLogin.verificarlogin(u), DATOS_INCORRECTOS);
    }
    
    @Test
    public void testTodoCorrecto() {
        Usuario u = new Usuario();
        u.setNombre("Juan");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarlogin(u), USUARIO_AUTORIZADO);
        
        u.setNombre("Pedro");
        u.setPassword("123");
        assertEquals(validarLogin.verificarlogin(u), USUARIO_AUTORIZADO);
        
        u.setNombre("Maria");
        u.setPassword("12345");
        assertEquals(validarLogin.verificarlogin(u), USUARIO_AUTORIZADO);
    }
}
