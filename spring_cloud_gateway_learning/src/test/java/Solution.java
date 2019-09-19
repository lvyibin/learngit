import java.util.*;

import static java.lang.Math.max;

public class Solution {

    /*public static int maxProduct(String[] words) {
       // List<Integer> list=new ArrayList<>();
        *//*int max=0;
        outter:for (int i =0 ;i<words.length-1;i++){

           inner: for(int j=i+1;j<words.length;j++){
                for (String item:words[j].split("")){
                    if (words[i].contains(item))
                            continue inner;
                }
               //list.add(words[i].length()*words[j].length());
               if (words[i].length()*words[j].length()>max){
                   max=words[i].length()*words[j].length();
               }
            }
        }
        return max;*//*


        if(words.length<=1) return 0;

        //vector<int> arr(words.length, 0);
        int[] arr=new int[words.length];
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                int ij=1<<(words[i].charAt(j)-'a');
                arr[i] = (arr[i] |ij);
            }
        }
        int res = 0;
        for(int i=0; i<words.length; i++){
            //cout<<arr[i]<<' ';
            for(int j=i+1; j<words.length; j++){
                // judge whether there exists common alphabets between the two words.
                if((arr[i]&arr[j])==0){
                    res = max(res, (int)(words[i].length()*words[j].length()));
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        //String sr="abc";
        //String[] srs=sr.split("");
        String[] words={"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
        int count=maxProduct(words);
        System.out.println(count);
    }*/

    static int res=-1;
    public static int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        if(null==nums||nums.length==0|| Arrays.binarySearch(nums,target)<0){
            return res;
        }
        if(nums.length==1&&nums[0]==target){
            res[0]=0;res[1]=0;
            return res;
        }
        int low=0,high=nums.length-1;
        int firt=searchFirstPosition(nums,low,high,target);
        int last=searchLastPosition(nums,low,high,target);
        res[0]=firt;res[1]=last;
        return res;
    }

    private static int searchFirstPosition(int[] nums,int low,int high,int target){
        while(low<high){
            int mid=low+(high-low)/2;
            res= mid;
            int midValue=nums[mid];
            if(midValue>=target){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return res;
    }

    private static int searchLastPosition(int[] nums,int low,int high,int target){
        while(low<high){
            int mid=low+(high-low)/2;
            int midValue=nums[mid];
            res= mid;
            if(target>=midValue){
                low=mid+1;


            }else{

                high=mid;
            }
            //res=searchFirstPosition(nums,low,high,target);
        }
        return low;
    }
    public static void main(String[] args){
        int[] arr={1,2,2,4};
        int target=2;
        int[] res=searchRange(arr,target);
        System.out.println(res[0]+"-"+res[1]);
    }
}
