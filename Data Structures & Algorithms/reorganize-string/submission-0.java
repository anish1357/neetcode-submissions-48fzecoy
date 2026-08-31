class Solution {

    public String reorganizeString(String s) {
      int[] freq = new int[26];
      for(char c : s.toCharArray()){
        freq[ c - 'a']++;
      }
      int n = s.length();
    int maxFreq = 0;
    for (int f : freq) maxFreq = Math.max(maxFreq, f);
    if (maxFreq > (n + 1) / 2) return "";
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> 
      b[0] - a[0]);
      for( int i  = 0 ; i< 26 ; i++){
        if(freq[i] > 0 )
        pq.offer(new int[]{ freq[i], i, 0});
      }
      int index = 0 ; 
      Queue<int[]> q = new LinkedList<>(); 
      StringBuilder ans = new StringBuilder();

      while(!pq.isEmpty() || !q.isEmpty()){
        if(pq.isEmpty()){
          index = q.peek()[2];
        }else{
            index++;
            int[] val = pq.poll();
            ans.append((char)(val[1]  + 'a'));
            int cnt = val[0] -1;
            if(cnt > 0 ){
                q.offer(new int[]{ cnt, val[1] ,index + 1});
            }
        }

            if(!q.isEmpty() && q.peek()[2] == index ){
                   int[] tmp = q.poll();
                pq.offer(new int[]{tmp[0] ,tmp[1]});
            }
      }
      return String.valueOf(ans);
    }
}