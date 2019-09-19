import java.util.List;

public class HeapClass {


    //构建大顶堆
    public static void buildMaxHeap(int[] list){
        initalMaxHeap(list,list.length);
        for(int item:list){
            System.out.println(item);
        }
    }

    //堆排序
    public static void sort(int[] list){
        /**
         * 1.初始化大顶堆initialMaxHeap
         * 2.将堆顶元素与最后一个叶节点交换swap
         * 3.重新构建大顶堆，重复1，2步骤
         */
        int count=list.length;
        while(count>0){
            initalMaxHeap(list,count);
            swap(list,0,count-1);
            for(int item:list){
                System.out.println(item);
            }
            System.out.println("******************");
            count--;
        }
    }

    static void initalMaxHeap(int[] list,int count){
        int node=count/2 -1;
        while(node>-1){
            //以node位置为非叶子节点的父节点开始调整，即比较父节点，左节点，右节点，将最大的节点与父节点交换
            adjustNode(list,node,count);
            node--;
        }
    }

    static void adjustNode(int[] list,int node,int count){
        int parent=list[node];
        if (node*2+1>=count){
            return;
        }
        int left=list[node*2+1];
        if (node*2+2<count){
            int right=list[node*2+2];
            if (left>parent&&left>right){
                list[node]=left;
                list[node*2+1]=parent;
                adjustNode(list,node*2+1,count);
            }if (right>parent&&right>left){
                list[node]=right;
                list[node*2+2]=parent;
                adjustNode(list,node*2+2,count);
            }
        }else{
            if (left>parent){
                list[node]=left;
                list[node*2+1]=parent;
                adjustNode(list,node*2+1,count);
            }
        }
    }

    static void swap(int[] list,int top,int end){
        list[top]=list[top]+list[end];
        list[end]=list[top]-list[end];
        list[top]=list[top]-list[end];

    }

    public static void main(String[] args){
        int[] list={16,7,3,20,17,8,9,4,10,100,1};
        buildMaxHeap(list);
        sort(list);
        System.out.println("******************");
        for(int item:list){
            System.out.println(item);
        }
    }
}
