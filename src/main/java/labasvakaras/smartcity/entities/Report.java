package labasvakaras.smartcity.entities;

import java.util.Date;

/**
 *
 * @author Vasilis Naskos
 */
public class Report {
    
    private String id;
    private String cityItemId;
    private int priority;
    private String comment;
    private boolean resolved;
    private Date reportDate;
    private Date resolveDate;

    public Report() {
    }
    
    public Report(Builder b) {
        this.id = b.id;
        this.cityItemId = b.cityItemId;
        this.priority = b.priority;
        this.comment = b.comment;
        this.resolved = b.resolved;
        this.reportDate = b.reportDate;
        this.resolveDate = b.resolveDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getCityItemId() {
        return cityItemId;
    }

    public void setCityItemID(String cityItemID) {
        this.cityItemId = cityItemID;
    }
    
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date report_date) {
        this.reportDate = report_date;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolve_date) {
        this.resolveDate = resolve_date;
    }
    
    public static class Builder {
        private String id;
        private String cityItemId;
        private int priority;
        private String comment;
        private boolean resolved;
        private Date reportDate;
        private Date resolveDate;
        
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        
        public Builder cityItemId(String cityItemId) {
            this.cityItemId = cityItemId;
            return this;
        }
        
        public Builder priority(int priority) {
            this.priority = priority;
            return this;
        }

        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder resolved(boolean resolved) {
            this.resolved = resolved;
            return this;
        }

        public Builder reportDate(Date reportDate) {
            this.reportDate = reportDate;
            return this;
        }

        public Builder resolveDate(Date resolveDate) {
            this.resolveDate = resolveDate;
            return this;
        }
        
        public Report build() {
            return new Report(this);
        }
    }
}
