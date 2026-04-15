class TimeMap {
    public record DataRecord(Integer timestamp, String value){}
    HashMap<String, List<DataRecord>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       
        List<DataRecord> dataRecords = store.getOrDefault(key, new ArrayList<>());
        dataRecords.add(new DataRecord(timestamp, value));
        store.put(key,dataRecords);
    }
    
    public String get(String key, int timestamp) {
        if(store.containsKey(key)){
          List<DataRecord> dataRecords = store.get(key);
          int n = dataRecords.size();
          int l = 0 , h = n -1 , ans = -1;
          while(l <= h){
            int m = (l+h)/2;
            if(timestamp == dataRecords.get(m).timestamp()){
                return dataRecords.get(m).value();
            }else if(dataRecords.get(m).timestamp() < timestamp){
                ans = m;
                l = m +1; 
            }else {
                h = m-1 ;
            }
          }
          return ans == -1 ? "": dataRecords.get(ans).value(); 
        }else {
            return "";
        }
    }
}
