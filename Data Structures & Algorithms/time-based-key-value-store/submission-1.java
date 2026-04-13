class TimeMap {
    Map<String, List<Pair<Integer, String>>> keystore;

    public TimeMap() {
        keystore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!keystore.containsKey(key)) {
            keystore.put(key, new ArrayList<>());
        }

        keystore.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> list = keystore.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = list.size() - 1;
        String result = "";

        while(left <= right) {
            int middle = left + (right - left) / 2;

            if(list.get(middle).getKey() <= timestamp) {
                result = list.get(middle).getValue();
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }

        return result;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
