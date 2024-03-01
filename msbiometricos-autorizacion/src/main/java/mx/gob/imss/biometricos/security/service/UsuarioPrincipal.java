package mx.gob.imss.biometricos.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import mx.gob.imss.biometricos.security.dto.UsuarioDto;
import mx.gob.imss.biometricos.security.jwt.JwtTokenFilter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
	private final static Logger logger = LoggerFactory.getLogger(UsuarioPrincipal.class);
    private String nombre;
    private String nombreUsuario;
    private String delegacion;
    private String subdelegacion;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    
    public UsuarioPrincipal(String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities, String delegacion, String subdelegacion) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.delegacion=delegacion;
        this.subdelegacion=subdelegacion;        		
    }

  //  public static UsuarioPrincipal build(Usuario  usuario){
    	//aqui asignamos los privilegios del usuario
        //List<GrantedAuthority> authorities =  usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
    public static UsuarioPrincipal build(UsuarioDto usuario){ 	
    	logger.info("UsuarioPrincipal build");
    	 List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(usuario.getPerfiles());
    	 logger.info("authorities: " + authorities.toString());
    	 logger.info("usuario: " + usuario.toString());
    	 
      //  return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), authorities);
    	  return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), authorities, usuario.getDelegacion(), usuario.getSubdelegacion() );
    }

    
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

	public String getDelegacion() {
		return delegacion;
	}

 

	public String getSubdelegacion() {
		return subdelegacion;
	}

 
    
    
    
    
}
