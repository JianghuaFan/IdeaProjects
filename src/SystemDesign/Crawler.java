package SystemDesign;

import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Crawler {
    void process (URL seed){
        Queue<URL> queue = new LinkedList<>();
        Set<URL> visited = new HashSet<>();
        queue.offer(seed);
        visited.add(seed);


    }
}
