package mx.gob.imss.biometricos.security.service;

import mx.gob.imss.biometricos.model.BitUsuario;
import mx.gob.imss.biometricos.security.dto.UsuarioDto; 
import mx.gob.imss.biometricos.security.service.UsuarioPrincipal;
import mx.gob.imss.biometricos.service.BitUsuarioService;
import mx.gob.imss.biometricos.security.jwt.JwtTokenFilter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
   @Autowired
   BitUsuarioService bitUsuarioService;
    
 

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
    	logger.info("Inicia UserDetailsServiceImpl loadUserByUsername   nombreUsuario. "+nombreUsuario);
    	/*
    	logger.info("1nombreUsuario "+ nombreUsuario);
    	UserBuilder builder = null;
    	String prefijo=nombreUsuario.substring(0, 5);
    	
    	logger.info("prefijo "+ prefijo);
    	
    	 boolean accesofiel=false;
        if(prefijo.trim().equals("**#**")) {
        	//para este prefijo entra la sesión sin restricciones
        	logger.info("Entro a **#** ");
        	accesofiel=true;
        	nombreUsuario=nombreUsuario.substring(5, nombreUsuario.length()).trim(); 
        }
        
        logger.info("2 nombreUsuario "+ nombreUsuario);
    	
        */
    	BitUsuario usuario = bitUsuarioService.findBitUsuarioByDesUsuarioUnico(nombreUsuario) ;
    	
    	
    	logger.info("usuario.getDesNombre(): "+ usuario.getDesNombre());
    	logger.info("usuario.getClaveEntFed() "+ usuario.getClaveEntFed()); 
    	
    	

    	 
     PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	
    	//String hashedPassword = usuario.getDesPassword();
    	//String hashedPassword = passwordEncoder.encode(nombreUsuario);
        String hashedPassword ="";
    	
    	 UsuarioDto usuarioDto = new UsuarioDto();
    	 usuarioDto.setNombre(usuario.getDesNombre());
    	 usuarioDto.setDelegacion("Delegación 1 ");
    	 usuarioDto.setSubdelegacion("Subdelegación 1 ");
    	 usuarioDto.setNombreUsuario(nombreUsuario);
    	
    	 usuarioDto.setPerfiles("VENTANILLA CE,APROBADOR");
    	 
    	 
    	 /*
	      if(accesofiel) {
	    	  logger.info("FIEL" ); 
			      hashedPassword =new BCryptPasswordEncoder().encode(nombreUsuario);
			       
				    List<String> roles = new ArrayList<>();
				    roles.add("VENTANILLA");
				    return  User.withUsername(nombreUsuario).password(hashedPassword).roles(StringUtils.toStringArray(roles)).build();
				    
	      } else {
	    	  logger.info("SIN FIEL" ); 
	      hashedPassword = usuario.getDesPassword();
	     
	      }
	      */
    	  hashedPassword = usuario.getDesPassword();
	      usuarioDto.setPassword(hashedPassword);
	      
	      

     	logger.info("Termina UserDetailsServiceImpl loadUserByUsername");  
        return UsuarioPrincipal.build(usuarioDto); 
        
    }
}
