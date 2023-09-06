package AmazonOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
import java.util.regex.*;

public class BlackListIP {
    public static List<Integer> vaildateRequest(List<String> blacklisted_ips, List<String> request){
        List<String> black = blacklisted_ips.stream().map(s->s.replace(".", "")).map(s->s.replace("*",".")).collect(Collectors.toList());
        int size = request.size();
        List<Integer> res = new ArrayList<>();
        int[] is_blocked = new int[size];
        for(int i=0;i<request.size();i++){
            String cur = request.get(i);
            for(int j =0;j<black.size();j++)
            {
                String temp = black.get(j);
                if(cur.contains(temp)){
                    is_blocked[i] = 1;
                    res.add(i,1);
                    break;
                }
            }
        }
        return res;
    }

    public static List<Integer> isBlocked(int n, String[] blacklisted_ips, int q, String[] requests) {
        Set<String> blockedIPs = new HashSet<>();
        Map<String, Integer> requestCounts = new HashMap<>();
        Map<String, List<Long>> requestTimestamps = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String request = requests[i];
            long timestamp = System.currentTimeMillis();

            // Remove old timestamps
            requestTimestamps.forEach((ip, timestamps) -> timestamps.removeIf(t -> timestamp - t >= 5000));

            // Check if the request matches any blacklisted IP regex
            boolean isBlacklisted = false;
            for (String ipRegex : blacklisted_ips) {
                if (matchesIP(ipRegex, request)) {
                    isBlacklisted = true;
                    break;
                }
            }

            if (isBlacklisted) {
                blockedIPs.add(request);
                requestCounts.put(request, 0); // Reset count for blocked request
                result.add(1);
            } else {
                // Check if the request should be blocked due to request count
                requestCounts.put(request, requestCounts.getOrDefault(request, 0) + 1);
                if (requestCounts.get(request) >= 2) {
                    // Check if there are any previous requests in the last 5 seconds
                    boolean blocked = requestTimestamps.keySet().stream()
                            .filter(ip -> !ip.equals(request))
                            .anyMatch(ip -> requestCounts.getOrDefault(ip, 0) >= 2);
                    if (blocked) {
                        blockedIPs.add(request);
                        requestCounts.put(request, 0); // Reset count for blocked request
                        result.add(1);
                    } else {
                        result.add(0);
                    }
                } else {
                    result.add(0);
                }
            }

            // Update request timestamps
            List<Long> timestamps = requestTimestamps.getOrDefault(request, new ArrayList<>());
            timestamps.add(timestamp);
            requestTimestamps.put(request, timestamps);
        }

        return result;
    }

    private static boolean matchesIP(String ipRegex, String ip) {
        ipRegex = ipRegex.replace("*", ".*");
        return Pattern.matches(ipRegex, ip);
    }
        public static void main(String[] args) {
            int n = 3;
            String[] blacklisted_ips = {"*111.*", "123.*", "34.*"};
            int q = 7;
            String[] requests = {"123.1.23.34", "121.1.23.34", "121.1.23.34", "34.1.23.34", "121.1.23.34", "12.1.23.34", "121.1.23.34"};

            List<Integer> result = isBlocked(n, blacklisted_ips, q, requests);
            System.out.println(result); // Output: [1, 0, 0, 1, 1, 0, 0]
        }


//    public static void main(String[] args) {
//        String[] str = {"*111.*", "123.*", "34."};
//        List<String> list = Arrays.asList(str);
//        List<String> newList1 = list.stream().map(s -> s.replace(".","")).map(s -> s.replace("*",".")).collect(Collectors.toList());
//
//        List<String> newList2 = list.stream().map(s -> s.replace("*",".")).collect(Collectors.toList());
//        System.out.println(list);
//        System.out.println(newList1);
//        System.out.println(newList2);
//    }
}
