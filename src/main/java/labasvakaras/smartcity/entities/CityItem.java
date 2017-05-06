package labasvakaras.smartcity.entities;

/**
 *
 * @author Vasilis Naskos
 */
public class CityItem {
    
    private String id;
    
    private double longitude;
    
    private double latitude;
    
    private int type;

    public CityItem() {
    }

    public CityItem(Builder b) {
        this.id = b.id;
        this.longitude = b.longitude;
        this.latitude = b.latitude;
        this.type = b.type;
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
    
    public static class Builder {
        private String id;
        private double longitude;
        private double latitude;
        private int type;
        
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
        
        public CityItem build() {
            return new CityItem(this);
        }
    }
}
