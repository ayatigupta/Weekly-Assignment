import java.util.*;

/**
 * Username Availability System
 * Demonstrates HashMap usage for O(1) lookup and frequency tracking
 */
class UsernameSystem {

    // Stores username -> userId
    private HashMap<String, Integer> users = new HashMap<>();

    // Stores username -> attempt count
    private HashMap<String, Integer> attempts = new HashMap<>();

    /**
     * Check if username is available (O(1))
     */
    public boolean checkAvailability(String username) {

        // Track attempts
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);

        // Check existence
        return !users.containsKey(username);
    }

    /**
     * Register user
     */
    public void register(String username, int userId) {
        users.put(username, userId);
    }

    /**
     * Suggest alternative usernames
     */
    public List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        // Try adding numbers
        for (int i = 1; i <= 3; i++) {
            String suggestion = username + i;
            if (!users.containsKey(suggestion)) {
                suggestions.add(suggestion);
            }
        }

        // Try modifying with dot
        String dotVersion = username.replace("_", ".");
        if (!users.containsKey(dotVersion)) {
            suggestions.add(dotVersion);
        }

        return suggestions;
    }

    /**
     * Get most attempted username
     */
    public String getMostAttempted() {

        String maxUser = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : attempts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxUser = entry.getKey();
            }
        }

        return maxUser + " (" + maxCount + " attempts)";
    }

    // Demo
    public static void main(String[] args) {

        UsernameSystem system = new UsernameSystem();

        // Pre-existing users
        system.register("john_doe", 1);
        system.register("admin", 2);

        // Check availability
        System.out.println("john_doe → " + system.checkAvailability("john_doe"));
        System.out.println("jane_smith → " + system.checkAvailability("jane_smith"));

        // Suggestions
        System.out.println("Suggestions for john_doe: " +
                system.suggestAlternatives("john_doe"));

        // Simulate multiple attempts
        for (int i = 0; i < 5; i++) {
            system.checkAvailability("admin");
        }

        System.out.println("Most Attempted: " + system.getMostAttempted());
    }
}