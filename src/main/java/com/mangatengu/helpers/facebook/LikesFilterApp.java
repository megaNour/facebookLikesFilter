package com.mangatengu.helpers.facebook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class LikesFilterApp {
    public static final String ELIMINATOR = "en commun";
    public static void main(String[] args) {
        Set<String> listeFinale = new TreeSet<>();
        Path origine = Paths.get(args[0]);
        Path destination = Paths.get(args[1]);
        
        try(FileReader fr = new FileReader(origine.toFile());){
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.endsWith(ELIMINATOR) && !line.equals("Inviter"))
                listeFinale.add(line);
            }
            
            
            PrintStream ps = new PrintStream(destination.toFile());
            Iterator<String> i = listeFinale.iterator();
            while (i.hasNext()) {
                String result = i.next();
                ps.println(result);
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
