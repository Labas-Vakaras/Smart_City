package labasvakaras.smartcity.entities;

import java.util.Date;

/**
 *
 * @author Vasilis Naskos
 */
public class Report {
    
    private String cityItemID;
    private String priority;
    private String comment;
    private boolean resolved;
    private Date reportDate;
    private Date resolveDate;

    public Report() {
    }
    
    public Report(Builder b) {
        this.cityItemID = b.cityItemId;
        this.priority = b.priority;
        this.comment = b.comment;
        this.resolved = b.resolved;
        this.reportDate = b.reportDate;
        this.resolveDate = b.resolveDate;
    }

    public String getCityItemId() {
        return cityItemID;
    }

    public void setCityItemID(String cityItemID) {
        this.cityItemID = cityItemID;
    }
    
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
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
        private String cityItemId;
        private String priority; //TODO change this maybe to enum
        private String comment;
        private boolean resolved;
        private Date reportDate;
        private Date resolveDate;
        
        public Builder cityItemId(String cityItemId) {
            this.cityItemId = cityItemId;
            return this;
        }
        
        public Builder priority(String priority) {
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

        public Builder reportDate(Date report_date) {
            this.reportDate = report_date;
            return this;
        }

        public Builder resolveDate(Date resolve_date) {
            this.resolveDate = resolve_date;
            return this;
        }
        
        public Report build() {
            return new Report(this);
        }
    }
}
