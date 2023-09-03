class Solution {
    /*
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if(n < 4){
            return ans;
        }

        for(int i = 0 ; i <= n-4; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j = i+1 ; j < n; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int k = j+1;
                int l = n-1;

                while(k < l){
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        Collections.sort(list);
                        if(!ans.contains(list)){
                            ans.add(list);
                        }

                        while(k<l && nums[l]==nums[l+1]){
                            l--;
                        }
                        while(k<l&&nums[k]==nums[k-1]){
                            k++;
                        }
                    }
                    else if(sum > target){
                        l--;
                    }
                    else{
                        k++;
                    }
                }
            }
        }
        return ans;
    }
    */

    /*

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        if (nums[0] * 4 > target || nums[n - 1] * 4 < target) {
            return ans; // Return an empty list when target is impossible to achieve.
        }

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];


                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                        
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }
    
*/

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> q=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n-3;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            for(int j=i+1;j<n;j++)
            {
                if(j>i+1 && nums[j] == nums[j-1])
                {
                    continue;
                }
                int k=j+1;
                int l=n-1;
                while(k<l)
                {
                   long sum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
                //    sum += nums[j];
                //    sum += nums[k];
                //    sum += nums[l];
                   if(target==sum)
                   {
                       ArrayList<Integer> al=new ArrayList<>();
                       al.add(nums[i]);
                       al.add(nums[j]);
                       al.add(nums[k]);
                       al.add(nums[l]);
                       Collections.sort(al);
                       q.add(al);
                       k++;
                       l--;
                   
                    while(k<l&&nums[l]==nums[l+1]){
                        l--;
                    }

                    while(k<l&&nums[k]==nums[k-1]){
                        k++;
                    }

                   }
                   else if(sum<target)
                   {
                       k++;
                   }
                   else
                   {
                       l--;
                   }
                }
            }
        }
        return q;
    }
      
       

}