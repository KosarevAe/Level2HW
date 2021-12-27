public class ArrayDataExceptionHW extends RuntimeException{

    public ArrayDataExceptionHW(String cellValue, int rowIndex, int colIndex){
        super(String.format("Неверное значение '%s' в ячейке [%d][%d]", cellValue, rowIndex, colIndex));
    }

}
