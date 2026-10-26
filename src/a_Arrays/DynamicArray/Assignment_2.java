package a_Arrays.DynamicArray;

public class Assignment_2 {
    public void assignment2() {
        DynArray arr = new DynArray(5);
        arr.displayArray();

        for(int i=0;i<3;i++){
            arr.insert(i,i+1);
        }
//        arr.displayArray();//1,2,3,4,5,0,0
//        arr.insert(5,6);
//        arr.displayArray();
//
//        arr.append(6);//1,2,3,4,5,6,0
//        arr.displayArray();
//
//        arr.append(7);

        //edit
//        arr.edit(1,7);
//        arr.displayArray();


        //delete
        arr.delete(1);
        arr.delete(1);
        arr.displayArray();
    }

}

class DynArray{
    int[] arr;
    int lastIndex;

    public DynArray(){
        lastIndex=-1;
        arr=new int[1];
    }

    public DynArray(int size) {
        lastIndex = -1;
        arr = new int[size];
    }

    void grow(){
        int[] temp = new int[arr.length*2];
        for(int i=0; i <= lastIndex; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    void shrink(){
        int[] temp = new int[arr.length/2];
        for(int i=0; i <= lastIndex; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void append(int data){
        if(isFull()){
            grow();
        }
        arr[lastIndex+1] = data;
        lastIndex++;
    }

    public void insert(int index, int data) {
        try{
            if(index < 0 || index > lastIndex+1){
                throw new ArrayIndexOutOfBoundsException("Invalid Index Exception");
            }
            else if (isFull()){
                grow();
            }

            for(int i = lastIndex; i>=index;i--){
                arr[i+1]=arr[i];
            }
            arr[index] = data;
            lastIndex++;
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public void edit(int index, int newData) {
        try{
            if(index < 0 || index > lastIndex+1){
                throw new ArrayIndexOutOfBoundsException("Invalid Index Exception");
            }
            arr[index] = newData;
        }  catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(int index) {
        try{
            if(index < 0 || index > lastIndex+1){
                throw new ArrayIndexOutOfBoundsException("Invalid Index Exception");
            }
            for(int i = index; i <lastIndex; i++){
                arr[i] = arr[i+1];
            }
            lastIndex--;
            if(arr.length > 1 && lastIndex+1 == arr.length/2){
                shrink();
            }
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public int totalNoOfElements() {
        return lastIndex+1;
    }

    public boolean isEmpty() {
        return lastIndex == -1;
    }

    public boolean isFull(){
        return lastIndex + 1 == arr.length;
    }

    public int getValue(int index){
        try{
            if(index < 0 || index > lastIndex+1){
                throw new ArrayIndexOutOfBoundsException("Invalid Index Exception");
            }
            return arr[index];
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int getCapacity(){
        return arr.length;
    }

    public void displayArray(){
        for(int i=0;i<=lastIndex;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
