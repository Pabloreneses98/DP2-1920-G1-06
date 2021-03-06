package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Property;
import org.springframework.samples.petclinic.repository.PropertyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropertyService {

	
	private PropertyRepository propertyRepository;	
	
	@Autowired
	public PropertyService(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}	
	
	@Transactional(readOnly = true)
	public Collection<Property> findAll() throws DataAccessException {
		return propertyRepository.findAll();
	}

	public Property findPropertyById(int propertyId) {
		
		return propertyRepository.findPropertyById(propertyId);
	}
	
	@Transactional
	public void saveProperty(Property property) throws DataAccessException {
		propertyRepository.save(property);		
	}
	
//	@Transactional
//	public void removeProperty(Property property) throws DataAccessException {
//		propertyRepository.remove(property);		
//	}
	
	@Transactional
	public void deleteProperty(Property property) throws DataAccessException {
		propertyRepository.delete(property);		
	}
	
	
	public Collection<Property> findPropertyByLocation(String location) {
		return propertyRepository.findPropertyByLocation(location);
	}
	
	

}
