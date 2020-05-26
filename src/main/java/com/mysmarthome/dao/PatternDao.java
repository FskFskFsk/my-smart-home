package com.mysmarthome.dao;

import com.mysmarthome.entities.Pattern;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PatternDao {
    private static Map<Integer, Pattern> patterns=null;


    static{
        patterns=new HashMap<Integer, Pattern>();
        patterns.put(101,new Pattern(101,"制冷"));
        patterns.put(102,new Pattern(102,"制热"));
        patterns.put(103,new Pattern(103,"送风"));

    }

    public Collection<Pattern> getPatterns(){
        return patterns.values();
    }
    public Pattern getPattern(Integer id){
        return patterns.get(id);
    }
}
