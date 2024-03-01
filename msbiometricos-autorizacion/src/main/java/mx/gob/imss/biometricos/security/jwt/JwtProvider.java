package mx.gob.imss.biometricos.security.jwt;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import mx.gob.imss.biometricos.security.dto.JwtDto;
import mx.gob.imss.biometricos.security.dto.UsuarioDto;
import mx.gob.imss.biometricos.security.service.UsuarioPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;
    
    

    public String generateToken(Authentication authentication){
    	logger.info("JwtProvider generateToken"); 
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        List<String> roles = usuarioPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        logger.info("Jwts.builder"); 
        return Jwts.builder()
                .setSubject(usuarioPrincipal.getUsername())
                .claim("nombre", usuarioPrincipal.getNombre())
                .claim("delegacion", usuarioPrincipal.getDelegacion())
                .claim("subdelegacion", usuarioPrincipal.getSubdelegacion())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }
    
    
    public String generateTokenUsuario(UsuarioPrincipal usuarioPrincipal){
    	logger.info("JwtProvider UsuarioPrincipal usuarioPrincipal generateToken");  
        List<String> roles = usuarioPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        logger.info("Jwts.builder"); 
        return Jwts.builder()
                .setSubject(usuarioPrincipal.getUsername())
                .claim("nombre", usuarioPrincipal.getNombre())
                .claim("delegacion", usuarioPrincipal.getDelegacion())
                .claim("subdelegacion", usuarioPrincipal.getSubdelegacion())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
        	logger.info("JwtProvider.validateToken");
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);
            logger.info("Token valido");
            return true;
        }catch (MalformedJwtException e){
            logger.error("token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("Token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("Token expirado");
        }catch (IllegalArgumentException e){
            logger.error("Token vacío");
        }catch (SignatureException e){
            logger.error("Error en la firma");
        }
        logger.info("Token NO valido");
        return false;
    }

    public String refreshToken(JwtDto jwtDto) throws ParseException {
        JWT jwt = JWTParser.parse(jwtDto.getToken());
        JWTClaimsSet claims = jwt.getJWTClaimsSet();
        String nombreUsuario = claims.getSubject(); 
        String nombre = (String) claims.getClaim("nombre");
        String delegacion = (String) claims.getClaim("delegacion");
        String subdelegacion = (String) claims.getClaim("subdelegacion");
        
        List<String> roles = (List<String>)claims.getClaim("roles");
        logger.error("refreshToken: ");
        
        logger.error("nombreUsuario: "+ nombreUsuario);
        logger.error("nombre: "+ nombre);
        logger.error("delegacion: "+ delegacion);
        logger.error("subdelegacion: "+ subdelegacion); 
        logger.error("roles: "+ roles);
        
        
        return Jwts.builder()
                .setSubject(nombreUsuario) 
                .claim("nombre", nombre)
                .claim("delegacion", delegacion)
                .claim("subdelegacion", subdelegacion)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }
    
    
 
}
