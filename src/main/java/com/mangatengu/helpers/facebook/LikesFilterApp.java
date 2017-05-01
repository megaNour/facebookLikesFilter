package com.mangatengu.helpers.facebook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LikesFilterApp {
    public static final String EN_COMMUN = "en commun";
	public static final String INVITER = "inviter";
	public static final String AIME_DEJA = "aime déjà";
    public static Set<String> unwanted;
    static {
    	 unwanted = new TreeSet<>();
    	 unwanted.add(EN_COMMUN);
    	 unwanted.add(INVITER);
    	 unwanted.add(AIME_DEJA);
    }
    public static void main(String[] args) {
        Map<String, Integer> listeNonClassee = new HashMap<>();
        Set<LikesPerPerson> listeClassee = new TreeSet<>(new LikesComparator());
        Path origine = Paths.get(args[0]);
        Path destination = Paths.get(args[1]);
        
        try(FileReader fr = new FileReader(origine.toFile());){
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
            	boolean accepted = true; 
            	for(String s : unwanted) {
            		if (line.toLowerCase().contains(s.toLowerCase()) || line.isEmpty()) {
            			accepted = false;
            		}
            	}
                if (accepted) {
                	Integer i = listeNonClassee.get(line);
                	System.out.println(i + " :::: " + line);
                	if(i != null) listeNonClassee.put(line, i+1);
                	else listeNonClassee.put(line, 1);
                }
            }
            for (String s : listeNonClassee.keySet()) {
            	System.out.println(s + " " + listeNonClassee.get(s));
            	boolean putted = listeClassee.add(new LikesPerPerson(s, listeNonClassee.get(s)));
            	System.out.println(putted);
            }
            PrintStream ps = new PrintStream(destination.toFile());
            Iterator<LikesPerPerson> i = listeClassee.iterator();
            while (i.hasNext()) {
                LikesPerPerson result = i.next();
                ps.println(result);
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
