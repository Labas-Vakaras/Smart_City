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

    public CityItem() {
    }

    public CityItem(Builder b) {
        this.id = b.id;
        this.longitude = b.longitude;
        this.latitude = b.latitude;
        this.type = b.type;
        this.description = b.description;
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
    
    public String getTypeAsString() {
        String strType = CityItemType.values()[type].toString();
        strType = strType.replace("_", " ");
        strType = strType.toLowerCase();
        return strType;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description == null ? "" : description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {
        private String id;
        private double longitude;
        private double latitude;
        private int type;
        private String description;
        
        
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

        public CityItem build() {
            return new CityItem(this);
        }
    }
}
