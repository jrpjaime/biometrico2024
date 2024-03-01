package mx.gob.imss.biometricos.service;

import java.util.List;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.gob.imss.biometricos.model.BicRole;

public interface  BicRoleService { 

	public BicRole findBicRoleByCveIdRole(Long cveIdRole);

	public List<BicRole> findAllBicRole();

	public Page<BicRole> findAllBicRole(Pageable pageable);

	public List<BicRole> findBicRoleByDesRole(String desRole);

	public BicRole saveBicRole(BicRole bicRole);

	public void deleteBicRole(BicRole bicRole);

	public List<BicRole> findAllBicRoleOrderByDesRole();

	public List findBicRoleByCveIdUsuario(Long cveIdUsuario);
}
