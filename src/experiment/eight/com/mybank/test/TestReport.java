package experiment.eight.com.mybank.test;

import experiment.eight.com.mybank.data.DataSource;
import experiment.eight.com.mybank.report.CustomerReport;

import java.io.File;

/**
 * @author liyajun
 * @date 2022/5/2 13:38
 */
public class TestReport {
    public static void main(String[] args) {
        File file = new File("src\\experiment\\eight\\com\\mybank\\TestData\\test.dat");
        DataSource ds = new DataSource();
        ds.loadData(file);
        CustomerReport cs = new CustomerReport();
        cs.generateReport();
    }
}
