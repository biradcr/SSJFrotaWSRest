/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import br.edu.ifsul.ws.CORSFilter;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ubiratan
 */
@javax.ws.rs.ApplicationPath("servico")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(CORSFilter.class);
        resources.add(br.edu.ifsul.ws.CORSFilter.class);
        resources.add(br.edu.ifsul.ws.SSJFrotaWS.class);
    }
    
}
