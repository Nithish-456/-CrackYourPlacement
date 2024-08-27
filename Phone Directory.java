class Solution {
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        // Convert contact array to a TreeSet to automatically store unique strings in sorted order
        TreeSet<String> contact_set= new TreeSet<>(Arrays.asList(contact));
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        // Iterate over each prefix of the string s
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            prefix.append(s.charAt(i));
            
            // Find contacts that match the current prefix
            ArrayList<String> matches = new ArrayList<>();
            for (String c : contact_set) {
                // Use prefix.toString() to get the current prefix
                if (c.startsWith(prefix.toString())) {
                    matches.add(c);
                }
            }

            // If no matches found, add "0" as a single entry in the list
            if (matches.isEmpty()) {
                matches.add("0");
            }

            result.add(matches);
        }
        
        return result;
    }
}
