import java.util.*;

class PlagiarismDetector {

    private HashMap<String, Set<String>> index = new HashMap<>();

    // Generate n-grams
    private List<String> getNGrams(String text, int n) {
        String[] words = text.split(" ");
        List<String> grams = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {
            String gram = String.join(" ", Arrays.copyOfRange(words, i, i + n));
            grams.add(gram);
        }
        return grams;
    }

    // Add document
    public void addDocument(String docId, String text) {
        for (String gram : getNGrams(text, 3)) {
            index.putIfAbsent(gram, new HashSet<>());
            index.get(gram).add(docId);
        }
    }

    // Compare similarity
    public int checkSimilarity(String text, String docId) {
        int match = 0;
        List<String> grams = getNGrams(text, 3);

        for (String gram : grams) {
            if (index.containsKey(gram) && index.get(gram).contains(docId)) {
                match++;
            }
        }

        return (match * 100) / grams.size();
    }
}