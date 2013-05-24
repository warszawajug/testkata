package pl.testkata.marekk.service;

/**
 generation of report wast a lot time
 */
public class ReportService {
    /**
     * very slow method
     * @return
     */
    public String generate() {
       slowMethod();
       return "report generated";
    }

    private void slowMethod()  {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
