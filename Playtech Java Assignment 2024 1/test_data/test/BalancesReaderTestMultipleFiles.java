package test_data.test;

public class BalancesReaderTestMultipleFiles {

    private static int expectedTotalRecords;

    public static void main(String[] args) {
        testReadBalancesFromMultipleFiles();
    }

    public static void testReadBalancesFromMultipleFiles() {
        String[] fileNames = {"balances1.csv", "balances2.csv", "balances3.csv"};
        int totalRecordsExpected = 0;

        // Loeme andmed kõigist failidest
        for (String fileName : fileNames) {
            List<Balances> balancesList = (List<Balances>) BalancesReader.readBalances(fileName);
            totalRecordsExpected += balancesList.size();

            // Võite siin lisada täiendavaid kontrollimisi vastavalt vajadusele

            // Kontrollime, kas loetud andmed vastavad oodatule
            System.out.println("File: " + fileName + ", Records read: " + balancesList.size());
        }

        // Kontrollime, kas kõigi failide loetud kirjete koguarv vastab oodatule
        if (totalRecordsExpected == expectedTotalRecords) {
            System.out.println("Test successful: Correct number of records read from all files.");
        } else {
            System.out.println("Test failed: Incorrect number of records read from all files.");
        }
    }
}
