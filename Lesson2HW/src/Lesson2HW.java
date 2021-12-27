public class Lesson2HW{

    private static final int REQUIRED_ARRAY_SIZE = 4;

    private static final String[][] CORRECT_DATA = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
    };

    private static final String[][] INCORRECT_SIZE_DATA = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "7", "8"},
            {"9", "10", "11"},
            {"13", "14", "15", "16"}
    };

    private static final String[][] INCORRECT_VALUE_DATA = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "aasd", "7", "8"},
            {"9", "10", "asd", "12"},
            {"13", "fff", "15", "16"}
    };

    private static int sumArrayValues(String[][] data){
        checkArray(data);
        
        int result = 0;

        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
            String[] row = data[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                String stringValue = row[colIndex];
                try{
                    result = Integer.parseInt(stringValue);
                }catch(NumberFormatException e){
                    throw new ArrayDataExceptionHW(stringValue, rowIndex, colIndex);
                }
            }
        }

        return result;
    }

    private static void checkArray(String[][] data){
        if(data.length != REQUIRED_ARRAY_SIZE){
            throw new ArraySizeException();
        }

        for (String[] row : data){
            if(row.length != REQUIRED_ARRAY_SIZE){
                throw new ArraySizeException();
            }
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Результат сложения значений массива: " + sumArrayValues(INCORRECT_VALUE_DATA));
        } catch (ArraySizeException | ArrayDataExceptionHW e) {
            System.out.println(e.getMessage());
        }
    }

}
