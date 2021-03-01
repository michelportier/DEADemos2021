package oose.dea.dao;

import oose.dea.domain.Jedi;

import javax.enterprise.inject.Alternative;

@Alternative
public class JediDAOMongoDB implements IJediDAO{
    @Override
    public Jedi getJedi(int id) {
        // we should go to the database here, but we won't do that until tomorrow
        Jedi jedi =  new Jedi(id);
        jedi.setName("Robert");
        jedi.setDark(false);
        jedi.setBsn("235896");

        return jedi;
    }
}
