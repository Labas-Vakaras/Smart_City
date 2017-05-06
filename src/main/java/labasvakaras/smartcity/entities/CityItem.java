package labasvakaras.smartcity.entities;

import java.util.Date;

/**
 *
 * @author Vasilis Naskos
 */
public class CityItem {
    
    private String id;
    private double longitude;
    private double latitude;
    private int type;
    private String description;
    private String priority; //TODO change this maybe to enum
    private String comment;
    private boolean resolved;
    private Date report_date;
    private Date resolve_date;

    public CityItem() {
    }

    public CityItem(Builder b) {
        this.id = b.id;
        this.longitude = b.longitude;
        this.latitude = b.latitude;
        this.type = b.type;
        this.description = b.description;
        this.priority = b.priority;
        this.comment = b.comment;
        this.resolved = b.resolved;
        this.report_date = b.report_date;
        this.resolve_date = b.resolve_date;
    }


    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public Date getResolve_date() {
        return resolve_date;
    }

    public void setResolve_date(Date resolve_date) {
        this.resolve_date = resolve_date;
    }

    public static class Builder {
        private String id;
        private double longitude;
        private double latitude;
        private int type;
        private String description;
        private String priority; //TODO change this maybe to enum
        private String comment;
        private boolean resolved;
        private Date report_date;
        private Date resolve_date;
        
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        
        public Builder longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }
        
        public Builder latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }
        
        public Builder type(int type) {
            this.type = type;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
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

        public Builder report_date(Date report_date) {
            this.report_date = report_date;
            return this;
        }

        public Builder resolve_date(Date resolve_date) {
            this.resolve_date = resolve_date;
            return this;
        }

        public CityItem build() {
            return new CityItem(this);
        }
    }
}
