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
         int l = 0 , h = mountainArr.length() -1 ;
         while(l <= h){
            int m = (l +h)/2;
            int mCall = mountainArr.get(m);
            int mPlusCall = mountainArr.get(m+1);
            int mMinusCall = mountainArr.get(m-1);
            if(mCall > mPlusCall && mCall > mMinusCall)
            return m ;
            else if (mCall < mPlusCall){
                l = m + 1;
            }else {
                h = m - 1;
            }

         }
         return -1 ;
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