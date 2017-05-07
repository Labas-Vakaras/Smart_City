package labasvakaras.smartcity.entities;

/**
 *
 * @author Vasilis Naskos
 */
public class ReportViewObject {
    private final String id;
    private final String priority;
    private final String cityItemId;
    private final String resolveDate;
    private final String resolved;

    public ReportViewObject(String id, String priority,
            String cityItemId, String resolveDate, String resolved) {
        this.id = id;
        this.priority = priority;
        this.cityItemId = cityItemId;
        this.resolveDate = resolveDate;
        this.resolved = resolved;
    }
    
    public String getId() {
        return id;
    }

    public String getPriority() {
        return priority;
    }

    public String getCityItemId() {
        return cityItemId;
    }

    public String getResolveDate() {
        return resolveDate;
    }

    public String getResolved() {
        return resolved;
    }
}
