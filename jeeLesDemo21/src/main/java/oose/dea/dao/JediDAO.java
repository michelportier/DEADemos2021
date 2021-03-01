package oose.dea.dao;

import oose.dea.domain.Jedi;

import javax.enterprise.inject.Default;

@Default
public class JediDAO implements IJediDAO {

    @Override
    public Jedi getJedi(int id){
        // we should go to the database here, but we won't do that until tomorrow
        Jedi jedi =  new Jedi(id);
        jedi.setName("Thijmen");
        jedi.setDark(false);
        jedi.setBsn("12345");

        return jedi;
    }
}
