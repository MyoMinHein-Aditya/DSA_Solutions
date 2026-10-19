class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        Map<String, Integer> emailToId = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToId.containsKey(email)) {
                    union(parent, i, emailToId.get(email));
                } else {
                    emailToId.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> merged = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int root = find(parent, emailToId.get(email));
            merged.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (int i : merged.keySet()) {
            List<String> emails = merged.get(i);
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(i).get(0));
            account.addAll(emails);
            result.add(account);
        }
        return result;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }

    private void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) parent[rootI] = rootJ;
    }
}
