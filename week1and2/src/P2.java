import java.util.*;

 class AnalyticsSystem {

    HashMap<String, Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueUsers = new HashMap<>();
    HashMap<String, Integer> sources = new HashMap<>();

    public void processEvent(String url, String user, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueUsers.putIfAbsent(url, new HashSet<>());
        uniqueUsers.get(url).add(user);

        sources.put(source, sources.getOrDefault(source, 0) + 1);
    }

    public void showDashboard() {
        System.out.println("Page Views: " + pageViews);
        System.out.println("Unique Users: " + uniqueUsers);
        System.out.println("Sources: " + sources);
    }
}