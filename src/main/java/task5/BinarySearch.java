package task5;


public class BinarySearch {
    public static int search(int[] array, int key, int start, int end) {
       /* int index = (start + end) / 2;
        if (index == start) return index;
        else if (key >= array[index]) {
            start = index;
            if (end - start == 1) return end;
            return search(array, key, start, end);
        } else {
            end = index - 1;
            return search(array, key, start, end);
        }*/
       int index = (start + end) / 2;
       if(key==array[index]) return index;
       else if(key>array[index]){
           start = index + 1;
           return search(array, key, start, end);
       } else{
           end = index-1;
           return search(array, key, start, end);
       }
    }
}
