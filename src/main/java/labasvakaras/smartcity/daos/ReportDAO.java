package labasvakaras.smartcity.daos;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import labasvakaras.smartcity.Configurator;
import labasvakaras.smartcity.entities.Report;
import org.bson.Document;

/**
 *
 * @author Vasilis Naskos
 */
public class ReportDAO {
    
    private static final String COLLECTION = "reports";
    
    /**
     * Inserts a new report to the DB
     * 
     * @param report contains all data for insertion
     */
    public static void insertReport(Report report) {
        Document newDocument = new Document();
        newDocument.append("priority", report.getComment())
                .append("comment", report.getComment())
                .append("resolved", report.isResolved())
                .append("city_item_id", report.getCityItemId());

        if (report.getReportDate() != null) {
            newDocument.append("report_date", report.getReportDate().getTime());
        }
        if (report.getResolveDate() != null) {
            newDocument.append("resolve_date", report.getResolveDate().getTime());
        }

        MongoDatabase db = Configurator.INSTANCE.getDatabase();
        MongoCollection collection = db.getCollection(COLLECTION);
        collection.insertOne(newDocument); //TODO check if succeeds
    }

    /**
     * Returns all reports
     * 
     * @return List
     */
    public static List<Report> findReports() {
        MongoDatabase db = Configurator.INSTANCE.getDatabase();
        MongoCollection collection = db.getCollection(COLLECTION);

        List<Report> reports = new ArrayList<>();
        
        FindIterable<Document> result = collection.find();
        result.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                Report.Builder b = new Report.Builder();
                b.comment(document.getString("comment"))
                        .cityItemId(document.getString("city_item_id"))
                        .priority(document.getInteger("priority"))
                        .resolved(document.getBoolean("resolved"))
                        .reportDate(document.getDate("report_date"));
                reports.add(b.build());
            }
        });
        
        return reports;
    }
    
}