package a_Arrays.Array.Assignments;

public class Assignment_1 {
    public void assignment1(){
        Array arr = new Array(7);
        arr.displayArray();

        //insert
        for(int i=0;i<5;i++){
            arr.insert(i,i+1);
        }
        arr.displayArray();

        //append
        arr.append(6);
        arr.displayArray();

        //edit
        arr.edit(1,7);
        arr.displayArray();

        //delete
        arr.delete(1);
        arr.displayArray();

        //totalNoOfElements
        System.out.println("Total Elements in Array: " + arr.totalNoOfElements());

        //check empty or not
        System.out.println("Array is Empty: " + arr.isEmpty());

        //check full or not
        System.out.println("Array is Full: " + arr.isFull());

        //get value by index
        arr.getValue(1);

        //get Capacity
        System.out.println("Array Capacity: " + arr.getCapacity());

        //check Space in Array
        System.out.println("Array Space: " + arr.checkSpace());
    }
}

class Array {
    private int lastIndex;
    private int[] arr;

    public Array(int size) {
        lastIndex = -1;
        arr = new int[size];
    }

    public void append(int data) {
        try{
            arr[lastIndex+1] = data;
            lastIndex++;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Array is already full, cannot add more values");
        }
    }

    public void insert(int index, int data) {
        try{
            if(index < 0 || index > lastIndex+1){
                throw new ArrayIndexOutOfBoundsException("Invalid Index Exception");
            }
            for(int i = lastIndex; i>=index;i--){
                arr[i+1]=arr[i];
            }
            arr[index]=data;
            lastIndex++;
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public void edit(int index, int newData) {
        try{
            if(index < 0 || index > lastIndex){
                throw new ArrayIndexOutOfBoundsException("Invalid Index Exception");
            }
            arr[index] = newData;
        }  catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(int index) {
        try{
            if(index < 0 || index > lastIndex){
                throw new ArrayIndexOutOfBoundsException("Invalid Index Exception");
            }
            for(int i = index; i <= lastIndex; i++){
                arr[i] = arr[i+1];
            }
            lastIndex--;
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
            if(index < 0 || index > lastIndex){
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

    public int checkSpace(){
        return arr.length - (lastIndex + 1);
    }

    public void displayArray(){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
