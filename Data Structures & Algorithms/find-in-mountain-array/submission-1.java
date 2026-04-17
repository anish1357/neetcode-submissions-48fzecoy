/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {


        public int findPeakElement(MountainArray mountainArr) {
        int low = 0;
        int high = mountainArr.length() - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (mountainArr.get(mid) < mountainArr.get(mid+1)) {
                // Uphill: peak is on the right
                low = mid + 1;
            } else {
                // Downhill: peak is here or on the left
                high = mid;
            }
        }
        
        return low; // low == high == peak index
    }
    public int binarySearch(int l , int h , int target ,MountainArray mountainArr, boolean flag){
        while(l<= h){
            int m = (l +h)/2;
            int mCall = mountainArr.get(m);
            if(mCall == target)
            return m;
            else if (mCall > target ){
                if(flag){
                h = m - 1 ;
                }else{ 
                l = m +1 ;
                }
            }else {
                if(flag){
                    l = m +1 ;
                } else {
                    h= m -1;
                }

            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int index = findPeakElement(mountainArr);

        return binarySearch(0,index,target,mountainArr,true) == -1 ? 
        binarySearch(index +1 , mountainArr.length() -1 ,target,mountainArr,false) : binarySearch(0,index,target,mountainArr,true);
    }
}