package org.batfish.representation.azure;

import java.io.Serializable;

public class Resource implements Serializable {

    private final String _name;
    private final String _id;
    private final String _type;

    public static Resource create(
            String id,
            String type,
            String name) {
        return new Resource(id, type, name);
    }

    public Resource(String name, String id, String type) {
        _name = name;
        _id = convertId(id);
        _type = type;
    }

    public static String convertId(String id){
        String[] parts = id.split("/");

        // subscription id - resourceGroup name - Resource name
        return String.format("%s-%s-%s", parts[2], parts[4], parts[8]);
    }

    public String getName() {
        return _name;
    }

    public String getId() {
        return _id;
    }

    public String getType() {
        return _type;
    }


}
