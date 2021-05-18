package org.acme.getting.started;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.config.spi.ConfigSource;

public class InMemoryConfigSource implements ConfigSource {

    private Map<String, String> prop = new HashMap<String, String>();

    public InMemoryConfigSource() {
        this.prop.put("greetings.message", "Memory Hello");
    }

    /* 
    * Darle una preferencia de carga a los valores, es decir, como más grande sea ese valor de esa propiedad, más preferencía tendrá
    */
    @Override
    public int getOrdinal() {
        /* 
        * Este valor "machaca" el application.properties
        */
        return 900;
    }

    @Override
    public Map<String, String> getProperties() {

        return this.prop;
    }

    @Override
    public String getValue(String propertyName) {

        return this.prop.get(propertyName);
    }

    @Override
    public String getName() {
        return "InMemoryConfigSource";
    }
    
}
