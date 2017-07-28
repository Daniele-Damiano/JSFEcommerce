/**
 *
 * @author Daniele Damiano  26-lug-2017 20.17.47
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.webservice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rs")
public class ConfiguraWebServizio extends Application {

    private final Set<Class<?>> classes;

    public ConfiguraWebServizio() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(WebServizio.class);

        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
