import java.util.*;

class TokenBucket {
    int tokens;
    long lastRefill;

    TokenBucket(int max) {
        tokens = max;
        lastRefill = System.currentTimeMillis();
    }
}

class RateLimiter {

    HashMap<String, TokenBucket> map = new HashMap<>();
    int MAX = 5;

    public boolean allow(String client) {

        map.putIfAbsent(client, new TokenBucket(MAX));
        TokenBucket bucket = map.get(client);

        long now = System.currentTimeMillis();

        // refill every 10 sec
        if (now - bucket.lastRefill > 10000) {
            bucket.tokens = MAX;
            bucket.lastRefill = now;
        }

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }
}