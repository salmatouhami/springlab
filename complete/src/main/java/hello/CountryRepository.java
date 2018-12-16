 package hello;

import org.springframework.data.repository.CrudRepository;

import hello.model.Country;

public interface CountryRepository extends CrudRepository<Country,String >{

}
