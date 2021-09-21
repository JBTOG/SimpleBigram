public class Main {
    public static void main(String[] args){

        System.out.println("Start\n\n");

        Util util = new Util();
        util.loadTextFileToString("testFiles/testFile3.txt");

        System.out.println(util.getText());

        util.getWords(util.getText());
        util.createBigrams();
        util.populateHistrogram();
    }
}
