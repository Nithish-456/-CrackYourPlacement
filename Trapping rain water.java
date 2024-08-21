class Solution {
    public int trap(int[] height) {
        int res=0;
        int lmax=0,rmax=0,l=0,r = height.length-1;
        while(l<r){
            if(height[l]<height[r]){
                if(lmax>height[l]) res+=lmax-height[l];
                else lmax=height[l];
                l++;
            }else{
                if(rmax>height[r]) res+=rmax-height[r];
                else rmax=height[r];
                r--;
            }
        }
        return res;        
    }
}
