class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> res = new ArrayList<Integer>();
        while (head!=null){
            res.add(head.val);
            head=head.next;
        }
        int n = res.size();
        for (int i=0; i<res.size()/2;i++){
            if (res.get(i)!=res.get(n-1-i)){
                return false;
            }
        }
        return true;      
    }
}
