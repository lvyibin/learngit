public class SortClss {
    public static void quickSort(int[] list,int left,int right){
        if (left>right) return;
        int head=left,end=right;
        int base=list[left];
        while(head!=end){
            while (list[end]>base&&head<end){
                end--;
            }
            while (list[head]<base&&head<end){
                head++;
            }
            if (head<end){
                list[head]=list[head]+list[end];
                list[end]=list[head]-list[end];
                list[head]=list[head]-list[end];
            }
        }
        //list[head]=base;
        quickSort(list,left,head-1);
        quickSort(list,head+1,right);
    }
    public static void main(String[] args){
        int[] list={16,7,3,20,17,8,9,4,10,100,1};
        //buildMaxHeap(list);
        quickSort(list,0,list.length-1);
        for(int item:list){
            System.out.println(item);
        }
    }
}
